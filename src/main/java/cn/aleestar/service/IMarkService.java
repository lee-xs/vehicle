package cn.aleestar.service;

import cn.aleestar.entity.Mark;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IMarkService extends IService<Mark> {

    Mark findByVehicleNumber(String vehicleNumber);
}
