package com.love.common.bpm.service.impl;

import com.love.common.bpm.entity.BpmDefine;
import com.love.common.bpm.dao.BpmDefineDao;
import com.love.common.bpm.service.BpmDefineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程定义表(BpmDefine)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmDefineService")
public class BpmDefineServiceImpl implements BpmDefineService {
    @Resource
    private BpmDefineDao bpmDefineDao;

    /**
     * 通过ID查询单条数据
     *
     * @param wfId 主键
     * @return 实例对象
     */
    @Override
    public BpmDefine queryById(String wfId) {
        return this.bpmDefineDao.queryById(wfId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmDefine> queryAllByLimit(int offset, int limit) {
        return this.bpmDefineDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmDefine 实例对象
     * @return 实例对象
     */
    @Override
    public BpmDefine insert(BpmDefine bpmDefine) {
        this.bpmDefineDao.insert(bpmDefine);
        return bpmDefine;
    }

    /**
     * 修改数据
     *
     * @param bpmDefine 实例对象
     * @return 实例对象
     */
    @Override
    public BpmDefine update(BpmDefine bpmDefine) {
        this.bpmDefineDao.update(bpmDefine);
        return this.queryById(bpmDefine.getWfId());
    }

    /**
     * 通过主键删除数据
     *
     * @param wfId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String wfId) {
        return this.bpmDefineDao.deleteById(wfId) > 0;
    }
}