package com.hxq.demo.entity;

import com.hxq.demo.entity.emum.RetCode;

/**
 * @ClassName RetResult
 * @Description 返回实体类
 * @Author hongxq
 * @Date 2019/11/1 16:43
 * @Version 1.0
 **/
public class RetResult<T> {

    private int code;
    private String msg;
    private T data;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}
