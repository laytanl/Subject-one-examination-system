package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.User;

@Mapper
public interface UserMapper {
	@Insert("insert into user(name,password,tel,email,pority) values(#{name},#{password},#{tel},#{email},#{pority})")
	void add(User u);
	@Select("select name from user where name=#{name}")
	String findname(String name);
	@Select("select name,password,pority from user where name=#{name}")
	User findinfo(String name);
	@Update("update user set grade=#{grade} where name=#{name}")
	void updategrade(int grade,String name);
	@Select("select name,grade from user where name=#{name}")
	User findgrade(String name);	
}
