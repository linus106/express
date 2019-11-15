package com.linus.express.order.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @Author wangxiangyu
 * @Date 2019/11/15 15:00
 * @Description TODO
 */
@Data
public class OrderQueryCondition {

    private String expressNumber;
    private String logisticsCompany;
    private String senderInfo;
    private String receiverInfo;
    private String payType;
    private String senderArea;
    private String receiverArea;

    private PageInfo pageInfo;
}
