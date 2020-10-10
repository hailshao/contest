package com.team7.first.autoconfigure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@EnableTransactionManagement
        @ComponentScans({
        @ComponentScan(basePackages = "com.team7.first.dao"),
        @ComponentScan(basePackages = "com.team7.first.service"),
        @ComponentScan(basePackages = "com.team7.first.web")})
@MapperScan(basePackages = { "com.team7.first.dao" })
public class FirstConfiguration {

}
