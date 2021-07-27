package com.csrn.demo.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csrn.demo.dto.UserDto;
import com.csrn.demo.modal.User;
import com.csrn.demo.serviceImpl.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/c/user")
@Api(value="user",description="user crud operations")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	
	@RequestMapping(value="/creates")
	public List<Object> getmultipleResponses(){
		
		List<Object> list=new ArrayList<Object>();
		
		
		
		return list;
	}
	
	
	@ApiOperation(value="creating of user",response=User.class)
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public User userCreate(@RequestBody UserDto userDto) {
		User user=new User();
		BeanUtils.copyProperties(userDto, user);
		return userServiceImpl.userCreate(user);
		
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	@ResponseBody
	public List<User> getAll(){
		
		return userServiceImpl.getAll();
	}
	
	@RequestMapping(value="/create/{id}",method=RequestMethod.GET)
	public User getUserbyId(@PathVariable("id") int id) {
		
		return userServiceImpl.getUserById(id);
	}

	@RequestMapping(value="/create/{id}")
	public void deleteUserById(@PathVariable("id") int id) {
		
		userServiceImpl.deleteUserById(id);
	}
	
	@RequestMapping(value="/create/check/{id}/{userName}",method=RequestMethod.GET)
	public String checking(@PathVariable("id") int id,@PathVariable("userName") String userName) {
		
		return userServiceImpl.checking(id,userName);
	}
	
}
