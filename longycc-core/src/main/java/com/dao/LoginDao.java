package com.dao;

import com.util.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * login Dao层
 */
@Mapper
@Repository
public interface LoginDao {
    /**
     * 新增用户
     * @param user
     */
    @Insert("INSERT INTO user(username,email,password)VALUES(#{user.username},#{user.email},#{user.password})")
    int addUser(@Param("user") User user);

    /**
     * 根据email和password查询用户
     * @param user
     * @return
     */
    @Select("select*from user where email=#{user.email} and password=#{user.password}")
    User selectUser(@Param("user")User user);
}
