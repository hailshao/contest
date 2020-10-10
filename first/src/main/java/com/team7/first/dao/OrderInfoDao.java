package com.team7.first.dao;

import com.team7.common.BaseOptMapper;
import com.team7.first.domain.OrderInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;


/**
 * @author shaohailin
 */
@Mapper
@Component
public interface OrderInfoDao extends BaseOptMapper<OrderInfoDO> {

    @SelectProvider(type = OrderInfoDaoProvider.class, method = "testJoin")
    List<OrderInfoDO> testJoin(@Param(value = "userName") String userName);


    class OrderInfoDaoProvider {
        public String testJoin(Map<String, String> para) {
            SQL sql = new SQL();
            sql.SELECT("o.ID,o.user_id as userId,o.goods_count as goodsCount");
            sql.FROM("ORDER_INFO o");
            sql.JOIN("USER_TEST u on u.id=o.user_id");
            final String userName = "userName";
            if (!StringUtils.isEmpty(para.get(userName))) {
                sql.WHERE("u.name = #{userName}");
            }
            System.out.println(sql);
            return sql.toString();
        }
    }
}