package com.hxq.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName User
 * @Description
 * @Author hongxq
 * @Date 2019/10/31 11:58
 * @Version 1.0
 **/
@Data
public class UserV2 {

    private int id;

    private String userName;

    private int roleId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
