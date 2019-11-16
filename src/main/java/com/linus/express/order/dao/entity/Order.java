package com.linus.express.order.dao.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/2
 */
@Data
@Entity
@Builder
@Table(name = "EXPRESS_ORDER")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Proxy(lazy = false)
@ApiModel
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty("主键ID")
    private Long id;

    @Column
    @ApiModelProperty(name = "订单号", example = "WY1911496012")
    @ExcelProperty("订单号")
    private String expressNumber;

    @Column
    @ApiModelProperty(name = "物品名称", example = "文件")
    @ExcelProperty("物品名称")
    private String goodsName;

    @Column
    @ApiModelProperty(name = "重量-KG", example = "0.5")
    @ExcelProperty("重量-KG")
    private Float weight;

    @Column
    @ApiModelProperty(name = "体积-M3", example = "0")
    @ExcelProperty("体积-M3")
    private Float volumn;

    @Column
    @ApiModelProperty(name = "物品件数", example = "1")
    @ExcelProperty("物品件数")
    private Integer number;

    @Column
    @ApiModelProperty(name = "备注", example = "机密文件")
    @ExcelProperty("备注")
    private String remark;

    @Column
    @ApiModelProperty(name = "包装类型-纸/纤/木/托膜/木托/其他", example = "纸")
    @ExcelProperty("包装类型")
    private String packageType;

    @Column
    @ApiModelProperty(name = "签收回单-true/false", example = "true")
    @ExcelProperty("签收回单")
    private Boolean receipt;

    @Column
    @ApiModelProperty(name = "送货方式-送货上门/自提/送货上楼", example = "送货上楼")
    @ExcelProperty("送货方式")
    private String deliveryMode;

    @Column
    @ApiModelProperty(name = "物流公司", example = "顺丰")
    @ExcelProperty("物流公司")
    private String logisticsCompany;

    @Column
    @ApiModelProperty(name = "保价金额", example = "0")
    @ExcelProperty("保价金额")
    private Float insuredValue;

    @Column
    @ApiModelProperty(name = "运费", example = "26.5")
    @ExcelProperty("运费")
    private Float freight;

    @Column
    @ApiModelProperty(name = "保险费", example = "0.31")
    @ExcelProperty("保险费")
    private Float insuranceCost;

    @Column
    @ApiModelProperty(name = "包装费", example = "2.1")
    @ExcelProperty("包装费")
    private Float packageCost;

    @Column
    @ApiModelProperty(name = "运费小记", example = "28.91")
    @ExcelProperty("运费小记")
    private Float totalCost;

    @Column
    @ApiModelProperty(name = "首价", example = "28.91")
    @ExcelProperty("首价")
    private Float firstPrice;

    @Column
    @ApiModelProperty(name = "续价", example = "28.91")
    @ExcelProperty("续价")
    private Float continuationPrice;

    @Column
    @ApiModelProperty(name = "创建时间", example = "2018-10-01 12:18:48")
    @ExcelProperty("创建时间")
    private Date createDate;

    @Column
    @ApiModelProperty(name = "创建者", example = "admin")
    @ExcelProperty("创建者")
    private String creator;

    @Column
    @ApiModelProperty(name = "付款方式-月结/寄付/到付", example = "寄付")
    @ExcelProperty("付款方式")
    private String payType;

    @Column
    @ApiModelProperty(name = "部门代码", example = "X")
    @ExcelProperty("部门代码")
    private String departmentCode;

    @Column
    @ApiModelProperty(name = "寄件时间", example = "2018-10-01 12:18:48")
    @ExcelProperty("寄件时间")
    private Date sendTime;

    @Column
    @ApiModelProperty(name = "寄件人_姓名", example = "张三")
    @ExcelProperty("寄件人_姓名")
    private String senderName;

    @Column
    @ApiModelProperty(name = "寄件人_手机号", example = "18888888888")
    @ExcelProperty("寄件人_手机号")
    private String senderPhone;

    @Column
    @ApiModelProperty(name = "寄件人_公司", example = "X公司")
    @ExcelProperty("寄件人_公司")
    private String senderCompany;

    @Column
    @ApiModelProperty(name = "寄件人_固定电话", example = "XXXXXXXXX")
    @ExcelProperty("寄件人_固定电话")
    private String senderFixedPhone;

    @Column
    @ApiModelProperty(name = "寄件人_地区-省-市-区", example = "北京-北京市-东城区")
    @ExcelProperty("寄件人_地区")
    private String senderArea;

    @Column
    @ApiModelProperty(name = "寄件人_详细地址", example = "广西壮族自治区桂林市七星区朝阳路信息产业园电商谷")
    @ExcelProperty("寄件人_详细地址")
    private String senderAddress;

    @Column
    @ApiModelProperty(name = "收件人_姓名", example = "李四")
    @ExcelProperty("收件人_姓名")
    private String receiverName;

    @Column
    @ApiModelProperty(name = "收件人_手机号", example = "1777777777")
    @ExcelProperty("收件人_手机号")
    private String receiverPhone;

    @Column
    @ApiModelProperty(name = "收件人_公司", example = "Y公司")
    @ExcelProperty("收件人_公司")
    private String receiverCompany;

    @Column
    @ApiModelProperty(name = "收件人_固定电话", example = "XXXXXXXXX")
    @ExcelProperty("收件人_固定电话")
    private String receiverFixedPhone;

    @Column
    @ApiModelProperty(name = "收件人_地区-省-市-区", example = "北京-北京市-东城区")
    @ExcelProperty("收件人_地区")
    private String receiverArea;

    @Column
    @ApiModelProperty(name = "收件人_地区-详细地址", example = "广西壮族自治区桂林市七星区朝阳路信息产业园电商谷")
    @ExcelProperty("收件人_地区")
    private String receiverAddress;

    @Tolerate
    public Order(){}
}
