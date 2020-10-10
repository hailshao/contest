package com.team7.first.dao;

import com.team7.common.BaseOptMapper;
import com.team7.common.util.StringUtils;
import com.team7.first.domain.UserDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * mybatis实现方式1:BaseOptMapper内置了部分接口及实现
 *
 * @author shaohailin
 */
@Mapper
@Component
public interface UserDao extends BaseOptMapper<UserDO> {

    @SelectProvider(type = UserDaoProvider.class, method = "getAllUser")
    List<UserDO> getAllUser();

    @InsertProvider(type = UserDaoProvider.class, method = "insertUser_test")
    void insertUser_test(UserDO userDO);

    @SelectProvider(type = UserDaoProvider.class, method = "getUser_test")
    List<UserDO> getUser_test(UserDO userDO);

    @UpdateProvider(type = UserDaoProvider.class, method = "updateUserById_test")
    void updateUserById_test(UserDO userDO);

    @DeleteProvider(type = UserDaoProvider.class, method = "deleteUser_test")
    void deleteUser_test(UserDO userDO);

    class UserDaoProvider {
        public String getAllUser() {
            System.out.println("getAll");
            SQL sql = new SQL();
            sql.SELECT("ID,name,gender");
            sql.FROM("user_test");
            return sql.toString();
        }

        public String insertUser_test(UserDO userDO) {
//            System.out.println("insertUser_test");
            SQL sql = new SQL();
            sql.INSERT_INTO("user_test");
            sql.VALUES("ID", "#{id}");
            sql.VALUES("NAME", "#{name}");
            sql.VALUES("GENDER", "#{gender}");
            return sql.toString();
        }

        public String getUser_test(UserDO userDO) {
            System.out.println("getUser_test");
            SQL sql = new SQL();
            sql.SELECT("*");
            sql.FROM("user_test");
            if (!StringUtils.isEmpty(userDO.getId())) {
                sql.WHERE("ID=#{id}");
            }
            if (!StringUtils.isEmpty(userDO.getName())) {
                sql.WHERE("NAME=#{name}");
            }
            if (!StringUtils.isEmpty(userDO.getGender())) {
                sql.WHERE("GENDER=#{gender}");
            }
            return sql.toString();
        }

        public String updateUserById_test(UserDO userDO) {
            System.out.println("updateUser_test");
            SQL sql = new SQL();
            sql.UPDATE("user_test");
            sql.SET("NAME=#{name}");
            sql.SET("GENDER=#{gender}");
            sql.WHERE("ID=#{id}");
            return sql.toString();
        }

        public String deleteUser_test(UserDO userDO) {
            System.out.println("deleteUser_test");
            SQL sql = new SQL();
            sql.DELETE_FROM("user_test");
            if (!StringUtils.isEmpty(userDO.getId())) {
                sql.WHERE("ID=#{id}");
            }
            if (!StringUtils.isEmpty(userDO.getName())) {
                sql.WHERE("NAME=#{name}");
            }
            if (!StringUtils.isEmpty(userDO.getGender())) {
                sql.WHERE("GENDER=#{gender}");
            }
            return sql.toString();
        }
    }
}