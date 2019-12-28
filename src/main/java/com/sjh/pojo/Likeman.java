package com.sjh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("likeman")
public class Likeman implements Serializable {


    @TableId(value = "serialID",type = IdType.ID_WORKER_STR)
    private String serialID;

    @TableField("manName")
    private String manName;


    @TableField("manAddress")
    private String manAddress;

    @TableField("manTel")
    private String manTel;

    @TableField("operateName")
    private String operateName;

    @TableField("operateDateTime")
    private String operateDateTime;

    @TableField("hot")
    private String hot;


    @TableField("manStation")
    private Integer manStation;

    @TableField("companyOid")
    private Integer companyOid;

    @TableField("manType")
    private Integer manType;

}
