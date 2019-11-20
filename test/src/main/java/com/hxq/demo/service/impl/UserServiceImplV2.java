package com.hxq.demo.service.impl;

import com.hxq.demo.dao.UserInfoMapper;
import com.hxq.demo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName UserServiceImplV2
 * @Description TODO
 * @Author hongxq
 * @Date 2019/11/14 0014 10:14
 * @Version 1.0
 **/
@Service
public class UserServiceImplV2  {

    @Autowired
    UserInfoMapper userInfoMapper;

    //B
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void initRoleInfo(){
        Role role = new Role();
        role.setRoleName("test");
        userInfoMapper.saveRole(role);
        int i = 1/0;
    }
}
