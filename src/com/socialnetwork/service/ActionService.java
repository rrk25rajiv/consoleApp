package com.socialnetwork.service;

import java.util.List;

import com.socialnetwork.domain.Message;
import com.socialnetwork.domain.User;

public interface ActionService {
	
	public void post(String sourceUserName,String targetUserName, String message);
	
	public List<Message> getUserWall(String userName);
	
	public List<Message> getUserPersonalWall(String userName);
	
	public void setFollow(String userName1,String userName2);

	public User getUser(String userName);
	
	public void logUser(String userName);

	public void registerUser(String name);
}
