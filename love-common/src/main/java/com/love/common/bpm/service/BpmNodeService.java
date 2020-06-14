package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmNode;
import java.util.List;

/**
 * 流程节点表(BpmNode)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmNodeService {

    /**
     * 通过ID查询单条数据
     *
     * @param nodeId 主键
     * @return 实例对象
     */
    BpmNode queryById(String nodeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmNode> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmNode 实例对象
     * @return 实例对象
     */
    BpmNode insert(BpmNode bpmNode);

    /**
     * 修改数据
     *
     * @param bpmNode 实例对象
     * @return 实例对象
     */
    BpmNode update(BpmNode bpmNode);

    /**
     * 通过主键删除数据
     *
     * @param nodeId 主键
     * @return 是否成功
     */
    boolean deleteById(String nodeId);

}