package com.leyou.upload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author hhl
 * @date - 12:24
 */
@Configuration
public class LeYouCorsConfiguration {

    @Bean
    public CorsFilter corsFilter(){

        //初始化cors对象
        CorsConfiguration configuration = new CorsConfiguration();
        //允许跨域的yu'ming，如果要携带cookie，不能写*   *代表所有域名都可以以跨域访问
        configuration.addAllowedOrigin("http://manage.leyou.com");
        //是否允许携带cookie
        configuration.setAllowCredentials(true);

        configuration.addAllowedMethod("*");//代表所有的请求方法
        configuration.addAllowedHeader("*");//代表允许携带任何头信息

        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",configuration);

        return new CorsFilter(corsConfigurationSource);
    }


}
