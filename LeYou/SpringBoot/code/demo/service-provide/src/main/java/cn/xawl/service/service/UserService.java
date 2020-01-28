package cn.xawl.service.service;

import cn.xawl.service.mapper.UserMapper;
import cn.xawl.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hhl
 * @date - 21:37
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long id){
        return this.userMapper.selectByPrimaryKey(id);
    }



}
