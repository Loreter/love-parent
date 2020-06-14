package com.love.common.bpm.service.impl;

import com.love.common.bpm.entity.BpmInstance;
import com.love.common.bpm.dao.BpmInstanceDao;
import com.love.common.bpm.service.BpmInstanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程实例表(BpmInstance)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmInstanceService")
public class BpmInstanceServiceImpl implements BpmInstanceService {
    @Resource
    private BpmInstanceDao bpmInstanceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param instanceId 主键
     * @return 实例对象
     */
    @Override
    public BpmInstance queryById(String instanceId) {
        return this.bpmInstanceDao.queryById(instanceId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmInstance> queryAllByLimit(int offset, int limit) {
        return this.bpmInstanceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmInstance 实例对象
     * @return 实例对象
     */
    @Override
    public BpmInstance insert(BpmInstance bpmInstance) {
        this.bpmInstanceDao.insert(bpmInstance);
        return bpmInstance;
    }

    /**
     * 修改数据
     *
     * @param bpmInstance 实例对象
     * @return 实例对象
     */
    @Override
    public BpmInstance update(BpmInstance bpmInstance) {
        this.bpmInstanceDao.update(bpmInstance);
        return this.queryById(bpmInstance.getInstanceId());
    }

    /**
     * 通过主键删除数据
     *
     * @param instanceId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String instanceId) {
        return this.bpmInstanceDao.deleteById(instanceId) > 0;
    }
}