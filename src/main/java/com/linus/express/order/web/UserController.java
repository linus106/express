package com.linus.express.order.web;

import com.linus.express.order.bean.CommonResponse;
import com.linus.express.order.dao.entity.UserInfo;
import com.linus.express.order.dao.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/2
 */
@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserInfoRepository userInfoRepository;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    @GetMapping("/{id}")
    public CommonResponse<UserInfo> info(@PathVariable("id") Long id) {
        return CommonResponse.ok(userInfoRepository.getOne(id));
    }

    @GetMapping()
    public CommonResponse<List<UserInfo>> list() {
        return CommonResponse.ok(userInfoRepository.findAll());
    }

    @PostMapping
    public CommonResponse<Long> create(@RequestBody UserInfo userInfo) {
        if (StringUtils.isEmpty(userInfo.getUserName())) {
            return CommonResponse.errorParam("账号不能为空:");
        }
        if (StringUtils.isEmpty(userInfo.getPassword())) {
            return CommonResponse.errorParam("密码不能为空:");
        }
        if (!CollectionUtils.isEmpty(userInfoRepository.findByUserName(userInfo.getUserName()))) {
            return CommonResponse.errorParam("已经存在同名的用户:" + userInfo.getUserName());
        }
        userInfo.setCreateTime(new Date());
        userInfo.setRole("user");
        userInfoRepository.save(userInfo);
        return CommonResponse.ok(userInfo.getId());
    }

    @PutMapping("/{id}")
    public CommonResponse<Long> update(@PathVariable("id") Integer id, @RequestBody UserInfo userInfo) {
        userInfoRepository.save(userInfo);
        return CommonResponse.ok(userInfo.getId());
    }

    @DeleteMapping("/{id}")
    public CommonResponse delete(@PathVariable("id") Long id) {
        userInfoRepository.deleteById(id);
        return CommonResponse.ok();
    }
}
