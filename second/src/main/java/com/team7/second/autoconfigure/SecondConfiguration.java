package com.team7.second.autoconfigure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans({
        @ComponentScan(basePackages = "com.team7.second.dao"),
        @ComponentScan(basePackages = "com.team7.second.service"),
        @ComponentScan(basePackages = "com.team7.second.web")})
/**
 * 配置入口类
 * @author zhangsan
 */
public class SecondConfiguration {

}
