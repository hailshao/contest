package com.contest.second.autoconfigure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans({
        @ComponentScan(basePackages = "com.contest.second.dao"),
        @ComponentScan(basePackages = "com.contest.second.service"),
        @ComponentScan(basePackages = "com.contest.second.web")})
/**
 * 配置入口类
 * @author zhangsan
 */
public class SecondConfiguration {

}
