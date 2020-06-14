package com.love.common.bpm.dao;

import com.love.common.bpm.entity.BpmBusUse;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 流程使用表(BpmBusUse)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmBusUseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param useId 主键
     * @return 实例对象
     */
    BpmBusUse queryById(String useId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmBusUse> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bpmBusUse 实例对象
     * @return 对象列表
     */
    List<BpmBusUse> queryAll(BpmBusUse bpmBusUse);

    /**
     * 新增数据
     *
     * @param bpmBusUse 实例对象
     * @return 影响行数
     */
    int insert(BpmBusUse bpmBusUse);

    /**
     * 修改数据
     *
     * @param bpmBusUse 实例对象
     * @return 影响行数
     */
    int update(BpmBusUse bpmBusUse);

    /**
     * 通过主键删除数据
     *
     * @param useId 主键
     * @return 影响行数
     */
    int deleteById(String useId);

}