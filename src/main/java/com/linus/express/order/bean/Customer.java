package com.linus.express.order.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

/**
 * @Author wangxiangyu
 * @Date 2019/11/15 16:36
 * @Description TODO
 */
@Data
@AllArgsConstructor
public class Customer {

    private String name;

    private String phone;

    private String company;

    private String fixedPhone;

    private String area;

    private String address;
}
