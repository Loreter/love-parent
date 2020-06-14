package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmDefine;
import java.util.List;

/**
 * 流程定义表(BpmDefine)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmDefineService {

    /**
     * 通过ID查询单条数据
     *
     * @param wfId 主键
     * @return 实例对象
     */
    BpmDefine queryById(String wfId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmDefine> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmDefine 实例对象
     * @return 实例对象
     */
    BpmDefine insert(BpmDefine bpmDefine);

    /**
     * 修改数据
     *
     * @param bpmDefine 实例对象
     * @return 实例对象
     */
    BpmDefine update(BpmDefine bpmDefine);

    /**
     * 通过主键删除数据
     *
     * @param wfId 主键
     * @return 是否成功
     */
    boolean deleteById(String wfId);

}