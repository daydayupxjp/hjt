package com.hxq.demo.entity.dto;

import java.util.Date;
import lombok.Data;

/**
 * LogRecord数据传输对象
 * @author CodeGenTool Generate
 */
@Data
public class LogRecordDto {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

}
