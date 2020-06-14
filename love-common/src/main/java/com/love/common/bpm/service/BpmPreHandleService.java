package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmPreHandle;
import java.util.List;

/**
 * 待处理事务表(BpmPreHandle)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmPreHandleService {

    /**
     * 通过ID查询单条数据
     *
     * @param handleId 主键
     * @return 实例对象
     */
    BpmPreHandle queryById(String handleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmPreHandle> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmPreHandle 实例对象
     * @return 实例对象
     */
    BpmPreHandle insert(BpmPreHandle bpmPreHandle);

    /**
     * 修改数据
     *
     * @param bpmPreHandle 实例对象
     * @return 实例对象
     */
    BpmPreHandle update(BpmPreHandle bpmPreHandle);

    /**
     * 通过主键删除数据
     *
     * @param handleId 主键
     * @return 是否成功
     */
    boolean deleteById(String handleId);

}