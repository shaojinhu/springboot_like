package com.sjh.service.impl;

import com.sjh.mapper.TypeMapper;
import com.sjh.pojo.Station;
import com.sjh.pojo.Type;
import com.sjh.response.Result;
import com.sjh.response.ResultCode;
import com.sjh.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;

    @Override
    public Result getTypeList() {
        List<Type> types = typeMapper.selectList(null);
        return new Result(ResultCode.SUCCESS,types);
    }
}
