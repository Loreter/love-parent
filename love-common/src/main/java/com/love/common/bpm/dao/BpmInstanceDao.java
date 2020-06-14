package com.love.common.bpm.dao;

import com.love.common.bpm.entity.BpmInstance;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 流程实例表(BpmInstance)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmInstanceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param instanceId 主键
     * @return 实例对象
     */
    BpmInstance queryById(String instanceId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmInstance> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bpmInstance 实例对象
     * @return 对象列表
     */
    List<BpmInstance> queryAll(BpmInstance bpmInstance);

    /**
     * 新增数据
     *
     * @param bpmInstance 实例对象
     * @return 影响行数
     */
    int insert(BpmInstance bpmInstance);

    /**
     * 修改数据
     *
     * @param bpmInstance 实例对象
     * @return 影响行数
     */
    int update(BpmInstance bpmInstance);

    /**
     * 通过主键删除数据
     *
     * @param instanceId 主键
     * @return 影响行数
     */
    int deleteById(String instanceId);

}