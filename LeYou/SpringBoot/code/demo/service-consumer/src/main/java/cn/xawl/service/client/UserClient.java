package cn.xawl.service.client;

import cn.xawl.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hhl
 * @date - 22:52
 */

@FeignClient(value = "service-provide", fallback = UserClientFallback.class)  //声明这个接口是feign接口，指定服务的id
public interface UserClient {

    @GetMapping("user/{id}")
    public User queryById(@PathVariable("id") Long id);

}
