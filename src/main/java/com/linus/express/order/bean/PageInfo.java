package com.linus.express.order.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wangxiangyu
 * @Date 2019/11/15 15:01
 * @Description TODO
 */
@Data
public class PageInfo {

    private Integer pageNo;
    private Integer pageSize;

    public Integer getOffset() {
        return  (pageNo-1) * pageSize;
    }

}
