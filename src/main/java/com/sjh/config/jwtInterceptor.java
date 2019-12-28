package com.sjh.config;

import com.sjh.response.ResultCode;
import com.sjh.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器，用于jwt token权限校验
 */
@Component
public class jwtInterceptor extends HandlerInterceptorAdapter {


    /**
     * 访问后台接口首先访问此拦截器的此方法
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        try {
            //配置跨域问题
            response.setHeader("Access-Control-Allow-Origin","*");
            //允许请求头中携带自定义的字段
            response.setHeader("Access-Control-Allow-Headers","Content-Type,Content-Length,Authorization,Accept,X-Requested-With");
            //允许的请求方式
            response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");

            // 自定义请求头时会首先发送一个option请求，这里我们给option请求直接返回正常状态
            String method= request.getMethod();
            if (method.equals("OPTIONS")){
                response.setStatus(200);
                return false;
            }

            //解析请求头
            String Authorization = request.getHeader("Authorization");
            //判断请求头中是否携带token
            if(!StringUtils.isEmpty(Authorization) && Authorization.startsWith("Bearer")){
                //截取token
                String token = Authorization.substring(6).trim();//切掉前6位，并去掉空格
                //解析token获得claims对象
                Claims claims = JwtUtils.parseJwt(token);
                if(claims != null){
                    return true;
                }
                return false;
            }else{
                //无token
                throw new RuntimeException("无token，请重新登录");
            }
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("执行到了catch这里");
            throw new Exception(e.getMessage());
        }
    }

}
