package com.contest.first.domain;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * create table USER_TEST
 * (
 * id     VARCHAR(36) not null,
 * name   VARCHAR(20),
 * gender VARCHAR(2)
 * )
 * 用户测试实体对象
 *
 * @author shaohailin
 */
@Table(name = "USER_TEST")
public class UserDO {
    @Id
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "GENDER")
    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserDO [id=" + id + ", name=" + name + ", gender=" + gender + "]";
    }
}
