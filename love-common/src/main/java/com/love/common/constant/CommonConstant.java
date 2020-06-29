package com.love.common.constant;

/**
 * 公共常量字段
 *
 * @author 孙振岳
 */
public class CommonConstant {

    public interface FlowNode {

        /**
         * 节点开启
         */
        public static final String FLOW_START = "1->2";
        /**
         * 节点流转至 审核通过
         */
        public static final String FLOW_PASS = "2->3";
        /**
         * 节点流转至 审核拒绝
         */
        public static final String FLOW_REJECT = "2->4";

    }

    /**
     * 工作流全局变量定义
     */
    public interface WorkflowVarStatus{
        /**
         * 对象的唯一标识
         */
        public static final String OBJ_ID = "ObjId";

        /**
         * 相关对象唯一标识
         */
        public static final String RELATED_OBJ_ID = "RelatedObjId";

        /**
         * 节点ID
         */
        public static final String FLOOR_OBJ_ID = "FloorObjId";
        /**
         * 省份标识
         */
        public static final String PROVINCE_ID = "ProvinceId";
        /**
         * 城市标识
         */
        public static final String CITY_ID = "CityId";

        /**
         * 机构号标识
         */
        public static final String ORG_ID = "OrgId";

        /**
         * 关键词
         */
        public static final String KEYWORD = "KeyWord";
        /**
         * 拒绝原因
         */
        public static final String REJECT_REASON = "RejectReason";
        /**
         * 操作
         */
        public static final String ACTION_TYPE = "ActionType";
        /**
         * 动作类型
         */
        public static final String AUDIT_ACTION_TYPE = "AuditActionType";
        /**
         * 处理角色
         */
        public static final String HANDLE_ROLE = "HandleRole";
        /**
         * 处理用户名
         */
        public static final String HANDLE_USERNAME = "HandleUsername";
        /**
         * 处理用户ID
         */
        public static final String HANDLE_USER_ID = "HandleUserId";
        /**
         * 实例ID
         */
        public static final String INSTANCE_ID = "InstanceId";
        /**
         * 商户ID
         */
        public static final String VENDOR_ID="vendorId";
    }
    public interface Result {

        public static final String RETURN_CODE = "return_code";
        public static final String RETURN_SUCCESS_CODE = "success";
        public static final String RETURN_FAIL_CODE = "fail";
        public static final String RETURN_MSG = "return_msg";

    }

}
