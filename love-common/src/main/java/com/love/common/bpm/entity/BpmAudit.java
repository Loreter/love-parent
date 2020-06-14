package com.love.common.bpm.entity;

import java.io.Serializable;

/**
 * 流程审核表(BpmAudit)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmAudit implements Serializable {
    private static final long serialVersionUID = -74665911317796377L;
    /**
    * 自增长id
    */
    private String aid;
    /**
    * 实例流程
    */
    private String instanceId;
    /**
    * 所属流程
    */
    private String wfId;
    /**
    * 所属节点
    */
    private String nodeId;
    /**
    * 下一个节点id
    */
    private String nextNodeId;
    /**
    * 审批人
    */
    private String userId;
    /**
    * 动作id
    */
    private String operationId;
    /**
    * 审核时间
    */
    private Object creatTime;
    /**
    * 代办状态
    */
    private Object status;
    /**
    * 处理人ID
    */
    private String handleId;
    /**
    * 拒绝理由
    */
    private String rejectReason;
    /**
    * 商户id
    */
    private String vendorId;


    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

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

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNextNodeId() {
        return nextNodeId;
    }

    public void setNextNodeId(String nextNodeId) {
        this.nextNodeId = nextNodeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public Object getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Object creatTime) {
        this.creatTime = creatTime;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getHandleId() {
        return handleId;
    }

    public void setHandleId(String handleId) {
        this.handleId = handleId;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

}