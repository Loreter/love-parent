package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmInstance;
import java.util.List;

/**
 * 流程实例表(BpmInstance)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmInstanceService {

    /**
     * 通过ID查询单条数据
     *
     * @param instanceId 主键
     * @return 实例对象
     */
    BpmInstance queryById(String instanceId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmInstance> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmInstance 实例对象
     * @return 实例对象
     */
    BpmInstance insert(BpmInstance bpmInstance);

    /**
     * 修改数据
     *
     * @param bpmInstance 实例对象
     * @return 实例对象
     */
    BpmInstance update(BpmInstance bpmInstance);

    /**
     * 通过主键删除数据
     *
     * @param instanceId 主键
     * @return 是否成功
     */
    boolean deleteById(String instanceId);

}