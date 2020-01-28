package cn.xawl.user.mapper;

import cn.xawl.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hhl
 * @date - 13:42
 */
@Mapper//声明该接口是mybatis的mapper接口
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {





}
