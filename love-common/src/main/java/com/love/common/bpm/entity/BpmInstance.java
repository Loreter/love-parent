package com.love.common.bpm.entity;

import java.io.Serializable;

/**
 * 流程实例表(BpmInstance)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmInstance implements Serializable {
    private static final long serialVersionUID = 827550874190466781L;
    /**
    * 实例id
    */
    private String instanceId;
    /**
    * 流程id
    */
    private String wfId;
    /**
    * 启动时间
    */
    private Object startTime;
    /**
    * 启动用户id
    */
    private String userName;
    /**
    * 父流程id
    */
    private String parentId;
    /**
    * 业务实体id
    */
    private String objectId;


    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public Object getStartTime() {
        return startTime;
    }

    public void setStartTime(Object startTime) {
        this.startTime = startTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

}