package com.linus.express.order.web;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.linus.express.order.bean.CommonResponse;
import com.linus.express.order.bean.OrderQueryCondition;
import com.linus.express.order.bean.PageableData;
import com.linus.express.order.dao.entity.Order;
import com.linus.express.order.dao.repository.OrderRepository;
import com.linus.express.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/2
 */
@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private OrderService orderService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    @GetMapping("/{id}")
    public CommonResponse<Order> info(@PathVariable("id") Long id) {
        return CommonResponse.ok(orderService.getOrder(id));
    }

    @GetMapping()
    public CommonResponse<List<Order>> list() {
        return CommonResponse.ok(orderRepository.findAll());
    }

    @PostMapping
    public CommonResponse<Long> create(@RequestBody Order order) {
        return CommonResponse.ok(orderService.createOrder(order));
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
    public CommonResponse<PageableData<Order>> query(@Valid @RequestBody OrderQueryCondition condition) {
        return CommonResponse.ok(orderService.query(condition));
    }

    @PostMapping("/excel")
    public void exportExcel(@RequestBody OrderQueryCondition condition, HttpServletResponse response) throws IOException {
        List<Order> orders = orderService.exportExcel(condition);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("order", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Order.class).sheet("模板").doWrite(orders);
    }

    @PostMapping("/import")
    public CommonResponse<String> exportExcel(@RequestBody MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Order.class, new AnalysisEventListener() {

            @Override
            public void invoke(Object o, AnalysisContext analysisContext) {
                Order order = (Order) o;
                orderService.createOrder(order);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            }
        }).sheet().doRead();
        return CommonResponse.ok();
    }

}
