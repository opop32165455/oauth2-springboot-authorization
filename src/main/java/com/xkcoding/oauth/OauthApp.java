package com.xkcoding.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-02-17 23:52
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class OauthApp {

    public static void main(String[] args) {
        SpringApplication.run(OauthApp.class, args);
    }

}

