package com.trav.b2c.dao;

import com.trav.b2c.po.User;

public interface UserMapper {
	public User findUserById(long objectUid);
	public void addUser(User user);
}
