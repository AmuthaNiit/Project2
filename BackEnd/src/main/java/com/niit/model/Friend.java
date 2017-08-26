package com.niit.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Friend")

public class Friend extends BaseDomain {
	
	@Id
	private String id;
@Column 
	private String userid;
@Column
	private String friendid;
@Column
	private String status;
@Column
	private char is_online;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getFriendid() {
	return friendid;
}
public void setFriendid(String friendid) {
	this.friendid = friendid;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public char getIs_online() {
	return is_online;
}
public void setIs_online(char is_online) {
	this.is_online = is_online;
}
public Friend() {
	this.id="FRIEND" + UUID.randomUUID().toString().substring(24).toUpperCase();
}



}
