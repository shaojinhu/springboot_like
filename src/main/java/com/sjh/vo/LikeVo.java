package com.sjh.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeVo implements Serializable {


    private String serialID;

    private String manName;

    private String manAddress;

    private String manTel;

    private String operateName;

    private String operateDateTime;

    private String hot;



    private Integer companyOid;

    private String companyName;

    private Integer manStation;

    private String manStationName;

    private String manType;

    private String manTypeName;

}
