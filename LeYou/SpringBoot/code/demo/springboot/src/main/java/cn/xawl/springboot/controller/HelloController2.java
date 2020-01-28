package cn.xawl.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhl
 * @date - 21:47
 */
@RequestMapping("/hello2")
@RestController
public class HelloController2 {

    @GetMapping("/show")
    public String test(){
        return "hello springboot 2";
    }

}
