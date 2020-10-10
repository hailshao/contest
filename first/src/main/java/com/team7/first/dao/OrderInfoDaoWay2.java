package com.team7.first.dao;

import com.team7.first.domain.OrderInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * mybatis实现方式2：OrderInfoDaoWay2.xml搭配
 *
 * @author zhangsan
 */
@Mapper
public interface OrderInfoDaoWay2 {

    List<OrderInfoDO> testJoin(@Param(value = "userName") String userName);


}