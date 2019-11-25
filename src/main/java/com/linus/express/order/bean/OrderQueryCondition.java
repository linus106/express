package com.linus.express.order.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @Author wangxiangyu
 * @Date 2019/11/15 15:00
 * @Description TODO
 */
@Data
@ApiModel
public class OrderQueryCondition {

    private String expressNumber;
    private String logisticsCompany;

    @ApiModelProperty(name = "寄件人信息-姓名、电话", example = "张三")
    private String senderInfo;

    @ApiModelProperty(name = "收件人信息-姓名、电话", example = "李四")
    private String receiverInfo;
    private String payType;
    private String senderArea;
    private String receiverArea;

    @ApiModelProperty(name = "寄件时间-开始", example = "2018-09-01 12:18:48")
    private Date sendTimeStart;

    @ApiModelProperty(name = "寄件时间-结束", example = "2018-11-01 12:18:48")
    private Date sendTimeEnd;

    @Valid @NotNull(message = "分页信息不能为空")
    private PageInfo pageInfo;
}
