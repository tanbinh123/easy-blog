package com.yccztt.config.interceptor;

import com.yccztt.utils.JwtUtil;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * Jwt拦截器
 * @author hyz
 * @create 2021-06-15 下午3:00
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //请求带handler,会发送两次请求,需要放行OPTIONS请求
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        boolean verify = false;
        String errMsg = "";
        //获取header中的token
        String token = request.getHeader("Authorization");
        try {
            //校验token
            verify = JwtUtil.verify(token);
        } catch (Exception e) {
            errMsg = e.getMessage();
            e.printStackTrace();
        }
        //验证token是否通过
        if (!verify) {
            errMsg = URLEncoder.encode(errMsg,"UTF-8");
            //需要在vue前段中设置跨域
            response.setHeader("Access-Control-Allow-Origin","*");
            //重定向到未登陆方法
            response.sendRedirect("/api/user/unLogin?msg=" + errMsg);
        }
        return true;
    }

}
