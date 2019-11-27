package com.hxq.demo.service;

import com.hxq.demo.entity.User;

/**
 * @ClassName CacheUserTest
 * @Description
 * @Author hongxq
 * @Date 2019/11/25  10:40
 * @Version 1.0
 **/
public interface CacheUserTest {

    User getUserInfo(int id);

    int updateUserInfo(User user);

    int updateUserInfos(User user);

    public User getUserInfoV2(int id);
    public void updateUserInfosV2(User user);
}
