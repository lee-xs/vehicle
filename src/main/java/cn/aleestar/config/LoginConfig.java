package cn.aleestar.config;

import cn.aleestar.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 访问权限路径配置
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
@SpringBootConfiguration
@EnableCaching
public class LoginConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/register")
                .excludePathPatterns("/login");*/
        //拦截的请求路径配置
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/")
                .addPathPatterns("/index")
                .addPathPatterns("/extract")
                .addPathPatterns("/select");
    }
}
