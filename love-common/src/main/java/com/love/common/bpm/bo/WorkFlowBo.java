package com.love.common.bpm.bo;

import java.io.Serializable;
import java.util.List;

/**
 * 工作流数据对象
 *
 * @author 孙振岳
 */
public class WorkFlowBo implements Serializable {

    private static final long serialVersionUID = 42L;

    /**
     * 工作流业务编码(bpm_business.business_id)
     */
    String wfBusId;
    /**
     * 启动流程用户ID
     */
    String userId;
    /**
     * 关键词
     */
    String keyword;
    /**
     * 业务主键
     */
    String objId;
    /**
     * 操作人权限集合
     */
    List<String> entIds;

    public WorkFlowBo(String wfBusId, String userId, String keyword, String objId, List<String> entIds) {
        this.wfBusId = wfBusId;
        this.userId = userId;
        this.keyword = keyword;
        this.objId = objId;
        this.entIds = entIds;
    }

    public String getWfBusId() {
        return wfBusId;
    }

    public void setWfBusId(String wfBusId) {
        this.wfBusId = wfBusId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public List<String> getEntIds() {
        return entIds;
    }

    public void setEntIds(List<String> entIds) {
        this.entIds = entIds;
    }
}
