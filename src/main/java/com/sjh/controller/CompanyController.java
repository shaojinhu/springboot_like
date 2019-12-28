package com.sjh.controller;

import com.sjh.response.Result;
import com.sjh.service.CompanyService;
import com.sjh.service.StationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Resource
    private CompanyService companyService;

    @GetMapping("getCompanyList")
    private Result getCompanyList(){
        return companyService.getCompanyList();
    }

}
