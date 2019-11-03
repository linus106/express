package com.linus.express.order.dao.repository;

import com.linus.express.order.dao.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ：wangxiangyu
 * @date ：Created in 2019/11/2
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query("select u from UserInfo u where u.userName = ?1")
    List<UserInfo> findByUserName(String user);
}
