package com.love.common.bpm.entity;

import java.io.Serializable;

/**
 * 流程定义表(BpmDefine)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmDefine implements Serializable {
    private static final long serialVersionUID = -61846698011487670L;
    /**
    * 自增长列
    */
    private String wfId;
    /**
    * 流程名称
    */
    private String wfName;
    /**
    * 流程编码
    */
    private String wfCode;
    /**
    * 状态--1:正常,0:关闭
    */
    private Double status;
    /**
    * 发布时间
    */
    private Object creatDate;
    /**
    * 备注
    */
    private String remarks;
    /**
    * 业务id
    */
    private String busId;


    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public String getWfName() {
        return wfName;
    }

    public void setWfName(String wfName) {
        this.wfName = wfName;
    }

    public String getWfCode() {
        return wfCode;
    }

    public void setWfCode(String wfCode) {
        this.wfCode = wfCode;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public Object getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Object creatDate) {
        this.creatDate = creatDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

}