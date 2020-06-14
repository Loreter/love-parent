package com.love.common.bpm.dao;

import com.love.common.bpm.entity.BpmPreHandle;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 待处理事务表(BpmPreHandle)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmPreHandleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param handleId 主键
     * @return 实例对象
     */
    BpmPreHandle queryById(String handleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmPreHandle> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bpmPreHandle 实例对象
     * @return 对象列表
     */
    List<BpmPreHandle> queryAll(BpmPreHandle bpmPreHandle);

    /**
     * 新增数据
     *
     * @param bpmPreHandle 实例对象
     * @return 影响行数
     */
    int insert(BpmPreHandle bpmPreHandle);

    /**
     * 修改数据
     *
     * @param bpmPreHandle 实例对象
     * @return 影响行数
     */
    int update(BpmPreHandle bpmPreHandle);

    /**
     * 通过主键删除数据
     *
     * @param handleId 主键
     * @return 影响行数
     */
    int deleteById(String handleId);

}