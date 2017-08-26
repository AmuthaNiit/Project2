package com.niit.dao;

import java.util.List;

import com.niit.model.Friend;

public interface FriendDao {
	public List<Friend> getMyFriends(String userID);
	public Friend get(String userID,String friendID);
	public boolean save(Friend friend);
	public boolean update(Friend friend);
	public void delete(String userID,String friendID);
	public List<Friend> getNewFriendRequests(String userID);
	public void setOnline(String userID);
	public void setOffLine(String userID);
	

}


