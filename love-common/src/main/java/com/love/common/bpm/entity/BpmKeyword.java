package com.love.common.bpm.entity;

import java.io.Serializable;

/**
 * 工作流关键词(BpmKeyword)实体类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public class BpmKeyword implements Serializable {
    private static final long serialVersionUID = -86005881879922898L;
    /**
    * 唯一id
    */
    private String kid;
    /**
    * 流程实例id
    */
    private String instanceId;
    /**
    * 业务主键id
    */
    private String busiId;
    /**
    * 业务对象名称
    */
    private String busiName;
    /**
    * 流程类型编码
    */
    private String wfCode;
    /**
    * 用户类型:1:运营中心;2:商户中心
    */
    private String busiType;


    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public String getBusiName() {
        return busiName;
    }

    public void setBusiName(String busiName) {
        this.busiName = busiName;
    }

    public String getWfCode() {
        return wfCode;
    }

    public void setWfCode(String wfCode) {
        this.wfCode = wfCode;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

}