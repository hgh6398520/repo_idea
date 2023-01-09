package com.hgy.utils;

import com.hgy.gobal.ResponseResult;

/**
 * 封装响应结果
 * @author hgy
 */
public class SetResponseResult {
    /**响应成功结果封装*/
    public static ResponseResult successResponse(Object content){
        ResponseResult result = new ResponseResult();
        result.setSuccess(true);
        result.setMessage("响应成功");
        result.setState(200);
        result.setContent(content);
        return result;
    }

    public static ResponseResult failResponse(Integer state,Object content){
        ResponseResult result = new ResponseResult();
        result.setSuccess(false);
        result.setMessage("响应失败");
        result.setState(state);
        result.setContent(content);
        return result;
    }



}
