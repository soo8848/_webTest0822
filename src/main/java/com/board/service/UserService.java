package com.board.service;

import com.board.db.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserService {
    
    @Select("SELECT COUNT(*) FROM USERS WHERE ID = #{id} AND PASSWORD = #{password}")
    int isMember(UserDto userDto);

    @Select("SELECT * FROM USERS WHERE ID = #{id} AND PASSWORD = #{password}")
    UserDto findMember(UserDto userDto);
}
