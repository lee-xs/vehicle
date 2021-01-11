package cn.aleestar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Description 号池实体
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
@TableName("mark")
public class Mark {

    //主键
    @TableId(type = IdType.AUTO)
    private String id;
    //牌照
    private String vehicleNumber;
    //状态
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
