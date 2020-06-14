package com.love.common.bpm.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 节点转向表(BpmAction)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmAction implements Serializable {
    private static final long serialVersionUID = -12060945643545461L;
    /**
    * 节点转向id
    */
    private String actionId;
    /**
    * 起始节点
    */
    private String startNode;
    /**
    * 结束节点
    */
    private String endNode;
    /**
    * 回调SQL
    */
    private Object exeSql;
    /**
    * 回调函数
    */
    private String callCalss;
    /**
    * 回调SQL参数
    */
    private String sqlVars;
    /**
    * 动作编号
    */
    private String operationId;


    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    public String getEndNode() {
        return endNode;
    }

    public void setEndNode(String endNode) {
        this.endNode = endNode;
    }

    public Object getExeSql() {
        return exeSql;
    }

    public void setExeSql(Object exeSql) {
        this.exeSql = exeSql;
    }

    public String getCallCalss() {
        return callCalss;
    }

    public void setCallCalss(String callCalss) {
        this.callCalss = callCalss;
    }

    public String getSqlVars() {
        return sqlVars;
    }

    public void setSqlVars(String sqlVars) {
        this.sqlVars = sqlVars;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BpmAction)) return false;
        BpmAction bpmAction = (BpmAction) o;
        return Objects.equals(actionId, bpmAction.actionId) &&
                Objects.equals(startNode, bpmAction.startNode) &&
                Objects.equals(endNode, bpmAction.endNode) &&
                Objects.equals(exeSql, bpmAction.exeSql) &&
                Objects.equals(callCalss, bpmAction.callCalss) &&
                Objects.equals(sqlVars, bpmAction.sqlVars) &&
                Objects.equals(operationId, bpmAction.operationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionId, startNode, endNode, exeSql, callCalss, sqlVars, operationId);
    }

    @Override
    public String toString() {
        return "BpmAction{" +
                "actionId='" + actionId + '\'' +
                ", startNode='" + startNode + '\'' +
                ", endNode='" + endNode + '\'' +
                ", exeSql=" + exeSql +
                ", callCalss='" + callCalss + '\'' +
                ", sqlVars='" + sqlVars + '\'' +
                ", operationId='" + operationId + '\'' +
                '}';
    }
}