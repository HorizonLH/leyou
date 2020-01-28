package com.leyou.user.api;

import com.leyou.user.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lh
 * @date 2019/12/26
 **/
public interface UserApi {

    @GetMapping("/query")
    public User queryUser(@RequestParam("username")String username, @RequestParam("password")String password);
}
