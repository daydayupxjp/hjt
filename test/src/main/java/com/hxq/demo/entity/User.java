package com.hxq.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description
 * @Author hongxq
 * @Date 2019/10/31 11:58
 * @Version 1.0
 **/
@Table(name = "user")
@Entity
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4019786220570996660L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="user_name")
    private String userName;

    @Column(name="role_id")
    private int roleId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;


}
