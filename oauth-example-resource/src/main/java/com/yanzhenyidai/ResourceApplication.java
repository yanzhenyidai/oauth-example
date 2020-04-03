package com.yanzhenyidai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author frank
 * @version 1.0
 * @date 2019-09-01 13:30
 */
@SpringBootApplication
@RestController
public class ResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
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
