package cn.aleestar.service.impl;

import cn.aleestar.entity.User;
import cn.aleestar.mapper.UserMapper;
import cn.aleestar.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户处理层
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, username);
        return userMapper.selectOne(lambdaQueryWrapper);
    }
}
