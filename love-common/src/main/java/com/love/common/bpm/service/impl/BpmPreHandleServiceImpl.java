package com.love.common.bpm.service.impl;

import com.love.common.bpm.entity.BpmPreHandle;
import com.love.common.bpm.dao.BpmPreHandleDao;
import com.love.common.bpm.service.BpmPreHandleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 待处理事务表(BpmPreHandle)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmPreHandleService")
public class BpmPreHandleServiceImpl implements BpmPreHandleService {
    @Resource
    private BpmPreHandleDao bpmPreHandleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param handleId 主键
     * @return 实例对象
     */
    @Override
    public BpmPreHandle queryById(String handleId) {
        return this.bpmPreHandleDao.queryById(handleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmPreHandle> queryAllByLimit(int offset, int limit) {
        return this.bpmPreHandleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmPreHandle 实例对象
     * @return 实例对象
     */
    @Override
    public BpmPreHandle insert(BpmPreHandle bpmPreHandle) {
        this.bpmPreHandleDao.insert(bpmPreHandle);
        return bpmPreHandle;
    }

    /**
     * 修改数据
     *
     * @param bpmPreHandle 实例对象
     * @return 实例对象
     */
    @Override
    public BpmPreHandle update(BpmPreHandle bpmPreHandle) {
        this.bpmPreHandleDao.update(bpmPreHandle);
        return this.queryById(bpmPreHandle.getHandleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param handleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String handleId) {
        return this.bpmPreHandleDao.deleteById(handleId) > 0;
    }
}