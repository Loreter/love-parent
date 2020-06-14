package com.love.common.bpm.entity;

import java.io.Serializable;

/**
 * 待处理事务表(BpmPreHandle)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmPreHandle implements Serializable {
    private static final long serialVersionUID = 318083827610633407L;
    /**
    * 自增长列
    */
    private String handleId;
    /**
    * 流程实例
    */
    private String instanceId;
    /**
    * 处理角色
    */
    private String roleId;
    /**
    * 代办状态
    */
    private Object preStatus;
    /**
    * 创建时间
    */
    private Object creatTime;
    /**
    * 处理时间
    */
    private Object handleTime;
    /**
    * 相关业务id
    */
    private String objId;
    /**
    * 锁定人id
    */
    private String lockUserId;
    /**
    * 锁定时间
    */
    private Object lockTime;
    /**
    * 当前节点id
    */
    private String curnodeId;
    /**
    * 动作id
    */
    private String operationId;
    /**
    * 相关节点id
    */
    private String oldNodeId;


    public String getHandleId() {
        return handleId;
    }

    public void setHandleId(String handleId) {
        this.handleId = handleId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Object getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Object preStatus) {
        this.preStatus = preStatus;
    }

    public Object getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Object creatTime) {
        this.creatTime = creatTime;
    }

    public Object getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Object handleTime) {
        this.handleTime = handleTime;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getLockUserId() {
        return lockUserId;
    }

    public void setLockUserId(String lockUserId) {
        this.lockUserId = lockUserId;
    }

    public Object getLockTime() {
        return lockTime;
    }

    public void setLockTime(Object lockTime) {
        this.lockTime = lockTime;
    }

    public String getCurnodeId() {
        return curnodeId;
    }

    public void setCurnodeId(String curnodeId) {
        this.curnodeId = curnodeId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOldNodeId() {
        return oldNodeId;
    }

    public void setOldNodeId(String oldNodeId) {
        this.oldNodeId = oldNodeId;
    }

}