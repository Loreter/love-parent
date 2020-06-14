package com.love.common.bpm.service;

import com.love.common.bpm.bo.WorkFlowBo;

/**
 * 工作流集体方法
 *
 * @author 孙振岳
 */
public interface BpmService {
    /**
     * 开启工作流
     *
     * @param bo 工作流对象
     * @return string 工作流流程编号
     */
    public String startWorkFlow(WorkFlowBo bo);

    /**
     * 推动工作流
     *
     * @param bo 工作流对象
     * @return string 工作流执行结果
     */
    public String promoteWorkFlow(WorkFlowBo bo);

}
