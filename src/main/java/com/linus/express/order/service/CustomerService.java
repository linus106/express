package com.linus.express.order.service;

import com.linus.express.order.bean.Customer;
import com.linus.express.order.bean.CustomerQueryCondition;
import com.linus.express.order.bean.PageableData;
import com.linus.express.order.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/16
 */
@Service
public class CustomerService {

    @Autowired
    private OrderRepository orderRepository;

    public PageableData<Customer> query(CustomerQueryCondition condition) {

        List<Customer> senders = orderRepository.querySender(condition.getKeyWord());
        List<Customer> receivers = orderRepository.queryCustomer(condition.getKeyWord());
        senders.addAll(receivers);
        Set<Customer> distinctCustomers = senders.stream().collect(Collectors.toSet());

        List<Customer> customers = new ArrayList<>(distinctCustomers);
        List<Customer> page = customers.stream().skip((condition.getPageInfo().getPageNo())* condition.getPageInfo().getPageSize()).limit(condition.getPageInfo().getPageSize())
                .collect(Collectors.toList());


        PageableData<Customer> pageableData = new PageableData();
        pageableData.setCount(Long.valueOf(customers.size()));
        pageableData.setPayload(page);
        return pageableData;
    }
}
