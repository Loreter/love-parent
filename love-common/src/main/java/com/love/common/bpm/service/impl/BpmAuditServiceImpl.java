package com.love.common.bpm.service.impl;

import com.love.common.bpm.entity.BpmAudit;
import com.love.common.bpm.dao.BpmAuditDao;
import com.love.common.bpm.service.BpmAuditService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程审核表(BpmAudit)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmAuditService")
public class BpmAuditServiceImpl implements BpmAuditService {
    @Resource
    private BpmAuditDao bpmAuditDao;

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    @Override
    public BpmAudit queryById(String aid) {
        return this.bpmAuditDao.queryById(aid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmAudit> queryAllByLimit(int offset, int limit) {
        return this.bpmAuditDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmAudit 实例对象
     * @return 实例对象
     */
    @Override
    public BpmAudit insert(BpmAudit bpmAudit) {
        this.bpmAuditDao.insert(bpmAudit);
        return bpmAudit;
    }

    /**
     * 修改数据
     *
     * @param bpmAudit 实例对象
     * @return 实例对象
     */
    @Override
    public BpmAudit update(BpmAudit bpmAudit) {
        this.bpmAuditDao.update(bpmAudit);
        return this.queryById(bpmAudit.getAid());
    }

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String aid) {
        return this.bpmAuditDao.deleteById(aid) > 0;
    }
}