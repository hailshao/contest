package com.team7.third.autoconfigure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans({
        @ComponentScan(basePackages = "com.team7.third.dao"),
        @ComponentScan(basePackages = "com.team7.third.service"),
        @ComponentScan(basePackages = "com.team7.third.web")})
/**
 */
public class ThirdConfiguration {

}
