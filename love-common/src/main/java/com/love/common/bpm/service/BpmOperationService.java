package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmOperation;
import java.util.List;

/**
 * 流程动作表(BpmOperation)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmOperationService {

    /**
     * 通过ID查询单条数据
     *
     * @param operationId 主键
     * @return 实例对象
     */
    BpmOperation queryById(String operationId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmOperation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmOperation 实例对象
     * @return 实例对象
     */
    BpmOperation insert(BpmOperation bpmOperation);

    /**
     * 修改数据
     *
     * @param bpmOperation 实例对象
     * @return 实例对象
     */
    BpmOperation update(BpmOperation bpmOperation);

    /**
     * 通过主键删除数据
     *
     * @param operationId 主键
     * @return 是否成功
     */
    boolean deleteById(String operationId);

}