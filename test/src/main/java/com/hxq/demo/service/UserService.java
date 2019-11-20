package com.hxq.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxq.demo.entity.User;

public interface UserService {

    PageInfo<User> selectall(int page,int size);

    public void initUserInfo();

}
