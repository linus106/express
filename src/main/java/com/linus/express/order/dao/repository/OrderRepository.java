package com.linus.express.order.dao.repository;

import com.linus.express.order.dao.entity.Order;
import com.linus.express.order.dao.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/2
 */
public interface OrderRepository extends JpaRepository<Order, Long> {


}
