package com.sjh.controller;

import com.sjh.config.BaseController;
import com.sjh.pojo.Likeman;
import com.sjh.response.Result;
import com.sjh.service.LikemanService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("likeman")
public class LikemanController extends BaseController {

    @Resource
    private LikemanService likemanService;

    @PostMapping("getLikemanList")
    private Result getLikemanList(@RequestBody Map<String,String> map){
        return likemanService.getLikemanList(map);
    }

    @PostMapping("add")
    private Result addLikeman(@RequestBody Likeman likeman){
        return likemanService.add(likeman,super.map);
    }

    @PutMapping("update")
    private Result updateLikeman(@RequestBody Likeman likeman){
        return likemanService.update(likeman,super.map);
    }

    @DeleteMapping("delete")
    private Result deleteLikeman(@RequestBody Map<String,String> map){
        return likemanService.delete(map);
    }

}
