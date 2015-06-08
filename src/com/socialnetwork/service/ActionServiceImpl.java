package com.socialnetwork.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.socialnetwork.context.ConsoleAppContext;
import com.socialnetwork.domain.Message;
import com.socialnetwork.domain.User;
import com.socialnetwork.factory.MessageFactory;

public class ActionServiceImpl implements ActionService {
	

	@Override
	public void post(String sourceUserName,String targetUserName, String message)
	{
		User user = ConsoleAppContext.getConsoleAppContext().getUsers().get(targetUserName);
		Date currentDate = new Date();
		
		user.getWall().add(MessageFactory.getMessage(sourceUserName,message, currentDate));
	}

	@Override
	public List<Message> getUserWall(String userName)
	{
		User user = ConsoleAppContext.getConsoleAppContext().getUsers().get(userName);
		return user.getWall();
	}

	@Override
	public void setFollow(String userName1, String userName2)
	{
		ConsoleAppContext.getConsoleAppContext().getUser(userName1).getFollowing().add(userName2);

	}

	@Override
	public User getUser(String userName)
	{
		return ConsoleAppContext.getConsoleAppContext().getUser(userName);
	}

	@Override
	public void logUser(String userName) 
	{
		ConsoleAppContext.getConsoleAppContext().setLoggedUser(getUser(userName));
	}

	@Override
	public void registerUser(String name) {
		ConsoleAppContext.getConsoleAppContext().registerUser(name);
		
	}

	@Override
	public List<Message> getUserPersonalWall(String userName)
	{
		User user =ConsoleAppContext.getConsoleAppContext().getUsers().get(userName);
		List<Message> result = new ArrayList<Message>();
		result.addAll(user.getWall());
		if(user.getFollowing().size()>0)
		{
			for (String userN : user.getFollowing())
			{
				result.addAll(getUserWall(userN));
			}
		}
		return result;
	}
	

}
