package com.design.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
* 用于初始化Servlet容器的配置类
* */
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*加载Spring配置类中的信息，
    * 初始化Spring容器*/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /*加载Spring MVC配置类中的信息，
    * 初始化Spring MVC*/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /*配置DispatcherServlet的映射路径*/
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
