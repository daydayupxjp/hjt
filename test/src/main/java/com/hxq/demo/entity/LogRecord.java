package com.hxq.demo.entity;

import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import lombok.Data;

/**
 * LogRecord
 * @author CodeGenTool Generate
 */
@Data
@Entity
@Table(name = "log_record")
public class LogRecord {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

}
