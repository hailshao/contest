package com.team7.first.domain;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * create table ORDER_INFO
 * (
 * id     VARCHAR(36) not null primary key,
 * user_id   VARCHAR(36),
 * goods_count int(8)
 * )
 * 订单测试实体对象
 *
 * @author shaohailin
 */
@Table(name = "ORDER_INFO")
public class OrderInfoDO {
    @Id
    private String id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "goods_count")
    private Integer goodsCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Override
    public String toString() {
        return "OrderInfoDO [id=" + id + ", user_id=" + userId + ", goods_count=" + goodsCount + "]";
    }
}
