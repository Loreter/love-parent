package com.love.common.bpm.entity;

import java.io.Serializable;

/**
 * 流程使用表(BpmBusUse)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmBusUse implements Serializable {
    private static final long serialVersionUID = 814759178855149187L;
    /**
    * 流程使用id
    */
    private String useId;
    /**
    * 业务id
    */
    private String busId;
    /**
    * 流程定义id
    */
    private String wfId;
    /**
    * 修改时间
    */
    private Object updateDate;
    /**
    * 备注
    */
    private String remarks;


    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public Object getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Object updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}