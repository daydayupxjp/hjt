package com.hxq.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName Role
 * @Description TODO
 * @Author hongxq
 * @Date 2019/10/31 0031 14:30
 * @Version 1.0
 **/
@Data
public class RoleV2 {

    private int id;

    private String roleName;

    private User user;

}
