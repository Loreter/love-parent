package com.love.common.bpm.dao;

import com.love.common.bpm.entity.BpmAudit;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 流程审核表(BpmAudit)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmAuditDao {

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    BpmAudit queryById(String aid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmAudit> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bpmAudit 实例对象
     * @return 对象列表
     */
    List<BpmAudit> queryAll(BpmAudit bpmAudit);

    /**
     * 新增数据
     *
     * @param bpmAudit 实例对象
     * @return 影响行数
     */
    int insert(BpmAudit bpmAudit);

    /**
     * 修改数据
     *
     * @param bpmAudit 实例对象
     * @return 影响行数
     */
    int update(BpmAudit bpmAudit);

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 影响行数
     */
    int deleteById(String aid);

}