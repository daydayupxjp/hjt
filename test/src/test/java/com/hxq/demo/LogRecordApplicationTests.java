package com.hxq.demo;
import com.hxq.demo.dao.UserInfoMapper;
import com.hxq.demo.entity.Role;
import com.hxq.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = { "classpath:application.yml" }) // 加载spring配置文件
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@WebAppConfiguration
public class LogRecordApplicationTests {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void contextLoads() {
        System.out.println("11");
    }

    /**
     * 同类中
     * 1.A为事务方法，B为普通方法 A->B 事务传播是否生效
     * 2.A为事务方法，B为事务方法 A->B 事务传播是否生效
     * 不同类中
     * 1.A为事务方法，B为普通方法 A->B 事务传播是否生效
     * 2.A为事务方法，B为事务方法 A->B 事务传播是否生效
     */
    //A
    @Test
    @Transactional(rollbackOn = Exception.class)
  //  @Rollback(false)
    public void initUserInfo(){
        User user = new User();
        user.setRoleId(2);
        user.setUserName("test");
        user.setCreateTime(new Date());
        userInfoMapper.save(user);
        //initRoleInfo();
       // initRoleInfos();
    }

    //B
    @Test
    public void initRoleInfo(){
        Role role = new Role();
        role.setRoleName("test");
        userInfoMapper.saveRole(role);
      //  int i = 1/0;

    }

    //C
    public void initRoleInfos(){
        Role role = new Role();
        role.setRoleName("test2");
        userInfoMapper.saveRole(role);
      //  int o = 1/0;
    }


}
