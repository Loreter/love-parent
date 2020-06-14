package com.love.common.bpm.dao;

import com.love.common.bpm.entity.BpmNode;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 流程节点表(BpmNode)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmNodeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param nodeId 主键
     * @return 实例对象
     */
    BpmNode queryById(String nodeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmNode> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bpmNode 实例对象
     * @return 对象列表
     */
    List<BpmNode> queryAll(BpmNode bpmNode);

    /**
     * 新增数据
     *
     * @param bpmNode 实例对象
     * @return 影响行数
     */
    int insert(BpmNode bpmNode);

    /**
     * 修改数据
     *
     * @param bpmNode 实例对象
     * @return 影响行数
     */
    int update(BpmNode bpmNode);

    /**
     * 通过主键删除数据
     *
     * @param nodeId 主键
     * @return 影响行数
     */
    int deleteById(String nodeId);

}