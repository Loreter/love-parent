package com.love.common.bpm.service;

import com.love.common.bpm.entity.BpmKeyword;
import java.util.List;

/**
 * 工作流关键词(BpmKeyword)表服务接口
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
public interface BpmKeywordService {

    /**
     * 通过ID查询单条数据
     *
     * @param kid 主键
     * @return 实例对象
     */
    BpmKeyword queryById(String kid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BpmKeyword> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bpmKeyword 实例对象
     * @return 实例对象
     */
    BpmKeyword insert(BpmKeyword bpmKeyword);

    /**
     * 修改数据
     *
     * @param bpmKeyword 实例对象
     * @return 实例对象
     */
    BpmKeyword update(BpmKeyword bpmKeyword);

    /**
     * 通过主键删除数据
     *
     * @param kid 主键
     * @return 是否成功
     */
    boolean deleteById(String kid);

}