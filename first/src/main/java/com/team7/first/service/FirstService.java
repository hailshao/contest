package com.team7.first.service;

import com.team7.first.domain.UserDO;

import java.util.List;

/**
 * 自定义单据 Service
 *
 * @author shaohailin
 * @date 2020/07/1 17:43
 */
public interface FirstService {

    List<UserDO> getAllUserName();

    void testSystemMethod();

    void testCustomMethod();

    void testJoin();

    void batchInsertTest();
}
