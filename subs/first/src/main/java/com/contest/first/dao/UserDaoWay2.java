package com.contest.first.dao;

import com.contest.first.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * mybatis实现方式2：需要和UserMapper.xml搭配
 *
 * @author zhangsan
 */
@Mapper
public interface UserDaoWay2 {
    List<UserDO> getAllUser();

    void insertUser(UserDO userDO);

    List<UserDO> getUser(UserDO userDO);

    /**
     * 其它方法的sql写在UserMapper.xml文件中，也可以写在注解中.效果同com.contest.first.dao.UserDaoWay2#getUser(com.contest.first.domain.UserDO)
     */
    //        @Select("select * from USER_TEST")
    @Select({"<script>",
            "select * from USER_TEST where 1=1 ",
            "    <if test='id != null'>and id like #{id}</if>",
            "    <if test='name != null'>and name like #{name}</if>",
            "    <if test='gender != null'>and gender like #{gender}</if>",
            "</script>"})
    List<UserDO> getUser2(UserDO userDO);

    void updateUserById(UserDO userDO);

    void deleteUser(UserDO userDO);


    void batchInsertUser(List<UserDO> userDOList);

}
