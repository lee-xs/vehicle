package cn.aleestar.mapper;

import cn.aleestar.entity.Mark;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 号池持久层
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
@Mapper
public interface MarkMapper extends BaseMapper<Mark> {
}
