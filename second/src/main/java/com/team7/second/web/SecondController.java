package com.team7.second.web;

import com.team7.common.consts.CommonConst;
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
@RequestMapping(CommonConst.API_BASE_PATH + "second" )
public class SecondController  {

    @GetMapping("list")
    public String listAssetBills() {
        return "12345";
    }

}
