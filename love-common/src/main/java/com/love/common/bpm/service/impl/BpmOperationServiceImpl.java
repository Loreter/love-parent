package com.love.common.bpm.service.impl;

import com.love.common.bpm.entity.BpmOperation;
import com.love.common.bpm.dao.BpmOperationDao;
import com.love.common.bpm.service.BpmOperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程动作表(BpmOperation)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmOperationService")
public class BpmOperationServiceImpl implements BpmOperationService {
    @Resource
    private BpmOperationDao bpmOperationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param operationId 主键
     * @return 实例对象
     */
    @Override
    public BpmOperation queryById(String operationId) {
        return this.bpmOperationDao.queryById(operationId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmOperation> queryAllByLimit(int offset, int limit) {
        return this.bpmOperationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmOperation 实例对象
     * @return 实例对象
     */
    @Override
    public BpmOperation insert(BpmOperation bpmOperation) {
        this.bpmOperationDao.insert(bpmOperation);
        return bpmOperation;
    }

    /**
     * 修改数据
     *
     * @param bpmOperation 实例对象
     * @return 实例对象
     */
    @Override
    public BpmOperation update(BpmOperation bpmOperation) {
        this.bpmOperationDao.update(bpmOperation);
        return this.queryById(bpmOperation.getOperationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param operationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String operationId) {
        return this.bpmOperationDao.deleteById(operationId) > 0;
    }
}