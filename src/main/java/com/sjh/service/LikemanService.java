package com.sjh.service;

import com.sjh.pojo.Likeman;
import com.sjh.response.Result;

import java.util.Map;

public interface LikemanService {
    Result getLikemanList(Map<String, String> map);

    Result add(Likeman likeman, Map<String, String> map);

    Result update(Likeman likeman, Map<String, String> map);

    Result delete(Map<String, String> map);
}
