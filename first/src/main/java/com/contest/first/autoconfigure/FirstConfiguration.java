package com.contest.first.autoconfigure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@EnableTransactionManagement
        @ComponentScans({
        @ComponentScan(basePackages = "com.contest.first.dao"),
        @ComponentScan(basePackages = "com.contest.first.service"),
        @ComponentScan(basePackages = "com.contest.first.web")})
@MapperScan(basePackages = { "com.contest.first.dao" })
public class FirstConfiguration {

}
