package com.hxq.demo.service.context;

import com.hxq.demo.dao.LogRecordDao;
import com.hxq.demo.dao.UserDao;
import com.hxq.demo.entity.LogRecord;
import com.hxq.demo.entity.dto.UserDto;
import com.hxq.demo.service.LogRecordService;
import com.hxq.demo.util.RecordLogFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName RecordLoginSite
 * @Description 记录登陆地点实现类
 * @Author hongxq
 * @Date 2019/10/31 10:47
 * @Version 1.0
 **/
@Service
@Slf4j
public class RecordActiveLoginAccount implements LogRecordService, InitializingBean {

    @Autowired
    private LogRecordDao logRecordDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void logRecord(int userId) {
        LogRecord logRecord = new LogRecord();
        UserDto user = userDao.getUserInfo(userId);
        logRecord.setTitle("激活账号");
        logRecord.setCreateTime(new Date());
        logRecord.setContent(user.getUserName()+"("+user.getRoleName()+")激活账号");
        logRecordDao.save(logRecord);
        log.info(logRecord.getContent());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        RecordLogFactory.register("recordActiveLogin",this);
    }


}
