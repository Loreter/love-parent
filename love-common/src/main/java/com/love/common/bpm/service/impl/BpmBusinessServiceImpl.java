package com.love.common.bpm.service.impl;

import com.love.common.bpm.entity.BpmBusiness;
import com.love.common.bpm.dao.BpmBusinessDao;
import com.love.common.bpm.service.BpmBusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程业务表(BpmBusiness)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmBusinessService")
public class BpmBusinessServiceImpl implements BpmBusinessService {
    @Resource
    private BpmBusinessDao bpmBusinessDao;

    /**
     * 通过ID查询单条数据
     *
     * @param businessId 主键
     * @return 实例对象
     */
    @Override
    public BpmBusiness queryById(String businessId) {
        return this.bpmBusinessDao.queryById(businessId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmBusiness> queryAllByLimit(int offset, int limit) {
        return this.bpmBusinessDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmBusiness 实例对象
     * @return 实例对象
     */
    @Override
    public BpmBusiness insert(BpmBusiness bpmBusiness) {
        this.bpmBusinessDao.insert(bpmBusiness);
        return bpmBusiness;
    }

    /**
     * 修改数据
     *
     * @param bpmBusiness 实例对象
     * @return 实例对象
     */
    @Override
    public BpmBusiness update(BpmBusiness bpmBusiness) {
        this.bpmBusinessDao.update(bpmBusiness);
        return this.queryById(bpmBusiness.getBusinessId());
    }

    /**
     * 通过主键删除数据
     *
     * @param businessId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String businessId) {
        return this.bpmBusinessDao.deleteById(businessId) > 0;
    }
}