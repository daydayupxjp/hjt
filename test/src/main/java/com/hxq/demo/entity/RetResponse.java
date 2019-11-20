package com.hxq.demo.entity;

import com.hxq.demo.entity.emum.RetCode;

/**
 * @ClassName RetResponse
 * @Description 返回实体封装类
 * @Author hongxq
 * @Date 2019/11/1 16:50
 * @Version 1.0
 **/
public class RetResponse {

    public static <T> RetResult<T> success(){
        return new RetResult<T>().setCode(RetCode.SUCCESS.getCode()).setMsg(RetCode.SUCCESS.getMsg());
    }

    public static <T> RetResult<T> success(T data){
        return new RetResult<T>().setCode(RetCode.SUCCESS.getCode()).setMsg(RetCode.SUCCESS.getMsg()).setData(data);
    }

    public static <T> RetResult fail(){
        return new RetResult<T>().setCode(RetCode.FAIL.getCode()).setMsg(RetCode.FAIL.getMsg());
    }

    public static <T> RetResult fail(T data){
        return new RetResult<T>().setCode(RetCode.FAIL.getCode()).setMsg(RetCode.FAIL.getMsg()).setData(data);
    }

    public static <T> RetResult fail(String msg){
        return new RetResult<T>().setCode(RetCode.FAIL.getCode()).setMsg(msg);
    }

}
