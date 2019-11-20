package com.hxq.demo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName UserDto
 * @Description
 * @Author hongxq
 * @Date 2019/10/31 14:42
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class UserDto {

    private String userName;
    private String roleName;
}
