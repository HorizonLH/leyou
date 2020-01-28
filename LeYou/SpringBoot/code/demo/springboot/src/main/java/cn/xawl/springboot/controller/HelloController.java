package cn.xawl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author hhl
 * @date - 21:47
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/show")
    public String test(){


        return "hello springboot 1";
    }



}
