package com.contest.common.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录相关
 *
 * @author zhangsan
 */
@RestController
public class AuthInfoController {

    @GetMapping("/nvwa/getLoginContext")
    public R getLoginContext() {
        R rs = R.ok();
        String str = "{\"id\":\"00000000-0000-0000-0000-000000000000\",\"username\":\"admin\",\"tenantName\":\"__default_tenant__\",\"loginDate\":\"2020-10-11\",\"extInfo\":{\"verifyCode\":\"9kws\",\"verifyId\":\"+BQ4u08GUr+OlpIxO+pYnLqRmlxXxfrDXt9uKMILGQxgV6ORQWouuLgVMwZQoNIe\",\"tempIsSystemUser\":false},\"conetxtUser\":{\"id\":\"sys_user_admin\",\"name\":\"admin\",\"fullname\":null,\"description\":null,\"orgCode\":null}}";

        JSONObject designData = JSON.parseObject(str);
        rs.put("context", designData);
        return rs;

    }

    @PostMapping("/nvwa/login")
    public R login() {
        R rs = R.ok();
        rs.put("status", "");
        rs.put("token", "d6cd01b2-9181-438d-b049-036de18eb60e");
        return rs;
    }

    @GetMapping("/api/portal")
    public JSONObject portal() {
        String str = "{\"id\":\"0fed64f5-5505-4cf5-9f69-2d21cad9c653\",\"designId\":\"61c1f7d9-5bb6-4eaf-801c-5433e543768c\",\"config\":\"{\\\"global\\\":{\\\"theme\\\":\\\"blue-theme\\\",\\\"global_config_setting\\\":{\\\"closeTab\\\":false}},\\\"nav\\\":{\\\"menuPostion\\\":1,\\\"navAction\\\":1,\\\"menuWidth\\\":180,\\\"collapse\\\":true},\\\"header_logo\\\":{\\\"logo\\\":\\\"https://127.0.0.1/logo.jpg\\\",\\\"name\\\":\\\"七队加油\\\",\\\"setting\\\":{\\\"font\\\":\\\"Microsoft YaHei\\\",\\\"fontsize\\\":20,\\\"color\\\":\\\"#ffffff\\\",\\\"x\\\":0,\\\"y\\\":0,\\\"logoHeight\\\":55}},\\\"header_btn\\\":[{\\\"name\\\":\\\"搜索\\\",\\\"id\\\":\\\"searchId\\\",\\\"icon\\\":\\\"icon-_Tsousuofangda\\\",\\\"selected\\\":true,\\\"authority\\\":[],\\\"type\\\":\\\"feature\\\",\\\"params\\\":[]},{\\\"name\\\":\\\"首页\\\",\\\"id\\\":\\\"home\\\",\\\"icon\\\":\\\"icon-_topTshouye\\\",\\\"selected\\\":true,\\\"authority\\\":[],\\\"type\\\":\\\"feature\\\"},{\\\"name\\\":\\\"消息通知\\\",\\\"id\\\":\\\"message\\\",\\\"icon\\\":\\\"icon-_topTxiaoxi\\\",\\\"selected\\\":true,\\\"authority\\\":[],\\\"type\\\":\\\"feature\\\"},{\\\"name\\\":\\\"多语言\\\",\\\"id\\\":\\\"languages\\\",\\\"icon\\\":\\\"icon-_ZSYduoyuyanguanliduoyuyan\\\",\\\"selected\\\":false,\\\"authority\\\":[\\\"admin\\\"],\\\"type\\\":\\\"feature\\\"},{\\\"name\\\":\\\"客服\\\",\\\"id\\\":\\\"customerService \\\",\\\"icon\\\":\\\"icon-_topTkefu\\\",\\\"selected\\\":false,\\\"authority\\\":[],\\\"type\\\":\\\"feature\\\"},{\\\"name\\\":\\\"工作空间\\\",\\\"id\\\":\\\"switchAccount\\\",\\\"icon\\\":\\\"icon-_topTkefu\\\",\\\"selected\\\":false,\\\"authority\\\":[],\\\"type\\\":\\\"user\\\"},{\\\"name\\\":\\\"修改密码\\\",\\\"id\\\":\\\"changePassword\\\",\\\"icon\\\":\\\"icon-_topTkefu\\\",\\\"selected\\\":true,\\\"authority\\\":[],\\\"type\\\":\\\"user\\\"},{\\\"name\\\":\\\"关闭注销\\\",\\\"id\\\":\\\"closelLayout\\\",\\\"icon\\\":\\\"icon-_topTkefu\\\",\\\"selected\\\":false,\\\"authority\\\":[],\\\"type\\\":\\\"user\\\"},{\\\"name\\\":\\\"更新说明\\\",\\\"id\\\":\\\"updinstruct\\\",\\\"icon\\\":\\\"icon-_topTkefu\\\",\\\"selected\\\":true,\\\"authority\\\":[],\\\"type\\\":\\\"user\\\"},{\\\"name\\\":\\\"用户信息\\\",\\\"id\\\":\\\"userDetail\\\",\\\"icon\\\":\\\"icon-_topTkefu\\\",\\\"selected\\\":true,\\\"authority\\\":[],\\\"type\\\":\\\"user\\\"}]}\",\"version\":1602328010452,\"editAccess\":true,\"createUser\":null,\"modifyUser\":null,\"createTime\":null,\"modifyTime\":null,\"schemeId\":\"default\"}";
        JSONObject jsonObject = JSON.parseObject(str);
        return jsonObject;
    }

