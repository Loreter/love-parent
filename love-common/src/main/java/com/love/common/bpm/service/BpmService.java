package com.love.common.bpm.service;

import com.love.common.bpm.bo.RequestObject;
import com.love.common.bpm.bo.WorkFlowBo;

import java.util.List;
import java.util.Map;

/**
 * 工作流服务，提供流程实例
 *
 * @author 孙振岳
 */

public interface BpmService {

    /**
     * 申请者启动实例; 启动某个流程的流程实例
     *
     * @param bo
     *          工作流数据对象
     * @param varMap
     *           业务参数集合
     * @param entIds
     *           操作人权限集合
     * @return json格式的字符串
     * @throws Exception
     */
    String start(WorkFlowBo bo, Map<String, Object> varMap) throws Exception;

    /**
     * 流程实例的跳转
     *
     * @param userId 操作人Id
     * @param operationId 操作编号
     * @param instanceId 流程实例Id
     * @param varMap 业务参数集合
     * @param rejectReason 备注/拒绝原因
     * @param vendorId 商户编号
     * @param endIds 权限集合
     * @return json 格式的字符串
     * @throws Exception
     */
    String next( String userId, String operationId, String instanceId, Map<Object, Object> varMap,String rejectReason, String vendorId, List<String> endIds) throws Exception;


    /**
     * 根据传入的 instanceId，查询拒绝原因
     * @param
     * @return
     */
    Map<String,Object> getRejectReason(String instanceId);

    /**
     * 内部接口：子商户待审核详情查询接口
     * @param
     */
    Map<String,Object> preHandleInfoQuery(String appId,String outVendorId);

    /**
     * 子商户已处理事务列表查询接口
     *
     * @param appId 品台外部商户编号
     * @param outVendorId 子商户外部编号
     * @param pageNo 分页
     * @param status 状态
     * @return
     */
    Map<String,Object> auditListQuery(String appId, String outVendorId,String pageNo,String status);


    /**
     * 子商户已处理事务详情查询接口
     * @param
     * @return
     */
    Map<String,Object> handleInfoQuery(String appId,String outVendorId,String instanceId);


    /**
     * 根据传入的instanceId判断当前数据是已办还是代办
     * 此方法提供袁庆涛使用，返回1为待办，2为已办
     * @param instanceId
     * @return
     */
    Map<String,Object> isPrehandleOrAudit(String instanceId);



    /**
     * 根据instanceId查询已办表中的节点名称
     * @param instanceId
     * @return
     */
    Map<String,Object> selectNodeNameByInstanceId(String instanceId);

    Map<String,Object> updateJftVarMapByCondition(Map<String,Object> varMap ,String instanceId);




}

