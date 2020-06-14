package com.love.common.bpm.service.impl;

import com.love.common.bpm.entity.BpmNode;
import com.love.common.bpm.dao.BpmNodeDao;
import com.love.common.bpm.service.BpmNodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程节点表(BpmNode)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmNodeService")
public class BpmNodeServiceImpl implements BpmNodeService {
    @Resource
    private BpmNodeDao bpmNodeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param nodeId 主键
     * @return 实例对象
     */
    @Override
    public BpmNode queryById(String nodeId) {
        return this.bpmNodeDao.queryById(nodeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmNode> queryAllByLimit(int offset, int limit) {
        return this.bpmNodeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmNode 实例对象
     * @return 实例对象
     */
    @Override
    public BpmNode insert(BpmNode bpmNode) {
        this.bpmNodeDao.insert(bpmNode);
        return bpmNode;
    }

    /**
     * 修改数据
     *
     * @param bpmNode 实例对象
     * @return 实例对象
     */
    @Override
    public BpmNode update(BpmNode bpmNode) {
        this.bpmNodeDao.update(bpmNode);
        return this.queryById(bpmNode.getNodeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param nodeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String nodeId) {
        return this.bpmNodeDao.deleteById(nodeId) > 0;
    }
}