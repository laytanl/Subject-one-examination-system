package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Item;

@Mapper
public interface ItemMapper {
	@Insert( "insert into item(subject,item1,item2,item3,item4,img,answer)values(#{subject},#{item1},#{item2},#{item3},#{item4},#{img},#{answer})")
	void add(Item item);
	@Select("select * from item")
	List<Item>find();
	@Select("select subject,item1,item2,item3,item4,img from item where id=#{id}")
	Item find1(int id);
	@Delete("delete from item where subject=#{subject}")
	void delete(String subject);
	@Select("select answer from item where subject=#{subject}")
	String findanswer(String subject);
}
