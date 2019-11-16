package com.linus.express.order.bean;

import lombok.Data;

/**
 * @Author wangxiangyu
 * @Date 2019/11/15 15:00
 * @Description TODO
 */
@Data
public class CustomerQueryCondition {

    private String keyWord;

    private PageInfo pageInfo;
}
