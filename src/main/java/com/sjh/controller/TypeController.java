package com.sjh.controller;

import com.sjh.response.Result;
import com.sjh.service.StationService;
import com.sjh.service.TypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("type")
public class TypeController {

    @Resource
    private TypeService typeService;

    @GetMapping("getTypeList")
    private Result getTypeList(){
        return typeService.getTypeList();
    }

}
