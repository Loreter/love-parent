package com.love.common.bpm.entity;

import java.io.Serializable;

/**
 * 流程动作表(BpmOperation)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmOperation implements Serializable {
    private static final long serialVersionUID = 261149344054979633L;
    /**
    * 动作id
    */
    private String operationId;
    /**
    * 动作名称
    */
    private String operationName;
    /**
    * 动作函数
    */
    private String operationFunction;
    /**
    * 动作描述
    */
    private Object operationdesc;
    /**
    * 节点id
    */
    private String nodeId;
    /**
    * 权限
    */
    private String entid;
    /**
    * 执行该操作的业务条件
    */
    private String conditionFunction;
    /**
    * 业务功能链接
    */
    private String bizurl;
    /**
    * 回调函数返回的匹配值
    */
    private String conditionValue;


    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationFunction() {
        return operationFunction;
    }

    public void setOperationFunction(String operationFunction) {
        this.operationFunction = operationFunction;
    }

    public Object getOperationdesc() {
        return operationdesc;
    }

    public void setOperationdesc(Object operationdesc) {
        this.operationdesc = operationdesc;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getEntid() {
        return entid;
    }

    public void setEntid(String entid) {
        this.entid = entid;
    }

    public String getConditionFunction() {
        return conditionFunction;
    }

    public void setConditionFunction(String conditionFunction) {
        this.conditionFunction = conditionFunction;
    }

    public String getBizurl() {
        return bizurl;
    }

    public void setBizurl(String bizurl) {
        this.bizurl = bizurl;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

}