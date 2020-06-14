package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmAudit;
import java.util.List;

/**
 * 流程审核表(BpmAudit)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmAuditService {

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    BpmAudit queryById(String aid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmAudit> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmAudit 实例对象
     * @return 实例对象
     */
    BpmAudit insert(BpmAudit bpmAudit);

    /**
     * 修改数据
     *
     * @param bpmAudit 实例对象
     * @return 实例对象
     */
    BpmAudit update(BpmAudit bpmAudit);

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 是否成功
     */
    boolean deleteById(String aid);

}