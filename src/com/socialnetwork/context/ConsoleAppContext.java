package com.socialnetwork.context;

import java.util.HashMap;
import java.util.Map;

import com.socialnetwork.domain.User;
import com.socialnetwork.factory.UserFactory;

/**
 * context of app
 * 
 * @author rrk
 */
public class ConsoleAppContext {
	
	private User loggedUser=null;
	private static ConsoleAppContext context;
	//all the users are stored here
	private Map<String,User> users;

	private ConsoleAppContext() {
		users = new HashMap<String,User>();
	}
	
	public static ConsoleAppContext getConsoleAppContext() {
		if(context == null){
			context = new ConsoleAppContext();
		}
		return context;
	}

	public Map<String, User> getUsers() {
		return users;
	}
	public User getUser(String name){
		if(users.get(name)==null);
		User u =users.get(name);
		return u;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	public void registerUser(String name) {
		User newUser = UserFactory.getUser();
		newUser.setName(name);
		users.put(name, newUser);
	}

}
