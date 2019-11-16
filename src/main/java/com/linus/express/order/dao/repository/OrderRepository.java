package com.linus.express.order.dao.repository;

import com.linus.express.order.bean.Customer;
import com.linus.express.order.dao.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/2
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from #{#entityName} o " +
            "where (o.expressNumber like CONCAT('%',?1,'%')  or ?1 is null)" +
            "and (o.logisticsCompany like CONCAT('%',?2,'%')  or ?2 is null)" +
            "and (o.senderName like CONCAT('%',?3,'%') or o.senderPhone like CONCAT('%',?3,'%') " +
                "or o.senderCompany like CONCAT('%',?3,'%') or o.senderFixedPhone like CONCAT('%',?3,'%')  or ?3 is null)" +
            "and (o.receiverName like CONCAT('%',?4,'%') or o.receiverPhone like CONCAT('%',?4,'%') " +
                "or o.receiverCompany like CONCAT('%',?4,'%') or o.receiverFixedPhone like CONCAT('%',?4,'%') or ?4 is null)" +
            "and (o.payType = ?5  or ?5 is null)" +
            "and (o.senderArea = ?6  or ?6 is null)" +
            "and (o.receiverArea = ?7  or ?7 is null)" +
            "and (o.sendTime >= ?8  or ?8 is null)" +
            "and (o.sendTime < ?9  or ?9 is null)"
    )
    Page<Order> queryByCondition(String expressNumber, String logisticsCompany, String senderInfo
            , String receiverInfo , String payType, String senderArea, String receiverArea,
                                 Date sendDateStart, Date sendDateEnd, Pageable pageable);


    @Query("select new com.linus.express.order.bean.Customer(o.senderName, o.senderPhone, o.senderCompany, o.senderFixedPhone, o.senderArea, o.senderAddress) from #{#entityName} o " +
            "where (o.senderName like CONCAT('%',?1,'%') or o.senderPhone like CONCAT('%',?1,'%') " +
            "or o.senderCompany like CONCAT('%',?1,'%') or o.senderFixedPhone like CONCAT('%',?1,'%')" +
            "or o.senderArea like CONCAT('%',?1,'%') or o.senderAddress like CONCAT('%',?1,'%')  or ?1 is null)"
    )
    List<Customer> querySender(String keyWord);

    @Query("select new com.linus.express.order.bean.Customer(o.receiverName, o.receiverPhone, o.receiverCompany, o.receiverFixedPhone, o.receiverArea, o.receiverAddress) from #{#entityName} o " +
            "where (o.receiverName like CONCAT('%',?1,'%') or o.receiverPhone like CONCAT('%',?1,'%') " +
            "or o.receiverCompany like CONCAT('%',?1,'%') or o.receiverFixedPhone like CONCAT('%',?1,'%')" +
            "or o.receiverArea like CONCAT('%',?1,'%') or o.receiverAddress like CONCAT('%',?1,'%')  or ?1 is null)"
    )
    List<Customer> queryCustomer(String keyWord);

}