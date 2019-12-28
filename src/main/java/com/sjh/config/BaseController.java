package com.sjh.config;

import com.sjh.util.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class BaseController {


    protected String nikename;
    protected Claims claims;
    protected String time;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    protected Map<String,String> map = new HashMap<>();


    @ModelAttribute
    public void setRequest(HttpServletRequest request){
        Claims claims = JwtUtils.getClaims(request);
        this.claims = claims;
        this.nikename = claims.getSubject();
        map.put("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        map.put("nikename",this.nikename);
        this.map = map;
    }


}
