package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmVar;
import java.util.List;

/**
 * 流程实例变量表(BpmVar)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmVarService {

    /**
     * 通过ID查询单条数据
     *
     * @param varId 主键
     * @return 实例对象
     */
    BpmVar queryById(String varId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmVar> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmVar 实例对象
     * @return 实例对象
     */
    BpmVar insert(BpmVar bpmVar);

    /**
     * 修改数据
     *
     * @param bpmVar 实例对象
     * @return 实例对象
     */
    BpmVar update(BpmVar bpmVar);

    /**
     * 通过主键删除数据
     *
     * @param varId 主键
     * @return 是否成功
     */
    boolean deleteById(String varId);

}