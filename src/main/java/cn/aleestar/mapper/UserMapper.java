package cn.aleestar.mapper;

import cn.aleestar.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 用户持久层
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
