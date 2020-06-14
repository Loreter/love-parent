package com.love.common.bpm.entity;

import java.io.Serializable;

/**
 * 流程业务表(BpmBusiness)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmBusiness implements Serializable {
    private static final long serialVersionUID = -44628478377047874L;
    /**
    * 业务id 主键
    */
    private String businessId;
    /**
    * 业务名称
    */
    private String businessName;
    /**
    * 创建时间
    */
    private Object creatDate;
    /**
    * 状态--1:正常;0:关闭
    */
    private Object bpmStatus;
    /**
    * 备注
    */
    private String remarks;
    /**
    * 业务类型--1:运营;2:商户
    */
    private String busType;


    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Object getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Object creatDate) {
        this.creatDate = creatDate;
    }

    public Object getBpmStatus() {
        return bpmStatus;
    }

    public void setBpmStatus(Object bpmStatus) {
        this.bpmStatus = bpmStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

}