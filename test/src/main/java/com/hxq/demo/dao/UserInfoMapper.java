package com.hxq.demo.dao;

import com.hxq.demo.entity.Role;
import com.hxq.demo.entity.RoleV2;
import com.hxq.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author hongxq
 */
@Repository
public interface UserInfoMapper {

     User selectById(@Param("id") int id);

     List<User> selectAll();

     RoleV2 selectRoleInfo(int id);

     List<RoleV2> selectRoleInfoAll(int id);

     void save(User user);

     void saveRole(Role role);

     int updateUserInfo(User user);


}
