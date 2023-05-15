package com.design.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/*
* 读取数据库连接信息的配置
* */
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

        /*使用注入的形式，读取properties文件中的属性值,
        **/
        @Value("${jdbc.driverClassName}")
        private String driver;
        @Value("${jdbc.url}")
        private String url;
        @Value("${jdbc.username}")
        private String username;
        @Value("${jdbc.password}")
        private String password;

        /*定义dataSource的bean
        * */
        @Bean("dataSource")
        public DataSource getDataSource(){
            //创建对象
            DruidDataSource ds = new DruidDataSource();
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
            return ds;
        }
}
