package com.linus.express.order.web;

import com.alibaba.excel.EasyExcel;
import com.linus.express.order.bean.*;
import com.linus.express.order.dao.entity.Order;
import com.linus.express.order.service.CompanyService;
import com.linus.express.order.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/2
 */
@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/query")
    public CommonResponse<List<Company>> query(@RequestParam("keyword") String keyword) {
        return CommonResponse.ok(companyService.query(keyword));
    }


    @PostMapping("/excel")
    public void exportExcel(@RequestParam(value = "keyword", required = false) String keyword,
                            HttpServletResponse response) throws IOException {
        List<Company> companies = companyService.query(keyword);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("company", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Company.class).sheet("模板").doWrite(companies);
    }
}
