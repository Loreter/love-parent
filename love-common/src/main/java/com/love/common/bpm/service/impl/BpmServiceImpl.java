package com.love.common.bpm.service.impl;

import com.alibaba.fastjson.JSON;
import com.love.common.bpm.bo.WorkFlowBo;
import com.love.common.bpm.entity.BpmAction;
import com.love.common.bpm.service.BpmActionService;
import com.love.common.bpm.service.BpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工作流实现类
 *
 * @author 孙振岳
 */
@Service
public class BpmServiceImpl implements BpmService {

    @Autowired
    private BpmActionService actionService;

    @Override
    public String startWorkFlow(WorkFlowBo bo) {
        String instanceId = "";
        BpmAction bpmAction = actionService.queryById("");
        instanceId = JSON.toJSONString(bpmAction);
        return instanceId;
    }


    @Override
    public String promoteWorkFlow(WorkFlowBo bo) {
        return null;
    }
}
