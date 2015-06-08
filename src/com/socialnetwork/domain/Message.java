package com.socialnetwork.domain;

import java.util.Date;

public class Message {
	private String postedBy;
	private String message;
	private Date date;
	
	public Message(String postedBy,String message, Date date) 
	{
		this.postedBy=postedBy;
		this.message = message;
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public Date getDate() {
		return date;
	}


}
