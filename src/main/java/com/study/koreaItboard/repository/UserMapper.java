package com.study.koreaItboard.repository;

import com.study.koreaItboard.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User findUserByUsername(String username);
    public int saveUser (User user);
    public int saveRole(@Param("userId") int userId, @Param("roleId") int roleId);
}
