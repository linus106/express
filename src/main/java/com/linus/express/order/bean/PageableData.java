package com.linus.express.order.bean;

import lombok.Data;

import java.util.List;

/**
 * @Author za-wangxiangyu
 * @Date 2019/1/16 18:21
 * @Description TODO
 */
@Data
public class PageableData<T> {

    private List<T> payload;

    private Integer count;

}
