package com.love.common.bpm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.love.common.bpm.bo.RequestObject;
import com.love.common.bpm.bo.WorkFlowBo;
import com.love.common.bpm.entity.BpmAction;
import com.love.common.bpm.service.BpmService;
import com.love.common.constant.CommonConstant;
import com.love.common.util.CommonUtils;
import com.love.common.util.GeneratorIdUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 工作流实现类
 *
 * @author 孙振岳
 */
@Service
public class BpmServiceImpl implements BpmService, ApplicationContextAware {

    public static final Logger logger = LoggerFactory.getLogger(BpmServiceImpl.class);


    @Autowired
    private ApplicationContext applicationContext;


    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 申请者启动实例; 启动某个流程的流程实例
     *
     * @param bo  工作流数据对象
     * @param varMap   业务参数集合
     * @return String json格式的字符串
     * @throws Exception
     */
    @Transactional
    @Override
    public String start(WorkFlowBo bo, Map<String, Object> varMap) throws JsonProcessingException {
        logger.error("开启工作流方法======>start开始");
        Map<String, Object> result = new ConcurrentHashMap<>(16);
        if ("".equals(StringUtils.trimToEmpty(bo.getObjId()))) {
            throw new RuntimeException("OBJ_ID不能为空");
        }
        String objId = bo.getObjId();
        varMap.put(CommonConstant.WorkflowVarStatus.OBJ_ID,objId);
        String keyword = "";
        if ("".equals(StringUtils.trimToEmpty(bo.getKeyword()))) {
            // 若未设置关键字，默认使用keyword
            keyword = "KEYWORD";
        }
        varMap.put(CommonConstant.WorkflowVarStatus.KEYWORD,keyword);
        String instanceId = GeneratorIdUtils.nextId();
        result.put(CommonConstant.WorkflowVarStatus.INSTANCE_ID,instanceId);
        return objectMapper.writeValueAsString(CommonUtils.returnResultMap(CommonConstant.Result.RETURN_SUCCESS_CODE,"成功",result));
    }

    /**
     * 流程实例的跳转
     *
     * @param userId       操作人Id
     * @param operationId  操作编号
     * @param instanceId   流程实例Id
     * @param varMap       业务参数集合
     * @param rejectReason 备注/拒绝原因
     * @param vendorId     商户编号
     * @param endIds       权限集合
     * @return json 格式的字符串
     * @throws Exception
     */
    @Override
    public String next(String userId, String operationId, String instanceId, Map<Object, Object> varMap, String rejectReason, String vendorId, List<String> endIds) throws Exception {
        return null;
    }

    /**
     * 根据传入的 instanceId，查询拒绝原因
     *
     * @param instanceId 流程编号
     * @return
     */
    @Override
    public Map<String, Object> getRejectReason(String instanceId) {
        return null;
    }

    /**
     * 内部接口：子商户待审核详情查询接口
     *
     * @param appId
     * @param outVendorId
     */
    @Override
    public Map<String, Object> preHandleInfoQuery(String appId, String outVendorId) {
        return null;
    }

    /**
     * 子商户已处理事务列表查询接口
     *
     * @param appId       品台外部商户编号
     * @param outVendorId 子商户外部编号
     * @param pageNo      分页
     * @param status      状态
     * @return
     */
    @Override
    public Map<String, Object> auditListQuery(String appId, String outVendorId, String pageNo, String status) {
        return null;
    }

    /**
     * 子商户已处理事务详情查询接口
     *
     * @param appId
     * @param outVendorId
     * @param instanceId
     * @return
     */
    @Override
    public Map<String, Object> handleInfoQuery(String appId, String outVendorId, String instanceId) {
        return null;
    }

    /**
     * 根据传入的instanceId判断当前数据是已办还是代办
     * 返回1为待办，2为已办
     *
     * @param instanceId 流程编号
     * @return
     */
    @Override
    public Map<String, Object> isPrehandleOrAudit(String instanceId) {
        return null;
    }

    /**
     * 根据instanceId查询已办表中的节点名称
     *
     * @param instanceId 流程编号
     * @return
     */
    @Override
    public Map<String, Object> selectNodeNameByInstanceId(String instanceId) {
        return null;
    }

    @Override
    public Map<String, Object> updateJftVarMapByCondition(Map<String,Object> varMap, String instanceId) {
        return null;
    }


    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("0001", "2008");
        map.put("0002", new Date());
        map.put("0003", Collections.singletonList("998"));
        map.put("0004", Arrays.asList(new String[] {"1","2","3","4","5"}));
        map.put("0005", Collections.singletonMap("985",Collections.singletonMap("999",Collections.singletonList("1998"))));
        System.out.println(map);
        String value = objectMapper.writeValueAsString(map);
        System.out.println(value);
        Map<String, Object> objectMap = (Map<String, Object>)objectMapper.readValue(value, Map.class);
        System.out.println(objectMap);
        List<String> list = (List<String>)objectMap.get("0003");
        System.out.println(list);
        Map maps = (Map)objectMap.get("0005");
        System.out.println(maps.get("985"));
        Object date = objectMap.get("0002");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
        List<String> arrays = (List<String>)objectMap.get("0004");
        System.out.println(arrays);
    }
}
