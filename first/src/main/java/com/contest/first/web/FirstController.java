package com.contest.first.web;

import com.contest.common.consts.CommonConst;
import com.contest.first.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资产单据控制器
 *
 * @author shaohailin
 * @date 2020/06/05
 */
@RestController
@RequestMapping(CommonConst.API_BASE_PATH + "first")
public class FirstController {
    @Autowired
    private FirstService firstService;

    /**
     * http://127.0.0.1:8888/api/contest/v1/first/list
     */
    @GetMapping("list")
    public String listAssetBills() {
//        firstService.getAllUserName();
//        firstService.testJoin();
        firstService.batchInsertTest();
        return "1234";
    }

    /**
     * http://127.0.0.1:8888/api/contest/v1/first/testSystemMethod
     */
    @GetMapping("testSystemMethod")
    public String testSystemMethod() {
        firstService.testSystemMethod();
        return "1234";
    }

    /**
     * http://127.0.0.1:8888/api/contest/v1/first/testCustomMethod
     */
    @GetMapping("testCustomMethod")
    public String testCustomMethod() {
        firstService.testCustomMethod();
        return "1234";
    }

}
