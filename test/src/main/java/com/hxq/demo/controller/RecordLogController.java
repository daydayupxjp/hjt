package com.hxq.demo.controller;

import com.github.pagehelper.PageInfo;
import com.hxq.demo.dao.UserDao;
import com.hxq.demo.dao.UserInfoMapper;
import com.hxq.demo.entity.*;
import com.hxq.demo.service.LogRecordService;
import com.hxq.demo.service.UserService;
import com.hxq.demo.util.RecordLogFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName RecordLogController
 * @Description
 * @Author hongxq
 * @Date 2019/10/31 15:11
 * @Version 1.0
 **/
@Controller
@Slf4j
public class RecordLogController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserService userService;

    @PostMapping("/addLoginAccount")
    public void addLoginAccount(int userID,String type){
        LogRecordService byUserType = RecordLogFactory.getByUserType(type);
        byUserType.logRecord(userID);
    }

    @PostMapping("/getUserInfo")
    @ResponseBody
    public RetResult<User> getUserInfo(int userId){
        Optional<User> optional = userDao.getUserById(userId);
        if(optional.isPresent()){
            User user = optional.get();
            log.info("user info:::{}",user);

            return RetResponse.success(user);
        }
        return RetResponse.fail("获取user信息失败");

    }

    @PostMapping("/getUserInfo/V2")
    @ResponseBody
    public RetResult<User> getUserInfoV2(int userId){
        User user = userInfoMapper.selectById(userId);
        log.info("user info:::{}",user);
        return RetResponse.success(user);
    }

    @PostMapping("/getUserInfo/list")
    @ResponseBody
    public RetResult<PageInfo<User>> getUserInfoList(int page,int size){
        PageInfo<User> pageInfo = userService.selectall(page,size);
        log.info("user info:::{}",pageInfo);
        return RetResponse.success(pageInfo);
    }

    @PostMapping("/getUserInfoList")
    @ResponseBody
    public RoleV2 getUserInfoList(int id){
        return userInfoMapper.selectRoleInfo(id);
    }

    @PostMapping("/getUserInfoListV2")
    @ResponseBody
    public List<RoleV2> getUserInfoListV2(int id){
        return userInfoMapper.selectRoleInfoAll(id);
    }

    @PostConstruct
    public void init(){
        log.info("测试postConstruct注解");
    }

    @GetMapping("/testTransaction")
    @ResponseBody
    public String testTransaction(){
        //userService.initUserInfo();
        return "Hello Jenkins";
    }

}
