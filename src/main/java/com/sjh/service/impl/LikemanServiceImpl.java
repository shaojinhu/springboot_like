package com.sjh.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sjh.mapper.LikemanMapper;
import com.sjh.pojo.Likeman;
import com.sjh.response.PageResult;
import com.sjh.response.Result;
import com.sjh.response.ResultCode;
import com.sjh.service.LikemanService;
import com.sjh.vo.LikeVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@SuppressWarnings("ALL")
public class LikemanServiceImpl implements LikemanService {

    @Resource
    private LikemanMapper likemanMapper;

    @Override
    public Result getLikemanList(Map<String, String> map) {
        Integer page = Integer.parseInt(map.get("page"));
        Integer size = Integer.parseInt(map.get("size"));

        IPage<LikeVo> iPage = new Page<>(page,size);
        List<LikeVo> listVoList = likemanMapper.getListVoList(iPage);
        long total = iPage.getTotal();
        PageResult<LikeVo> pageResult = new PageResult<>(total,listVoList);
        return new Result(ResultCode.SUCCESS,pageResult);
    }

    @Override
    public Result add(Likeman likeman, Map<String, String> map) {
        String nikename = map.get("nikename");
        String time = map.get("time");
        likeman.setOperateName(nikename);
        likeman.setOperateDateTime(time);
        int insert = likemanMapper.insert(likeman);
        if(insert > 0){
            return Result.SUCCESS();
        }
        return Result.FAIL();
    }

    @Override
    public Result update(Likeman likeman, Map<String, String> map) {
        String nikename = map.get("nikename");
        String time = map.get("time");
        likeman.setOperateName(nikename);
        likeman.setOperateDateTime(time);
        int insert = likemanMapper.updateById(likeman);
        if(insert > 0){
            return Result.SUCCESS();
        }
        return Result.FAIL();
    }

    @Override
    public Result delete(Map<String, String> map) {
        String id = map.get("id");
        int i = likemanMapper.deleteById(id);
        if(i > 0){
            return Result.SUCCESS();
        }
        return Result.FAIL();
    }


}
