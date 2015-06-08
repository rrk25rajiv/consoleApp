package com.socialnetwork.factory;

import java.util.Date;

import com.socialnetwork.domain.Message;

public class MessageFactory 
{
	public static Message getMessage(String postedBy,String message,Date date){
		
		return new Message(postedBy,message, date);
	}
}
