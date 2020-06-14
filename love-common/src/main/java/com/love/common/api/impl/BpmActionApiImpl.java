package com.love.common.api.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.love.common.api.BpmActionApi;
import com.love.common.bpm.entity.BpmAction;
import com.love.common.bpm.service.BpmActionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BpmActionApiImpl implements BpmActionApi{

    @Autowired
    private BpmActionService bpmActionService;

    @Override
    public Map<String, Object> queryById(String actionId) {
        BpmAction bpmAction = new BpmAction();
        Map<String, Object> result = Maps.newHashMap();
        result.put("returnCode","SUCCESS");
        try {
            bpmAction = bpmActionService.queryById(actionId);
            if (Objects.nonNull(bpmAction)) {
                String jsonStr = JSONUtil.toJsonStr(bpmAction);
                result = JSONObject.parseObject(jsonStr, Map.class);
            }
        } catch (Exception e) {
            result.put("returnCode","FAIL");
            result.put("returnMsg",e.getMessage());
        }
        return result;
    }


    public static void main(String[] args) {
        BpmAction bpmAction = new BpmAction();
        bpmAction.setActionId(UUID.fastUUID().toString());
        bpmAction.setCallCalss(UUID.fastUUID().toString());
        bpmAction.setEndNode(UUID.fastUUID().toString());
        bpmAction.setOperationId(UUID.fastUUID().toString());
        bpmAction.setStartNode(UUID.fastUUID().toString());
        System.out.println(bpmAction);
        String jsonStr = JSONUtil.toJsonStr(bpmAction);
        System.out.println(jsonStr);
        cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        System.out.println(jsonObject);
        Map<String,Object> map = JSONObject.parseObject(jsonStr, Map.class);
        System.out.println(map);
    }
}
