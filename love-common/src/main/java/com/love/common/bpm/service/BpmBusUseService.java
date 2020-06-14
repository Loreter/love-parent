package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmBusUse;
import java.util.List;

/**
 * 流程使用表(BpmBusUse)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmBusUseService {

    /**
     * 通过ID查询单条数据
     *
     * @param useId 主键
     * @return 实例对象
     */
    BpmBusUse queryById(String useId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmBusUse> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmBusUse 实例对象
     * @return 实例对象
     */
    BpmBusUse insert(BpmBusUse bpmBusUse);

    /**
     * 修改数据
     *
     * @param bpmBusUse 实例对象
     * @return 实例对象
     */
    BpmBusUse update(BpmBusUse bpmBusUse);

    /**
     * 通过主键删除数据
     *
     * @param useId 主键
     * @return 是否成功
     */
    boolean deleteById(String useId);

}