package com.love.common.bpm.entity;

import java.io.Serializable;

/**
 * 流程实例变量表(BpmVar)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmVar implements Serializable {
    private static final long serialVersionUID = 921848477797604739L;
    /**
    * 流程实例变量id
    */
    private String varId;
    /**
    * 实例id
    */
    private String instanceId;
    /**
    * 变量名
    */
    private String varName;
    /**
    * 变量值
    */
    private Object varValue;


    public String getVarId() {
        return varId;
    }

    public void setVarId(String varId) {
        this.varId = varId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public Object getVarValue() {
        return varValue;
    }

    public void setVarValue(Object varValue) {
        this.varValue = varValue;
    }

}