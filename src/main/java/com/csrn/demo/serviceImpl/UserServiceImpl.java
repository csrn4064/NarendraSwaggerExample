package com.csrn.demo.serviceImpl;

import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csrn.demo.dao.UserRepository;
import com.csrn.demo.modal.User;
import com.csrn.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	PasswordEncoderService passwordEncoderService;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User userCreate(User user) {
		user.setUserName(passwordEncoderService.passwordEncoder().encode(user.getUserName()));
		return userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteUserById(int id) {

		userRepository.deleteByUserId(id);
	}

	

	@Override
	public String checking(int id, String userName) {
		
		User user=userRepository.findById(id).get();
		System.out.println(userName);
		if(passwordEncoderService.passwordEncoder().matches(userName,user.getUserName() )) {
			
			return "both are matched";
		}else {
			
			return "both are not matched";
		}
		

	}

}
