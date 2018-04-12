package com.gbn.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gbn.user.exception.UserNotFoundException;
import com.gbn.user.model.User;

@Component
public class UserServiceImpl {

	@Autowired
	public UserDaoImpl userDaoImpl;

	public ArrayList<User> findAllUsers() {
		return userDaoImpl.findAllUsers();
	}

	public User findUser(int id) {
		User user = userDaoImpl.findUser(id);

		if (user == null) {
			throw new UserNotFoundException("id : " + id);
		}

		return user;
	}

	public void save(User user) {
		userDaoImpl.save(user);
	}
	
	public User deleteUser(int id) {
		return userDaoImpl.deleteUser(id);
	}

}
