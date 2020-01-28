package cn.xawl.user.service;

import cn.xawl.user.mapper.UserMapper;
import cn.xawl.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hhl
 * @date - 20:22
 */
@Service
@Transactional//整合事务
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long id){
        return this.userMapper.selectByPrimaryKey(id);

    }

    public void deleteUserById(Long id){
        this.userMapper.deleteByPrimaryKey(id);
    }

    public List<User> queryUserAll() {
        return this.userMapper.selectAll();
    }
}
