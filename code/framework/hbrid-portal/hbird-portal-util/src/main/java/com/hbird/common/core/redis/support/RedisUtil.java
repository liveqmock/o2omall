package com.hbird.common.core.redis.support;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis工具类
 * <p/>
 * 
 * User: ljz DateTime: 2012-6-26 下午04:24:10 Version: 1.0
 */
@Component
public class RedisUtil {

    private final static Logger log = LogManager.getLogger(RedisUtil.class);

    /**
     * Jedis线程池
     */
    @Autowired
    private JedisPool jedisPool;

    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    public void returnBrokenResource(Jedis jedis) {
        try {
            if (jedis != null) {
                jedisPool.returnBrokenResource(jedis);
            }
        } catch (Exception e) {
            log.error("RedisManage -> returnBrokenResource(Jedis jedis) error...", e);
        }
    }

    public void returnResource(Jedis jedis) {
        try {
            if (jedis != null) {
                jedisPool.returnResource(jedis);
            }
        } catch (Exception e) {
            log.error("RedisManage -> returnResource(Jedis jedis) error...", e);
        }
    }

    /**
     * 将value插入hashtable
     * 
     * @param key
     * @param hash
     * @param seconds
     * @return
     * @throws Exception
     */
    public String hMSet(String key, Map<String, String> hash, int seconds) throws Exception {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hmset(key, hash);
            jedis.expire(key, seconds);
        } catch (Exception e) {
            log.error("RedisManage -> hMSet(String key, Map<String, String> hash, int seconds) error...", e);
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 根据key,fields从hashtable获取value
     * 
     * @param key
     * @param fields
     * @return
     * @throws Exception
     */
    public List<String> hMGet(String key, String... fields) throws Exception {
        List<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hmget(key, fields);
        } catch (Exception e) {
            log.error("RedisManage -> hMGet(String key, String... fields) error...", e);
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 将value插入hashtable
     * 
     * @param key
     * @param field
     * @param value
     * @return
     * @throws Exception
     */
    public boolean hSetNX(String key, String field, String value, int seconds) throws Exception {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hsetnx(key, field, value) == 1;
            if (seconds != 0) {
                jedis.expire(key, seconds);
            }
        } catch (Exception e) {
            log.error("RedisManage -> hSetNX(String key, String field, String value, int seconds) error...", e);
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 将value插入hashtable
     * 
     * @param key
     * @param field
     * @param value
     * @return
     * @throws Exception
     */
    public boolean hSetNX(String key, String field, String value) throws Exception {
        return hSetNX(key, field, value, 0);
    }

    /**
     * 根据key,field从hashtable获取value
     * 
     * @param key
     * @param field
     * @return
     * @throws Exception
     */
    public String hGet(String key, String field) throws Exception {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hget(key, field);
        } catch (Exception e) {
            log.error("RedisManage -> hGet(String key, String field) error...", e);
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    public Long hDel(String key, String field) throws Exception {
        Long result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hdel(key, field);
        } catch (Exception e) {
            log.error("RedisManage -> hDel(String key, String field) error...", e);
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 从hashtable获取所有value
     * 
     * @param key
     * @return
     * @throws Exception
     */
    public Map<String, String> hGetAll(String key) throws Exception {
        Map<String, String> result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hgetAll(key);
        } catch (Exception e) {
            log.error("RedisManage -> hGetAll(String key) error...", e);
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    public Long del(String key) throws Exception {
        Long result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            log.error("redis删除hash key失败!", e);
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }
}
