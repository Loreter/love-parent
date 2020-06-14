package com.love.common.api;

import com.love.common.bpm.entity.BpmAction;

import java.util.Map;

/**
 * @author 孙振岳
 */
public interface BpmActionApi {

    /**
     * 根据编号查询实体map
     * @param actionId
     * @return
     */
    Map<String,Object> queryById(String actionId);
}
