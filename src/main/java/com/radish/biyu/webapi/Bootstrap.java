package com.radish.biyu.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author cean
 * @version com.radish.biyu.webapi, v 0.1
 * @date 16/9/12.
 */
//@ImportResource(locations={"classpath:META-INF/spring/spring-mvc.xml"})
//@EnableConfigurationProperties({SpiderConfig.class})
@SpringBootApplication
public class Bootstrap {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        SpringApplication.run(Bootstrap.class, args);
    }
}