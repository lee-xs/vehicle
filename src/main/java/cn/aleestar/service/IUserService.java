package cn.aleestar.service;

import cn.aleestar.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserService extends IService<User> {

    User findByUsername(String username);

}
