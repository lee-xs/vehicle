package cn.aleestar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 路由控制层，控制返回各个页面的html
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
@Controller
public class RouterController {

    //返回主页
    @RequestMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    //返回登录页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    //返回注册页面
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    //返回抽取车牌页面
    @RequestMapping("/extract")
    public String extract(){
        return "extract";
    }

    //返回选取车牌页面
    @RequestMapping("/select")
    public String select(){
        return "select";
    }

}
