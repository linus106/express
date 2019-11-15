package com.linus.express.order.web;

import com.linus.express.order.bean.CommonResponse;
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
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    @GetMapping("/{id}")
    public CommonResponse<Order> info(@PathVariable("id") Long id) {
        return CommonResponse.ok(orderRepository.getOne(id));
    }

    @GetMapping()
    public CommonResponse<List<Order>> list() {
        return CommonResponse.ok(orderRepository.findAll());
    }

    @PostMapping
    public CommonResponse<Long> create(@RequestBody Order order) {
        orderRepository.save(order);
        return CommonResponse.ok(order.getId());
    }

    @PutMapping("/{id}")
    public CommonResponse<Long> update(@PathVariable("id") Integer id, @RequestBody Order order) {
        orderRepository.save(order);
        return CommonResponse.ok(order.getId());
    }

    @DeleteMapping("/{id}")
    public CommonResponse delete(@PathVariable("id") Long id) {
        orderRepository.deleteById(id);
        return CommonResponse.ok();
    }

    @PostMapping("/query")
    public CommonResponse<PageableData<Order>> query(@RequestBody OrderQueryCondition condition) {
        return CommonResponse.ok();
    }
}
