package com.hxq.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxq.demo.dao.UserInfoMapper;
import com.hxq.demo.entity.Role;
import com.hxq.demo.entity.User;
import com.hxq.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description 用户service实现类
 * @Author hongxq
 * @Date 2019/11/2 14:42
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserServiceImplV2 userServiceImplV2;

    @Override
    public PageInfo<User> selectall(int page, int size) {
        PageHelper.startPage(page, size);
        List<User> users = userInfoMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo(users);
        return pageInfo;
    }

    /**
     * 同类中
     * 1.A为事务方法，B为普通方法 A->B 事务传播是否生效 生效 A、B都回滚
     * 2.A为事务方法，B为事务方法 A->B 事务传播是否生效 生效 A、B都回滚
     * 3.A为普通方法，B为普通方法 A->B 事务传播是否生效 不生效 A、B都不回滚
     * 4.A为普通方法，B为事务方法 A->B 事务传播是否生效 不生效 A、B都不回滚
     * 不同类中
     * 1.A为事务方法，B为普通方法 A->B 事务传播是否生效 生效 A、B都回滚
     * 2.A为事务方法，B为事务方法 A->B 事务传播是否生效 生效 A、B都回滚
     * 3.A为普通方法，B为普通方法 A->B 事务传播是否生效 不生效 A、B都不回滚
     * 4.A为普通方法，B为事务方法 A->B 事务传播是否生效 生效 A不回滚 B回滚
     * 总结 若在同类中 父方法必须为事务方法 因为实际事务传播所导致子方法使用事务就是父方法的事务
     * 若在不同类中 父方法是否可为普通方法依据事务传播机制而定 子方法事务是独立生成的 可以使用自身的事务
     */
    //A
    @Override
    @Transactional
    public void initUserInfo(){
        User user = new User();
        user.setRoleId(2);
        user.setUserName("test");
        user.setCreateTime(new Date());
        userInfoMapper.save(user);
        userServiceImplV2.initRoleInfo();
        //int i=1/0;
        // initRoleInfos();
    }

    //B
    @Transactional(rollbackFor = Exception.class)
    public void initRoleInfo(){
        Role role = new Role();
        role.setRoleName("test");
        userInfoMapper.saveRole(role);
        int i = 1/0;

    }

    //C
    public void initRoleInfos(){
        Role role = new Role();
        role.setRoleName("test2");
        userInfoMapper.saveRole(role);
        //  int o = 1/0;
    }


}
