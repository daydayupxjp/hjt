package com.hxq.demo.util;

import com.hxq.demo.service.LogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName RecordLogFactory
 * @Description 日志记录工厂类
 * @Author hongxq
 * @Date 2019/10/31 11:45
 * @Version 1.0
 **/
public class RecordLogFactory {

    private static ConcurrentHashMap<String,LogRecordService> map = new ConcurrentHashMap();

    public static void register(String key, LogRecordService logRecordService){
        map.put(key,logRecordService);
    }

    public static LogRecordService getByUserType(String type){
        return map.get(type);
    }


}
