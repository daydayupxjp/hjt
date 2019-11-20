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
@Table(name = "role")
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role_name")
    private String roleName;


}
