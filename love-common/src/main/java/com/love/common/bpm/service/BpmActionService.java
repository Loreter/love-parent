package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmAction;

import java.util.List;

/**
 * 节点转向表(BpmAction)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmActionService {

    /**
     * 通过ID查询单条数据
     *
     * @param actionId 主键
     * @return 实例对象
     */
    BpmAction queryById(String actionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmAction> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmAction 实例对象
     * @return 实例对象
     */
    BpmAction insert(BpmAction bpmAction);

    /**
     * 修改数据
     *
     * @param bpmAction 实例对象
     * @return 实例对象
     */
    BpmAction update(BpmAction bpmAction);

    /**
     * 通过主键删除数据
     *
     * @param actionId 主键
     * @return 是否成功
     */
    boolean deleteById(String actionId);

}