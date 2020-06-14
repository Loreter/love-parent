package com.love.common.bpm.entity;

import java.io.Serializable;

/**
 * 流程节点表(BpmNode)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmNode implements Serializable {
    private static final long serialVersionUID = 799071524804887480L;
    /**
    * 自增长列
    */
    private String nodeId;
    
    private String wfId;
    /**
    * 节点名称
    */
    private String nodeName;
    /**
    * 0:开始节点;1:普通节点;2:结束节点;3:分散节点;4:汇聚节点
    */
    private Double nodeType;
    /**
    * 权限编号
    */
    private String entitlement;
    /**
    * 页面id
    */
    private String codePageId;
    /**
    * 节点回调函数,该函数返回唯一可执行的operation_id
    */
    private String operationCall;
    /**
    * 详情页URL
    */
    private String pageUrl;


    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Double getNodeType() {
        return nodeType;
    }

    public void setNodeType(Double nodeType) {
        this.nodeType = nodeType;
    }

    public String getEntitlement() {
        return entitlement;
    }

    public void setEntitlement(String entitlement) {
        this.entitlement = entitlement;
    }

    public String getCodePageId() {
        return codePageId;
    }

    public void setCodePageId(String codePageId) {
        this.codePageId = codePageId;
    }

    public String getOperationCall() {
        return operationCall;
    }

    public void setOperationCall(String operationCall) {
        this.operationCall = operationCall;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

}