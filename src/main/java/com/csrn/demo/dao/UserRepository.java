package com.csrn.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csrn.demo.modal.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
	
	public void deleteByUserId(int userId);

}
