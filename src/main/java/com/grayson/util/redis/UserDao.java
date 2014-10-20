package com.grayson.util.redis;
import  com.grayson.vo.User;

public interface UserDao {
	void save(User user);
	User read(String userName);
	void delete(String userName);
}
