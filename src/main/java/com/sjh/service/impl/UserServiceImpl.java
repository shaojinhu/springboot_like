package com.sjh.service.impl;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sjh.mapper.UserMapper;
import com.sjh.pojo.User;
import com.sjh.response.Result;
import com.sjh.response.ResultCode;
import com.sjh.service.UserService;
import com.sjh.util.JwtUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        User user1 = userMapper.selectOne(queryWrapper);
        String password = user1.getPassword();
        if(password.equals(user.getPassword())){
            String jwt = JwtUtils.createJwt(user1.getId().toString(), user1.getNikename());
            return new Result(ResultCode.SUCCESS,jwt);
        }

        return Result.FAIL();
    }
}
