package com.linus.express.order.dao.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String goodsName;

    @Column
    private Float weight;

    @Column
    private Float volumn;

    @Column
    private Integer number;

    @Column
    private String remark;

    @Column
    private String packageType;

    @Column
    private Boolean receipt;

    @Column
    private String deliveryMode;

    @Column
    private String logisticsCompany;

    @Column
    private Float insuredValue;

    @Column
    private Float freight;

    @Column
    private Float insuranceCost;

    @Column
    private Float packageCost;

    @Column
    private Float totalCost;

    @Column
    private Float firstPrice;

    @Column
    private Float continuationPrice;

    @Column
    private Date createDate;

    @Column
    private Date creator;

    @Column
    private String payType;

    @Column
    private String departmentCode;

    @Column
    private Date sendTime;

    @Column
    private String senderName;

    @Column
    private String senderPhone;

    @Column
    private String senderCompany;

    @Column
    private String senderFixedPhone;

    @Column
    private String senderArea;

    @Column
    private String senderAddress;

    @Column
    private String receiverName;

    @Column
    private String receiverPhone;

    @Column
    private String receiverCompany;

    @Column
    private String receiverFixedPhone;

    @Column
    private String receiverArea;

    @Column
    private String receiverAddress;

    @Tolerate
    public Order(){}
}
