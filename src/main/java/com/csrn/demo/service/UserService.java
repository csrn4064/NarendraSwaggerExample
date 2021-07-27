package com.csrn.demo.service;

import java.util.List;


import com.csrn.demo.modal.User;

public interface UserService {

	User userCreate(User user);

	List<User> getAll();

	User getUserById(int id);

	void deleteUserById(int id);


	String checking(int id, String userName);


}
