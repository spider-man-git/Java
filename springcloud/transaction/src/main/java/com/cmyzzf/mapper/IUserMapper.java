package com.cmyzzf.mapper;

import com.cmyzzf.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IUserMapper {

    @Insert("INSERT INTO USER(name,age) VALUES(#{user.name},#{user.age})")
    int insert(@Param("user")User user);


    @Select("select * from user where name=#{name}")
    User selectUser(@Param("name") String name);

    @Update("update user set age=18 where name=#{name}")
    int updateByName(@Param("name") String name);
}
