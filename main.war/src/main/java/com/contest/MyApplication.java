package com.contest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * springboot入口类
 * @author zhangsan
 */
@EnableAsync
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, SecurityAutoConfiguration.class})
public class MyApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MyApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
