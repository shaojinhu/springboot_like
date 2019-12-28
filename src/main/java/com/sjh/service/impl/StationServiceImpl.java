package com.sjh.service.impl;

import com.sjh.mapper.StationMapper;
import com.sjh.pojo.Station;
import com.sjh.response.Result;
import com.sjh.response.ResultCode;
import com.sjh.service.StationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StationServiceImpl implements StationService {

    @Resource
    private StationMapper stationMapper;

    @Override
    public Result getStationList() {

        List<Station> stations = stationMapper.selectList(null);
        return new Result(ResultCode.SUCCESS,stations);
    }
}
