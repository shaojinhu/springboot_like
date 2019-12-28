package com.sjh.util;

import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
@Component
public class JwtUtils {

  //签名私钥
  private static String key = "educational";
  //签名的失效时间
  private static Long ttl = 60 * 60 * 1000L;

  /**
   * 设置认证token
   *      id:登录用户id
   *      subject：登录用户名
   *
   */
  public static String createJwt(String id, String name) {
    //1.设置失效时间
    long now = System.currentTimeMillis();//当前毫秒
    long exp = now + ttl;
    //2.创建jwtBuilder
    JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(name)
        .setIssuedAt(new Date())
        .signWith(SignatureAlgorithm.HS256, key);
    //设置过期时间
    jwtBuilder.setExpiration(new Date(exp));
    //4.创建token
    String token = jwtBuilder.compact();

    return token;
  }


  /**
   * 解析token字符串获取clamis  在这里处理token过期
   */
  public static Claims parseJwt(String token) {
    Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    return claims;
  }


  /**
   * 从请求中获取token
   * @param request
   * @return
   */
  public static Claims getClaims(HttpServletRequest request){
    String Authorization = request.getHeader("Authorization");
    String token = Authorization.substring(6).trim();//切掉前6位，并去掉空格
    Claims claims = JwtUtils.parseJwt(token);
    return claims;
  }


}
