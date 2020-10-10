package com.contest.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangsan
 */
@Configuration
@ComponentScans({@ComponentScan("com.contest.common")})
@EnableTransactionManagement
public class CommonConfiguration {
//    private final DataSource dataSource;


//    CommonConfiguration(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        //创建 Configuration，设置通用 Mapper 配置
//        tk.mybatis.mapper.session.Configuration configuration = new tk.mybatis.mapper.session.Configuration();
//        //有 3 种配置方式
//        configuration.setMapperHelper(new MapperHelper());
//        sessionFactory.setConfiguration(configuration);
//
//        return sessionFactory.getObject();
//    }
}
