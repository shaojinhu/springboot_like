package com.sjh.service;

import com.sjh.pojo.User;
import com.sjh.response.Result;

public interface UserService {
    Result login(User user);
}
