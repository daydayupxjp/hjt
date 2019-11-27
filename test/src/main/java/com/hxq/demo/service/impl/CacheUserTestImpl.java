package com.hxq.demo.service.impl;

import com.hxq.demo.dao.UserDao;
import com.hxq.demo.dao.UserInfoMapper;
import com.hxq.demo.entity.User;
import com.hxq.demo.service.CacheUserTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName CacheUserTestImpl
 * @Description redis测试类
 * @Author hongxq
 * @Date 2019/11/25 10:42
 * @Version 1.0
 **/
@Service
@Slf4j
public class CacheUserTestImpl implements CacheUserTest {

    @Autowired
    UserDao userDao;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Cacheable(value = "users",key = "'userInfo::'+#id",unless = "#result == null ")
    @Override
    public User getUserInfo(int id) {
        Optional<User> user = userDao.getUserById(id);
        if(user.isPresent()){
            return userDao.getUserById(id).get();
        }
        return null;
    }

    /**
     * 清除缓存
     * @param user
     * @return
     */
    @CacheEvict(value = "users",key = "'userInfo::'+#id")
    @Override
    public int updateUserInfo(User user) {
        return userInfoMapper.updateUserInfo(user);
    }

    /**
     * 每次都会刷新缓存
     * @param user
     * @return
     */
    @CachePut(value = "users",key = "'userInfo::'+#user.id")
    @Override
    public int updateUserInfos(User user) {
        return userInfoMapper.updateUserInfo(user);
    }

    /**
     * 1.缓存存在，从缓存中读取；若不存在，从数据库中读取
     * 2.更新缓存
     * @param id
     * @return
     */
    @Override
    public User getUserInfoV2(int id) {
        User user = (User)redisTemplate.opsForValue().get("userInfo::" + id);
        log.info("user::{}",user);
        if(user == null){
            user = userDao.getUserById(id).get();
            redisTemplate.opsForValue().set("userInfo::" + id,user);
        }
        return user;
    }

    /**
     * 1.更新数据库
     * 2.缓存失效
     * @param user
     * @return
     */
    @Override
    public void updateUserInfosV2(User user) {
        testRedisList();
        /*userInfoMapper.updateUserInfo(user);
        redisTemplate.delete("userInfo::"+user.getId());*/
    }

    public void testRedisList(){
        List list = Arrays.asList("1","2","3");
        for (int i =0;i<5;i++){
            long l =redisTemplate.opsForList().rightPush("test"+i,list);
            System.out.println("l"+i+": "+l);
            redisTemplate.opsForSet().add("","");
            redisTemplate.opsForZSet().add("",new HashSet());
        }
        for (int i=0;i<5;i++){
            List list2 = redisTemplate.opsForList().range("test"+i,0,2);
            System.out.println("list2"+i+": "+list2);
        }
    }

}
