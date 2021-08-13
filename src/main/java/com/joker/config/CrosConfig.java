package com.joker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: word_test
 * @author: Joker
 * @create: 2021-06-23 16:29
 * @Description: NULL
 **/

@Configuration
public class CrosConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings ( CorsRegistry registry ) {
        registry.addMapping( "/**" )
//                .allowedOrigins ( "http://47.106.90.16" )
                .allowedOrigins( "http://localhost:8080" )
                .allowedMethods( "GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS" )
                .allowCredentials( true )
                .maxAge( 3600 )
                .allowedHeaders( "*" );
    }
}
