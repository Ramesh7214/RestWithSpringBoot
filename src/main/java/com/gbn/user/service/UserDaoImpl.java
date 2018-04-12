package com.gbn.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.springframework.stereotype.Component;

import com.gbn.user.model.User;

@Component
public class UserDaoImpl {

	static ArrayList<User> userList = new ArrayList<User>();

	static int count = 2;
	
	String githubpractice = "Hello world";

	static {
		userList.add(new User(0, "Ramesh", new Date()));
		userList.add(new User(1, "Naresh", new Date()));
		userList.add(new User(2, "Raj", new Date()));
	}

	public ArrayList<User> findAllUsers() {
		return userList;
	}

	public User findUser(int id) {
		for(User user : userList) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public void save(User user) {
		user.setId(count++);
		userList.add(user);
	}
	
	public User deleteUser(int id) {
		Iterator itr = userList.iterator();
		
		while(itr.hasNext()) {
			User user = (User) itr.next();
			if(user.getId() == id) {
				userList.remove(id);
				return user;
			}
		}
		return null;
		
	}
	

}
