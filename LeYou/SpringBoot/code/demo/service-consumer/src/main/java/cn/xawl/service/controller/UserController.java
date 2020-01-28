package cn.xawl.service.controller;

import cn.xawl.service.client.UserClient;
import cn.xawl.service.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


import java.util.List;

/**
 * @author hhl
 * @date - 22:00
 */
@Controller
@RequestMapping("/consumer/user")
//@DefaultProperties(defaultFallback = "fallbackMethod")  //定义全局熔断的方法
public class UserController {

    /*@Autowired
    private RestTemplate restTemplate;*/

//    @Autowired
//    private DiscoveryClient discoveryClient;//包含了拉取的所有服务信息

    @Autowired
    private UserClient userClient;

    @GetMapping
    @HystrixCommand  //声明熔断的方法
    public @ResponseBody String queryById(@RequestParam("id") Long id){

       /* if (id == 1){
            throw new RuntimeException();
        }*/

//        List<ServiceInstance> instances = discoveryClient.getInstances("service-provide");
//        ServiceInstance serviceInstance = instances.get(0);
//        return restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/"+id,User.class);
//        return restTemplate.getForObject("http://service-provide/user/" + id,String.class);//此处请求路径中user后要有/




        return this.userClient.queryById(id).toString();
    }

    /*public String fallbackMethod(){
        return "服务器正忙，请稍后再试！";
    }*/



}
