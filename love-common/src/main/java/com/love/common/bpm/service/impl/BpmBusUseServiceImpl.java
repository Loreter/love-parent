package com.love.common.bpm.service.impl;

import com.love.common.bpm.entity.BpmBusUse;
import com.love.common.bpm.dao.BpmBusUseDao;
import com.love.common.bpm.service.BpmBusUseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程使用表(BpmBusUse)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmBusUseService")
public class BpmBusUseServiceImpl implements BpmBusUseService {
    @Resource
    private BpmBusUseDao bpmBusUseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param useId 主键
     * @return 实例对象
     */
    @Override
    public BpmBusUse queryById(String useId) {
        return this.bpmBusUseDao.queryById(useId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmBusUse> queryAllByLimit(int offset, int limit) {
        return this.bpmBusUseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmBusUse 实例对象
     * @return 实例对象
     */
    @Override
    public BpmBusUse insert(BpmBusUse bpmBusUse) {
        this.bpmBusUseDao.insert(bpmBusUse);
        return bpmBusUse;
    }

    /**
     * 修改数据
     *
     * @param bpmBusUse 实例对象
     * @return 实例对象
     */
    @Override
    public BpmBusUse update(BpmBusUse bpmBusUse) {
        this.bpmBusUseDao.update(bpmBusUse);
        return this.queryById(bpmBusUse.getUseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param useId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String useId) {
        return this.bpmBusUseDao.deleteById(useId) > 0;
    }
}