package com.grayson.util.memcache;

import com.danga.MemCached.MemCachedClient;

public class MemcacheUtil {
	 public static MemCachedClient getMemCachedClient() {
	        return SpringContextHolder.getBean("memcachedClient");
	}
}
