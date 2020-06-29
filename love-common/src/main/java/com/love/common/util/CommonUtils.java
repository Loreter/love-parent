package com.love.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.love.common.constant.CommonConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * common  工具类
 * @author 孙振岳
 */
public class CommonUtils {

private final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> returnResultMap(String returnCode, String returnValue, Map<String, Object> returnMap) {
        returnMap.put(CommonConstant.Result.RETURN_CODE,returnCode);
        returnMap.put(CommonConstant.Result.RETURN_MSG,returnValue);
        return returnMap;
    }

    public static Map<String, Object> returnResultMap(String returnCode, String returnValue) {
        HashMap<String, Object> returnMap = Maps.newHashMap();
        returnMap.put(CommonConstant.Result.RETURN_CODE,returnCode);
        returnMap.put(CommonConstant.Result.RETURN_MSG,returnValue);
        return returnMap;
    }
}
