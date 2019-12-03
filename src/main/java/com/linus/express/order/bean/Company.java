package com.linus.express.order.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author wangxiangyu
 * @Date 2019/11/15 16:36
 * @Description TODO
 */
@Data
@AllArgsConstructor
public class Company {

    @ExcelProperty("公司名称")
    private String company;

    @ExcelProperty("地区")
    private String area;

    @ExcelProperty("详细地址")
    private String address;

    @ExcelProperty("创建时间")
    private Date createDate;

    @ExcelProperty("创建者")
    private String creator;

    @ExcelProperty("固定电话")
    private String fixedphone;
}
