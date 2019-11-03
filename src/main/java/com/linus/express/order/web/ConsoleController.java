package com.linus.express.order.web;

import com.linus.express.order.bean.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/2
 */
@RestController
public class ConsoleController {

    @GetMapping("/version")
    public CommonResponse<String> version() {
        return CommonResponse.ok("1.0");
    }

    @GetMapping("/health")
    public CommonResponse<String> health() {
        return CommonResponse.ok("ok");
    }

}
