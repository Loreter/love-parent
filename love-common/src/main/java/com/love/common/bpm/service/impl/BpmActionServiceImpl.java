package com.love.common.bpm.service.impl;

import com.love.common.bpm.dao.BpmActionDao;
import com.love.common.bpm.entity.BpmAction;
import com.love.common.bpm.service.BpmActionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 节点转向表(BpmAction)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmActionService")
public class BpmActionServiceImpl implements BpmActionService {
    @Resource
    private BpmActionDao bpmActionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param actionId 主键
     * @return 实例对象
     */
    @Override
    public BpmAction queryById(String actionId) {
        return this.bpmActionDao.queryById(actionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmAction> queryAllByLimit(int offset, int limit) {
        return this.bpmActionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmAction 实例对象
     * @return 实例对象
     */
    @Override
    public BpmAction insert(BpmAction bpmAction) {
        this.bpmActionDao.insert(bpmAction);
        return bpmAction;
    }

    /**
     * 修改数据
     *
     * @param bpmAction 实例对象
     * @return 实例对象
     */
    @Override
    public BpmAction update(BpmAction bpmAction) {
        this.bpmActionDao.update(bpmAction);
        return this.queryById(bpmAction.getActionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param actionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String actionId) {
        return this.bpmActionDao.deleteById(actionId) > 0;
    }
}