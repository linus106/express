package com.linus.express.order.service;

import com.linus.express.order.annotation.Adapt;
import com.linus.express.order.bean.OrderQueryCondition;
import com.linus.express.order.bean.PageableData;
import com.linus.express.order.dao.entity.Order;
import com.linus.express.order.dao.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/16
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Long createOrder(Order order) {
        order.setId(null);
        order.setCreateDate(Calendar.getInstance().getTime());
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        order.setCreator(user);

        orderRepository.save(order);
        return order.getId();
    }

    public Order getOrder(Long id) {
        Order order = orderRepository.getOne(id);
        return order;
    }

    @Adapt
    public PageableData<Order> query(OrderQueryCondition condition) {
//        condition.adaptEmptyFields();//see aop package
        Page<Order> page =  orderRepository.queryByCondition(condition.getExpressNumber(),
                condition.getLogisticsCompany(), condition.getSenderInfo(), condition.getReceiverInfo(),
                condition.getPayType(), condition.getSenderArea(), condition.getReceiverArea(),
                condition.getSendTimeStart(), condition.getSendTimeEnd(),
                PageRequest.of(condition.getPageInfo().getPageNo(), condition.getPageInfo().getPageSize()));

        PageableData<Order> pageableData = new PageableData();
        pageableData.setCount(page.getTotalElements());
        pageableData.setPayload(page.getContent());
        return pageableData;
    }


    @Adapt
    public List<Order> exportExcel(OrderQueryCondition condition) {
//        condition.adaptEmptyFields();//see aop package
        Page<Order> page =  orderRepository.queryByCondition(condition.getExpressNumber(),
                condition.getLogisticsCompany(), condition.getSenderInfo(), condition.getReceiverInfo(),
                condition.getPayType(), condition.getSenderArea(), condition.getReceiverArea(),
                condition.getSendTimeStart(), condition.getSendTimeEnd(),
                Pageable.unpaged());
        return page.getContent();
    }
}
