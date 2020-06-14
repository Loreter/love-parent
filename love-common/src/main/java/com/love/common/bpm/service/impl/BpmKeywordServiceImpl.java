package com.love.common.bpm.service.impl;

import com.love.common.bpm.entity.BpmKeyword;
import com.love.common.bpm.dao.BpmKeywordDao;
import com.love.common.bpm.service.BpmKeywordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作流关键词(BpmKeyword)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 22:44:45
 */
@Service("bpmKeywordService")
public class BpmKeywordServiceImpl implements BpmKeywordService {
    @Resource
    private BpmKeywordDao bpmKeywordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param kid 主键
     * @return 实例对象
     */
    @Override
    public BpmKeyword queryById(String kid) {
        return this.bpmKeywordDao.queryById(kid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BpmKeyword> queryAllByLimit(int offset, int limit) {
        return this.bpmKeywordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bpmKeyword 实例对象
     * @return 实例对象
     */
    @Override
    public BpmKeyword insert(BpmKeyword bpmKeyword) {
        this.bpmKeywordDao.insert(bpmKeyword);
        return bpmKeyword;
    }

    /**
     * 修改数据
     *
     * @param bpmKeyword 实例对象
     * @return 实例对象
     */
    @Override
    public BpmKeyword update(BpmKeyword bpmKeyword) {
        this.bpmKeywordDao.update(bpmKeyword);
        return this.queryById(bpmKeyword.getKid());
    }

    /**
     * 通过主键删除数据
     *
     * @param kid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String kid) {
        return this.bpmKeywordDao.deleteById(kid) > 0;
    }
}