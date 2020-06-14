package com.love.common.bpm.service.impl;

import com.love.common.bpm.entity.BpmVar;
import com.love.common.bpm.dao.BpmVarDao;
import com.love.common.bpm.service.BpmVarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程实例变量表(BpmVar)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmVarService")
public class BpmVarServiceImpl implements BpmVarService {
    @Resource
    private BpmVarDao bpmVarDao;

    /**
     * 通过ID查询单条数据
     *
     * @param varId 主键
     * @return 实例对象
     */
    @Override
    public BpmVar queryById(String varId) {
        return this.bpmVarDao.queryById(varId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmVar> queryAllByLimit(int offset, int limit) {
        return this.bpmVarDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmVar 实例对象
     * @return 实例对象
     */
    @Override
    public BpmVar insert(BpmVar bpmVar) {
        this.bpmVarDao.insert(bpmVar);
        return bpmVar;
    }

    /**
     * 修改数据
     *
     * @param bpmVar 实例对象
     * @return 实例对象
     */
    @Override
    public BpmVar update(BpmVar bpmVar) {
        this.bpmVarDao.update(bpmVar);
        return this.queryById(bpmVar.getVarId());
    }

    /**
     * 通过主键删除数据
     *
     * @param varId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String varId) {
        return this.bpmVarDao.deleteById(varId) > 0;
    }
}