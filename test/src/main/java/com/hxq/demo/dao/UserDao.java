package com.hxq.demo.dao;

import com.hxq.demo.entity.User;
import com.hxq.demo.entity.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * LogRecord数据库操作类
 * @author CodeGenTool Generate
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    @Query("SELECT NEW com.hxq.demo.entity.dto.UserDto(A.userName,B.roleName) FROM User A,Role B WHERE A.roleId=B.id AND A.id=?1")
    public UserDto getUserInfo(int userId);

    public Optional<User> getUserById(int id);


}