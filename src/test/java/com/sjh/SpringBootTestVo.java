package com.sjh;

import com.sjh.service.LikemanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootTestVo {

    @Resource
    private LikemanService service;

    @Test
    public void getTest(){
        Map<String,String> map = new HashMap<>();
        map.put("page","1");
        map.put("size","2");
        service.getLikemanList(map);
    }
}
