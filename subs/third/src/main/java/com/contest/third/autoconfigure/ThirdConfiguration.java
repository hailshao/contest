package com.contest.third.autoconfigure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans({
        @ComponentScan(basePackages = "com.contest.third.dao"),
        @ComponentScan(basePackages = "com.contest.third.service"),
        @ComponentScan(basePackages = "com.contest.third.web")})
/**
 */
public class ThirdConfiguration {

}
