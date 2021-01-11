package cn.aleestar.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description 登录拦截器
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        Object user = session.getAttribute("user");
        if(!ObjectUtils.isEmpty(user)){
            return true;
        }else{
            //session中没有用户信息，重定向到登录页面
            response.sendRedirect("/login");
            return false;
        }
    }

}
