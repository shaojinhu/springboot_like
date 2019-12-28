package com.sjh.controller;

import com.sjh.response.Result;
import com.sjh.service.StationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("station")
public class StationController {

    @Resource
    private StationService stationService;

    @GetMapping("getStationList")
    private Result getStationList(){
        return stationService.getStationList();
    }

}
