package com.love.common.bpm.dao;

import com.love.common.bpm.entity.BpmVar;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 流程实例变量表(BpmVar)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmVarDao {

    /**
     * 通过ID查询单条数据
     *
     * @param varId 主键
     * @return 实例对象
     */
    BpmVar queryById(String varId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmVar> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bpmVar 实例对象
     * @return 对象列表
     */
    List<BpmVar> queryAll(BpmVar bpmVar);

    /**
     * 新增数据
     *
     * @param bpmVar 实例对象
     * @return 影响行数
     */
    int insert(BpmVar bpmVar);

    /**
     * 修改数据
     *
     * @param bpmVar 实例对象
     * @return 影响行数
     */
    int update(BpmVar bpmVar);

    /**
     * 通过主键删除数据
     *
     * @param varId 主键
     * @return 影响行数
     */
    int deleteById(String varId);

}