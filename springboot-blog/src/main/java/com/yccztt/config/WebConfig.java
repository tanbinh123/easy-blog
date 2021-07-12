package com.yccztt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hyz
 * @create 2021-06-14 下午5:14
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //访问的所有东西都跨域
                .allowedOrigins("*")
                //所有响应头
                .allowedHeaders("*")
                //响应类型
                .allowedMethods("*");
    }

    /**
     * 配置文件路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将物理地质upload文将映射到/upload
        //访问地址:http://域名/upload/文件名
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:"+System.getProperty("user.dir")+"/upload/");
    }

}
