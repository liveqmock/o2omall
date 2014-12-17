package com.letv.cache.demo.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义的缓存管理
 * 
 * @author lijianzhong
 * 
 * @param <T>
 */
public class MyCacheManager<T> {
    private Map<String, T> cache = new ConcurrentHashMap<String, T>();

    /**
     * 依据key获取cache value
     * 
     * @param key
     * @return
     */
    public T getValue(Object key) {
        return cache.get(key);
    }

    /**
     * 添加或修改缓存
     * 
     * @param key
     * @param value
     */
    public void addOrUpdateCache(String key, T value) {
        cache.put(key, value);
    }

    /**
     * 根据 key 来删除缓存中的一条记录
     * 
     * @param key
     */
    public void evictCache(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    /**
     * 清空缓存中的所有记录
     */
    public void evictCache() {
        cache.clear();
    }
}
