package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmBusiness;
import java.util.List;

/**
 * 流程业务表(BpmBusiness)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmBusinessService {

    /**
     * 通过ID查询单条数据
     *
     * @param businessId 主键
     * @return 实例对象
     */
    BpmBusiness queryById(String businessId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmBusiness> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmBusiness 实例对象
     * @return 实例对象
     */
    BpmBusiness insert(BpmBusiness bpmBusiness);

    /**
     * 修改数据
     *
     * @param bpmBusiness 实例对象
     * @return 实例对象
     */
    BpmBusiness update(BpmBusiness bpmBusiness);

    /**
     * 通过主键删除数据
     *
     * @param businessId 主键
     * @return 是否成功
     */
    boolean deleteById(String businessId);

}