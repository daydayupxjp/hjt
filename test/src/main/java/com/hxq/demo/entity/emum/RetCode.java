package com.hxq.demo.entity.emum;

/**
 * @ClassName RetCode
 * @Description 返回消息枚举类
 * @Author hongxq
 * @Date 2019/11/1 16:39
 * @Version 1.0
 **/
public enum RetCode {

    // 成功
    SUCCESS(200,"SUCCESS"),

    // 失败
    FAIL(400,"FAIL"),

    // 未认证（签名错误）
    UNAUTHORIZED(401,"UNAUTHORIZED"),

    // 接口不存在
    NOT_FOUND(404,"NOT_FOUND"),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500,"INTERNAL_SERVER_ERROR");

    public int code;
    public String msg;

    RetCode(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }


}
