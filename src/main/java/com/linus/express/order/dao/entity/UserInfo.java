package com.linus.express.order.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
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
@Table(name = "USER_INFO")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@ApiModel
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键")
    private Long id;

    @Column
    @ApiModelProperty(value = "登录名", required = true)
    private String userName;

    @Column
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @Column
    @ApiModelProperty("联系方式")
    private String contact;

    @Column
    @ApiModelProperty("备注")
    private String remark;

    @Column(updatable = false)
    @ApiModelProperty("创建时间")
    private Date createTime;

    @Column
    @ApiModelProperty("角色")
    private String role;

    @Tolerate
    public UserInfo(){}
}
