package com.hxq.demo.dao;

import com.hxq.demo.entity.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * LogRecord数据库操作类
 * @author CodeGenTool Generate
 */
@Repository
public interface LogRecordDao extends JpaRepository<LogRecord,Integer>, JpaSpecificationExecutor<LogRecord> {

}