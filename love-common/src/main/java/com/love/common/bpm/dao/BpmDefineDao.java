package com.love.common.bpm.dao;

import com.love.common.bpm.entity.BpmDefine;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 流程定义表(BpmDefine)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmDefineDao {

    /**
     * 通过ID查询单条数据
     *
     * @param wfId 主键
     * @return 实例对象
     */
    BpmDefine queryById(String wfId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmDefine> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bpmDefine 实例对象
     * @return 对象列表
     */
    List<BpmDefine> queryAll(BpmDefine bpmDefine);

    /**
     * 新增数据
     *
     * @param bpmDefine 实例对象
     * @return 影响行数
     */
    int insert(BpmDefine bpmDefine);

    /**
     * 修改数据
     *
     * @param bpmDefine 实例对象
     * @return 影响行数
     */
    int update(BpmDefine bpmDefine);

    /**
     * 通过主键删除数据
     *
     * @param wfId 主键
     * @return 影响行数
     */
    int deleteById(String wfId);

}