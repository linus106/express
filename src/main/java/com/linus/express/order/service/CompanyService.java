package com.linus.express.order.service;

import com.linus.express.order.bean.Company;
import com.linus.express.order.bean.Customer;
import com.linus.express.order.bean.PageableData;
import com.linus.express.order.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/16
 */
@Service
public class CompanyService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Company> query(String keyword) {
        if (StringUtils.isEmpty(keyword)) {//adapt frontend null
            keyword = null;
        }
        List<Company> senderCompanies = orderRepository.querySenderCompany(keyword);
        List<Company> receiverCompanies = orderRepository.queryReceiverCompany(keyword);
        senderCompanies.addAll(receiverCompanies);

        Map<String, List<Company>> map = senderCompanies.stream().collect(Collectors.groupingBy(Company::getCompany));

        List<Company> distinctCompanies = map.entrySet().stream().map(e->{
            return e.getValue().stream().sorted(Comparator.comparing(Company::getCreateDate).reversed()).findFirst().get();
        }).collect(Collectors.toList());
        return distinctCompanies;
    }
}