    @GetMapping("/serverconfig/alladdress")
    public JSONObject allAddress() {
        String str = "{\"timestamp\":\"2020-10-11T11:51:47.753\",\"success\":true,\"errorCode\":null,\"errorMessage\":null,\"errorDetail\":null,\"data\":{}}";
        JSONObject jsonObject = JSON.parseObject(str);
        return jsonObject;
    }

    @GetMapping("/api/routes")
    public JSONObject routes() {
        String root = "{\"id\":\"root\",\"title\":\"根节点\",\"appName\":null,\"type\":null,\"path\":null,\"icon\":null,\"openWay\":null,\"ordinal\":null,\"parentId\":null,\"component\":null,\"name\":null,\"recordVersion\":null,\"designId\":null,\"openMore\":false,\"locked\":false,\"prodLine\":null}";
        JSONObject rootObject = JSON.parseObject(root);
        JSONArray jsonArray = new JSONArray();
        JSONObject menu1 = JSON.parseObject("{\"id\":\"e364a458-3377-4c67-b4d9-fecb1f768d0a\",\"title\":\"职员信息初始化\",\"appName\":\"staff-info-init\",\"type\":\"ROUTE\",\"path\":null,\"icon\":\"icon-16_DH_A_GC_tzfl\",\"openWay\":\"FUNCTAB\",\"ordinal\":\"1602328010530\",\"parentId\":null,\"component\":null,\"name\":null,\"recordVersion\":\"1602328010610\",\"designId\":\"e364a458-3377-4c67-b4d9-fecb1f768d0a\",\"openMore\":false,\"locked\":true,\"prodLine\":\"@team7\"}");
        jsonArray.add(menu1);
        JSONObject menu2 = JSON.parseObject("{\"id\":\"e364a458-3377-4c67-b4d9-fecb1f768d02\",\"title\":\"分析查询\",\"appName\":\"chart-query\",\"type\":\"ROUTE\",\"path\":null,\"icon\":\"icon-16_DH_A_GC_tzfl\",\"openWay\":\"FUNCTAB\",\"ordinal\":\"1602328010530\",\"parentId\":null,\"component\":null,\"name\":null,\"recordVersion\":\"1602328010610\",\"designId\":\"e364a458-3377-4c67-b4d9-fecb1f768d02\",\"openMore\":false,\"locked\":true,\"prodLine\":\"@team7\"}");
        jsonArray.add(menu2);
        rootObject.put("children", jsonArray);
        return rootObject;
    }

    @GetMapping("/api/route-params/{id}")
    public JSONObject routeParams() {
        String str = "{\"routeId\":\"e364a458-3377-4c67-b4d9-fecb1f768d0a\",\"designId\":\"48839e92-bc51-355d-6638-a8cc8e0816b4\",\"configJson\":\"{\\\"page\\\":\\\"jq\\\"}\"}";
        JSONObject jsonObject = JSON.parseObject(str);
        return jsonObject;
    }

    @GetMapping("/serverconfig/allwebsocketaddress")
    public JSONObject allWebSocketAddress() {
        String str = "{\"timestamp\":\"2020-10-11T11:51:47.772\",\"success\":true,\"errorCode\":null,\"errorMessage\":null,\"errorDetail\":null,\"data\":{}}";
        JSONObject jsonObject = JSON.parseObject(str);
        return jsonObject;
    }

}