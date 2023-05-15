package com.design.config;

import com.github.pagehelper.PageInterceptor;
import org.aopalliance.intercept.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Properties;

/*MyBatis相关配置
 * */
public class MyBatisConfig {
    //配置分页插件
    @Bean
    public PageInterceptor getPageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("value", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    /*定义MyBatis的核心连接工厂
     * */
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource dataSource,
                                                          @Autowired PageInterceptor pageInterceptor) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Interceptor[] plugins={(Interceptor) pageInterceptor};
        sqlSessionFactoryBean.setPlugins((org.apache.ibatis.plugin.Interceptor[]) plugins);
        return  sqlSessionFactoryBean;
    }

    /*定义MyBatis的映射扫描
    * */
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.design.mapper");
        return mapperScannerConfigurer;
    }
}
