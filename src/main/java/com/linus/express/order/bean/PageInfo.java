package com.linus.express.order.bean;

import lombok.Data;

import javax.validation.constraints.Min;


/**
 * @Author wangxiangyu
 * @Date 2019/11/15 15:01
 * @Description TODO
 */
@Data
public class PageInfo {


    private Integer pageNo;

    @Min(value = 1, message = "Page size must not be less than one!")
    private Integer pageSize;

}
