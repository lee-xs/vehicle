package cn.aleestar.service.impl;

import cn.aleestar.entity.Mark;
import cn.aleestar.mapper.MarkMapper;
import cn.aleestar.service.IMarkService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 号池处理层
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
@Service
public class MarkService extends ServiceImpl<MarkMapper, Mark> implements IMarkService {

    @Autowired
    private MarkMapper markMapper;

    @Override
    public Mark findByVehicleNumber(String vehicleNumber) {
        LambdaQueryWrapper<Mark> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Mark::getVehicleNumber, vehicleNumber);
        return markMapper.selectOne(lambdaQueryWrapper);
    }
}
