package com.grayson.util.redis;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.grayson.vo.User;
@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	private RedisTemplate<Serializable, Serializable> redisTemplate;
	
	@Override
	public void save(final User user) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(
						redisTemplate.getStringSerializer().serialize(
								"user.userName." + user.getUserName()),
						redisTemplate.getStringSerializer().serialize(
								user.getPassWd()));
				return null;
			}
		});
	}
	@Override
	public User read(final String userName) {
		return redisTemplate.execute(new RedisCallback<User>() {
			@Override
			public User doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key = redisTemplate.getStringSerializer().serialize(
						"user.userName." + userName);
				if (connection.exists(key)) {
					byte[] value = connection.get(key);
					String passWd = redisTemplate.getStringSerializer()
							.deserialize(value);
					User user = new User();
					user.setPassWd(passWd);
					user.setUserName(userName);
					return user;
				}
				return null;
			}
		});
	}
	@Override
	public void delete(final String userName) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) {
				connection.del(redisTemplate.getStringSerializer().serialize(
						"user.userName." + userName));
				return null;
			}
		});
	}
}

