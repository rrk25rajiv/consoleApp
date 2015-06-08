package com.socialnetwork.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rrk
 */
public class User {
	private String name;
	private List<Message> wall = new ArrayList<Message>();
	
	public List<Message> getWall() {
		return wall;
	}
	public void setWall(List<Message> wall) {
		this.wall = wall;
	}
	private List<String> following = new ArrayList<String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFollowing() {
		return following;
	}
	public void setFollowing(List<String> following) {
		this.following = following;
	}
}
