package com.sjh.response;

public enum ResultCode {


  SUCCESS(true,10000,"恭喜你,操作成功"),
  FAIL(false,10001,"操作失败,请检查你的网络"),
  LOGIN_USER_NOT_ENABLE_STATE(false,80088,"登录用户不存在或密码错误或被禁用"),
  CLASS_REPETITION(false,70077,"班级重复"),
  NO_PERMISSION(false,50055,"没有权限操作此功能");

  int code;
  String message;
  boolean success;


  ResultCode(boolean success,int code,String message){
    this.success = success;
    this.code = code;
    this.message = message;
  }

  public int code(){
    return code;
  }

  public String message(){
    return message;
  }

  public boolean success(){
    return success;
  }
}
