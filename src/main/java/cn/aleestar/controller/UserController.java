package cn.aleestar.controller;

import cn.aleestar.dto.Response;
import cn.aleestar.entity.Mark;
import cn.aleestar.entity.User;
import cn.aleestar.service.impl.MarkService;
import cn.aleestar.service.impl.UserService;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description 用户控制层
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MarkService markService;

    @ResponseBody
    @PostMapping("/register")
    public Response register(@RequestParam("username") String username, @RequestParam("password") String password){
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return Response.err("用户名或密码不能为空");
        }
        User user = userService.findByUsername(username);
        if(ObjectUtils.isNotEmpty(user)){
            return Response.err("用户名已存在");
        }
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.save(user);
        return Response.ok("注册成功");
    }

    @ResponseBody
    @PostMapping("/login")
    public Response login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request){
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return Response.err("用户名或密码不能为空");
        }
        User user = userService.findByUsername(username);
        if(ObjectUtils.isEmpty(user)){
            return Response.err("用户不存在");
        }
        if(!password.equals(user.getPassword())){
            return Response.err("密码错误");
        }
        //将用户信息存入到session中，前端可以直接拿到
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(10 * 60);
        return Response.ok("登录成功");
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        //退出登录 清除session中的用户信息
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/login";
    }

    @ResponseBody
    @PutMapping("/apply")
    public Response apply(@RequestParam("id") Integer id, @RequestParam("vehicleNumber") String vehicleNumber, HttpServletRequest request){
        User user = userService.getById(id);
        //将之前的车牌号恢复正常
        Mark mark = markService.findByVehicleNumber(user.getVehicleNumber());
        if(ObjectUtils.isNotEmpty(mark)){
            mark.setStatus("0");
            markService.updateById(mark);
        }
        //将新车牌设置为使用
        mark = markService.findByVehicleNumber(vehicleNumber);
        mark.setStatus("1");
        markService.updateById(mark);
        //更新用户信息
        user.setVehicleNumber(vehicleNumber);
        userService.updateById(user);
        //设置新的用户信息
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return Response.ok(user);
    }


}
