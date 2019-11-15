package com.linus.express.order.web;

import com.linus.express.order.bean.CommonResponse;
import com.linus.express.order.bean.Customer;
import com.linus.express.order.bean.OrderQueryCondition;
import com.linus.express.order.bean.PageableData;
import com.linus.express.order.dao.entity.Order;
import com.linus.express.order.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
@RequestMapping("/api/customer")
public class CustomerController {

    @PostMapping("/query")
    public CommonResponse<PageableData<Customer>> query(@RequestBody OrderQueryCondition condition) {
        return CommonResponse.ok();
    }
}
