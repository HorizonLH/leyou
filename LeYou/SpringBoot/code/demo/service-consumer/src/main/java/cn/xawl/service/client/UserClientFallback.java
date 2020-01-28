package cn.xawl.service.client;

import cn.xawl.service.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author hhl
 * @date - 23:06
 */
@Component //注入容器
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setUsername("服务器正忙，请稍后再试");
        return user;
    }
}
