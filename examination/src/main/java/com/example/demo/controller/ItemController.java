package com.example.demo.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Item;
import com.example.demo.mapper.ItemMapper;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemMapper mapper;
	String answer;
	@PostMapping("/add")
	public String add(@RequestBody Item item) {
		mapper.add(item);
		return "ok";
	}
	
	@RequestMapping("/find")
	public List<Item> find() {
		List<Item>items=mapper.find();
		return  items;
	}
	
	@PostMapping("/delete")
	public String delete(@RequestBody Item item){
		mapper.delete(item.getSubject());
		return "ok";
	}
	
	@RequestMapping("/findsubject")
	public HashSet<Item> findsubject(){
		HashSet<Item> items=new HashSet<>();
		HashSet<Integer> itemid=new HashSet<>();
		while(itemid.size()<20) {
			int m=(int) (Math.random()*200);
			Item i=mapper.find1(m);
			if(i!=null) {
			itemid.add(m);
			}
		}
		for (Integer id : itemid) {
			Item i2=mapper.find1(id);
			items.add(i2);
		}
		return items; 
	}
	
	//传一个题目过来寻找答案
	@PostMapping("/selcetanswer")
	public String selectanswer(@RequestBody Item item) {
		String subject=item.getSubject();
		answer=mapper.findanswer(subject);
		return"ok";
	}
	//返回题目对应的答案
	@RequestMapping("/findanswer")
	public String findanswer() {
		return answer;
	}
}
