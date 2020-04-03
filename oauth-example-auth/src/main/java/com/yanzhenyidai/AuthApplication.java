package com.yanzhenyidai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author frank
 * @version 1.0
 * @date 2019-08-23 14:52
 */
@SpringBootApplication
@MapperScan("com.yanzhenyidai.auth.mapper")
@RestController
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/user")
    public Principal principal(Principal principal) {
        return principal;
    }
}
