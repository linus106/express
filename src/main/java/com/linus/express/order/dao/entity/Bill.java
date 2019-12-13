package com.linus.express.order.dao.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/2
 */
@Data
public class Bill {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("寄件时间")
    private Date sendTime;

    @ExcelProperty("订单号")
    private String expressNumber;

    @ExcelProperty("物品件数")
    private Integer number;

    @ExcelProperty("重量-KG")
    private Float weight;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("运费")
    private Float freight;

    @ExcelProperty("保险费")
    private Float insuranceCost;

    @ExcelProperty("包装费")
    private Float packageCost;

    @ExcelProperty("运费小记")
    private Float totalCost;

    @ExcelProperty("寄件人_姓名")
    private String senderName;

    @ExcelProperty("部门代码")
    private String departmentCode;

    @ExcelProperty("首价")
    private Float firstPrice;

    @ExcelProperty("续价")
    private Float continuationPrice;

}
