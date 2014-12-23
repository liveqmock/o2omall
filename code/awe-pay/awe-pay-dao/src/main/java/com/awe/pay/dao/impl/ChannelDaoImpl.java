package com.awe.pay.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pay.dao.ChannelDao;
import com.awe.pay.domain.Channel;
import com.awe.pay.domain.query.ChannelQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ChannelDAO实现类<br/>
 * 对'支付通道'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Repository
public class ChannelDaoImpl extends BaseDao implements ChannelDao {
    /** namespace */
    private final String namespace = ChannelDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<Channel> queryChannelList(ChannelQuery queryBean) {
        return (List<Channel>) queryForList(namespace +".queryChannelList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(Channel channel) {
        return insert(namespace +".insert", channel);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(Channel channel) {
        return update(namespace +".update", channel);
    }

    /**
     * {@inheritDoc}
     */
    public int queryChannelCount(ChannelQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryChannelCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Channel> queryChannelListWithPage(ChannelQuery queryBean) {
        return (List<Channel>) queryForList(namespace +".queryChannelListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Channel configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public Channel getChannelById(Long id) {
        return (Channel) queryForObject(namespace +".getChannelById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(Channel channel) {
        int count = (Integer) queryForObject(namespace +".exist", channel);
        return count > 0;
    }
}
