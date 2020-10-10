package com.team7.first.service.impl;

import com.team7.common.enums.GenderEnum;
import com.team7.common.util.CollectionUtils;
import com.team7.common.util.SpringContextUtils;
import com.team7.common.util.UUIDUtils;
import com.team7.first.dao.OrderInfoDao;
import com.team7.first.dao.UserDao;
import com.team7.first.dao.UserDaoWay2;
import com.team7.first.domain.OrderInfoDO;
import com.team7.first.domain.UserDO;
import com.team7.first.service.FirstService;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service/DAO 层方法命名规约(阿里)
 * 1） 获取单个对象的方法用 get 做前缀。
 * 2） 获取多个对象的方法用 list 做前缀，复数形式结尾如：listObjects。
 * 3） 获取统计值的方法用 count 做前缀。
 * 4） 插入的方法用 save/insert 做前缀。
 * 5） 删除的方法用 remove/delete 做前缀。
 * 6） 修改的方法用 update 做前缀。
 *
 * @author shaohailin
 */
@Service
public class FirstServiceImpl implements FirstService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderInfoDao orderInfoDao;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<UserDO> getAllUserName() {
        userDao.getAllUser();
        return null;
    }

    @Override
    public void testSystemMethod() {
        insertUser_systemTest();
        UserDO result = getUser_systemTest();
        updateUser_systemTest(result);
        getUser_systemTest();
        deleteUser_systemTest();
        getUser_systemTest();
    }

    @Override
    public void testCustomMethod() {
        insertUser_customTest();
        UserDO result = getUser_customTest();
        updateUser_customTest(result);
        getUser_customTest();
        deleteUser_customTest();
        getUser_customTest();
    }

    @Override
    public void testJoin() {
        List<OrderInfoDO> orderInfoDOS = orderInfoDao.testJoin("a");
        for (OrderInfoDO orderInfoDO : orderInfoDOS) {
            System.out.println(orderInfoDO);
        }
    }

    private void insertUser_systemTest() {
        UserDO userDO = new UserDO();
        userDO.setId(UUIDUtils.newUuidStr());
        userDO.setName("张三");
        userDO.setGender(GenderEnum.MAN.getCode());
        userDao.insert(userDO);
        logger.debug("insertUser_systemTest:" + userDO);
    }

    private UserDO getUser_systemTest() {
        UserDO userDO = new UserDO();
        userDO.setName("张三");
        List<UserDO> results = userDao.select(userDO);
        if (CollectionUtils.isEmpty(results)) {
            return null;
        }
        for (UserDO result : results) {
            logger.info("getUser_systemTest:" + result);
        }
        return results.get(0);
    }

    private void updateUser_systemTest(UserDO userDO) {
        userDO.setGender(GenderEnum.WOMEN.getCode());
        userDao.updateByPrimaryKey(userDO);
        logger.info("updateUser_systemTest:" + userDO);
    }

    private void deleteUser_systemTest() {
        UserDO userDO = new UserDO();
        userDO.setName("张三");
        userDao.delete(userDO);
        logger.info("deleteUser_systemTest:" + userDO);
    }


    private void insertUser_customTest() {
        UserDO userDO = new UserDO();
        userDO.setId(UUIDUtils.newUuidStr());
        userDO.setName("张三");
        userDO.setGender(GenderEnum.MAN.getCode());
        userDao.insertUser_test(userDO);
        logger.info("insertUser_customTest:" + userDO);
    }

    private UserDO getUser_customTest() {
        UserDO userDO = new UserDO();
        userDO.setName("张三");
        List<UserDO> results = SpringContextUtils.getBean(UserDaoWay2.class).getUser2(userDO);
        if (CollectionUtils.isEmpty(results)) {
            return null;
        }
        for (UserDO result : results) {
            logger.info("getUser_customTest:" + result);
        }
        return results.get(0);
    }

    private void updateUser_customTest(UserDO userDO) {
        userDO.setGender(GenderEnum.WOMEN.getCode());
        userDao.updateUserById_test(userDO);
        logger.info("updateUser_customTest:" + userDO);
    }

    private void deleteUser_customTest() {
        UserDO userDO = new UserDO();
        userDO.setName("张三");
        userDao.deleteUser_test(userDO);
        logger.info("deleteUser_customTest:" + userDO);
    }

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private void batchInsert() throws SQLException {
        SpringContextUtils.getBean(UserDao.class).delete(null);
        long beginTime = System.currentTimeMillis();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = SqlSessionUtils.getSqlSession(
                    sqlSessionTemplate.getSqlSessionFactory(), sqlSessionTemplate.getExecutorType(),
                    sqlSessionTemplate.getPersistenceExceptionTranslator()).getConnection();
            preparedStatement = connection.prepareStatement(" insert into USER_TEST(ID,NAME,GENDER) values(?,?,?)");
            connection.setAutoCommit(false);
            for (int i = 0; i < 1000; i++) {
                preparedStatement.setString(1, UUIDUtils.newUuidStr());
                preparedStatement.setString(2, "张三");
                preparedStatement.setString(3, GenderEnum.MAN.getCode());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - beginTime);
    }

    @Transactional
    public void batchInsert2() throws SQLException {
        SpringContextUtils.getBean(UserDao.class).delete(null);
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            UserDO userDO = new UserDO();
            userDO.setId(UUIDUtils.newUuidStr());
            userDO.setName("张三");
            userDO.setGender(GenderEnum.MAN.getCode());
            userDao.insertUser_test(userDO);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - beginTime);
    }

    public void batchInsert3() throws SQLException {
        SpringContextUtils.getBean(UserDao.class).delete(null);
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            UserDO userDO = new UserDO();
            userDO.setId(UUIDUtils.newUuidStr());
            userDO.setName("张三");
            userDO.setGender(GenderEnum.MAN.getCode());
            userDao.insertUser_test(userDO);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - beginTime);
    }

    public void batchInsert4() throws SQLException {
        SpringContextUtils.getBean(UserDao.class).delete(null);
        List<UserDO> userDOS = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            UserDO userDO = new UserDO();
            userDO.setId(UUIDUtils.newUuidStr());
            userDO.setName("张三");
            userDO.setGender(GenderEnum.MAN.getCode());
            userDOS.add(userDO);
        }
        long beginTime = System.currentTimeMillis();
        SpringContextUtils.getBean(UserDaoWay2.class).batchInsertUser(userDOS);
        long end = System.currentTimeMillis();
        System.out.println(end - beginTime);
    }

    @Override
    public void batchInsertTest() {
        try {
            batchInsert();
            System.out.println("size:" + userDao.getAllUser().size());
            batchInsert2();
            System.out.println("size:" + userDao.getAllUser().size());
            batchInsert3();
            System.out.println("size:" + userDao.getAllUser().size());
            batchInsert4();
            System.out.println("size:" + userDao.getAllUser().size());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
