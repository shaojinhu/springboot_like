package com.sjh.service.impl;

import com.sjh.mapper.CompanyMapper;
import com.sjh.pojo.Company;
import com.sjh.pojo.Station;
import com.sjh.response.Result;
import com.sjh.response.ResultCode;
import com.sjh.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;


    @Override
    public Result getCompanyList() {

        List<Company> companies = companyMapper.selectList(null);
        return new Result(ResultCode.SUCCESS,companies);
    }
}
