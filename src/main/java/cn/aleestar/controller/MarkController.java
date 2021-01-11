package cn.aleestar.controller;

import cn.aleestar.dto.Response;
import cn.aleestar.entity.Mark;
import cn.aleestar.service.impl.MarkService;
import cn.aleestar.utils.VehicleUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 号池控制层
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
@RestController
@RequestMapping("/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    /**
     * 生成车牌接口
     * @param region 传入京A , 津B 这种格式
     * @param size 生成的数量
     * @return
     */
    @GetMapping("/create")
    public Response create(@RequestParam(value = "region", required = false, defaultValue = "") String region, @RequestParam("size") Integer size){
        List<Mark> markList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            String vahicleNumber = VehicleUtils.create(region);
            //查询生成的数据是否已经在库中存在，如存在则不记录，跳过该次
            Mark mark = markService.findByVehicleNumber(vahicleNumber);
            if(ObjectUtils.isNotEmpty(mark)){
                i--;
                break;
            }
            mark = new Mark();
            mark.setVehicleNumber(vahicleNumber);
            markList.add(mark);
        }
        //讲车牌对象，一起插入到数据库中
        markService.saveBatch(markList);
        return Response.ok("生成成功");
    }

    @GetMapping("/list")
    public Response list(){
        return Response.ok(markService.list(wrapper()));
    }

    /**
     * 搜索接口
     * @param search 模糊查询条件
     * @return
     */
    @GetMapping("/search")
    public Response search(@RequestParam String search){
        LambdaQueryWrapper<Mark> lambdaQueryWrapper = wrapper();
        lambdaQueryWrapper.like(Mark::getVehicleNumber, search);
        return Response.ok(markService.list(lambdaQueryWrapper));
    }

    @GetMapping("/page")
    public Response page(@RequestParam("pageCode") Integer pageCode, @RequestParam("pageSize") Integer pageSize){
        Page<Mark> page = new Page(pageCode, pageSize);
        return Response.ok(markService.page(page, wrapper()));
    }

    private LambdaQueryWrapper wrapper(){
        LambdaQueryWrapper<Mark> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Mark::getStatus, "0");
        return lambdaQueryWrapper;
    }

}
