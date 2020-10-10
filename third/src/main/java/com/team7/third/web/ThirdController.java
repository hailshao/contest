package com.team7.third.web;

import com.team7.common.consts.CommonConst;
import com.team7.common.util.SpringContextUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 资产单据控制器
 *
 * @author shaohailin
 * @date 2020/06/05
 */
@RestController
@RequestMapping(CommonConst.API_BASE_PATH + "third")
public class ThirdController {
    /**
     * http://127.0.0.1:8888/api/lab/v1/third/list
     *
     * @return
     */
    @GetMapping("list")
    public String listAssetBills() {
        System.out.println("listAssetBills:" + Thread.currentThread().getName());
        Future<String> asyncResult = SpringContextUtils.getBean(ThirdController.class).test();
        System.out.println("222");
        try {
            asyncResult.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("333");
        return "12345";
    }

    @Async(value = "taskExecutor")
    public Future<String> test() {
        System.out.println("test:" + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(111);
        return new AsyncResult("over");

    }
}
