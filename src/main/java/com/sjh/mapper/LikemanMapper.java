package com.sjh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sjh.pojo.Likeman;
import com.sjh.vo.LikeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LikemanMapper extends BaseMapper<Likeman> {


    @Select("SELECT c.`companyOid` AS companyOid,c.`companyName` AS companyName, " +
            "l.`serialID` AS serialID,l.`manName` AS manName, " +
            "l.`manAddress` AS manAddress,l.manTel AS manTel, " +
            "l.`operateName` AS operateName,l.`operateDateTime` AS operateDateTime, " +
            "l.`hot` AS hot,t.`mantype` AS manType,t.`manname` AS manTypeName, " +
            "s.`manstation` AS manStation,s.`manstationname` AS manStationName " +
            "FROM `company` c,`likeman` l,`station` s,`type` t " +
            "WHERE c.`companyOid` = l.`companyOid` AND s.`manstation` = l.`manStation` AND " +
            "t.`mantype` = l.`manType` ")
    public List<LikeVo> getListVoList(IPage<LikeVo> page);
}
