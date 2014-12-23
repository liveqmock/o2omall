package com.awe.pay.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pay.domain.Channel;
import com.awe.pay.domain.query.ChannelQuery;
import com.awe.pay.manager.ChannelManager;
import com.awe.pay.service.ChannelService;
import com.awe.pay.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ChannelService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ChannelServiceImpl.class);

    @Autowired
    private ChannelManager channelManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ChannelService.batchInsert")
    public boolean insert(List<Channel> channelList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(channelList)) {
                resultFlag = channelManager.insert(channelList);
            } else {
                LOG.warn("ChannelServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ChannelServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ChannelService.insert")
    public boolean insert(Channel channel) {
        boolean resultFlag = false;
        try {
            if (null != channel) {
                if (channelManager.exist(channel)) {
                    throw new ExistedException();
                }
                resultFlag = channelManager.insert(channel);
            } else {
                LOG.warn("ChannelServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ChannelServiceImpl#insert failed, channel has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ChannelServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ChannelService.update")
    public boolean update(Channel channel) {
        boolean resultFlag = false;
        try {
            if (null != channel && null != channel.getId()) {
                resultFlag = channelManager.update(channel);
            } else {
                LOG.warn("ChannelServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ChannelServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ChannelService.queryChannelList")
    public List<Channel> queryChannelList(ChannelQuery queryBean) {
        List<Channel> channelList = null;
        try {
            channelList = channelManager.queryChannelList(queryBean);
        } catch (Exception e) {
            LOG.error("ChannelServiceImpl#queryChannelList has error.", e);
        }
        return channelList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ChannelService.queryChannelListWithPage")
    public List<Channel> queryChannelListWithPage(ChannelQuery queryBean, PageUtil pageUtil) {
        List<Channel> channelList = null;
        try {
            channelList = channelManager.queryChannelListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ChannelServiceImpl#queryChannelListWithPage has error.", e);
        }
        return channelList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ChannelService.delete")
    public boolean delete(Channel channel) {
        boolean resultFlag = false;
        try {
            if (null != channel && null != channel.getId()) {
                resultFlag = channelManager.delete(channel);
            } else {
                LOG.warn("ChannelServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ChannelServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ChannelService.batchDelete")
    public boolean delete(Channel[] channels) {
        boolean resultFlag = false;
        try {
            if (null != channels && channels.length > 0) {
                resultFlag = channelManager.delete(channels);
            } else {
                LOG.warn("ChannelServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ChannelServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ChannelService.getChannelById")
    public Channel getChannelById(Long id) {
        Channel channel = null;
        try {
            if (null != id) {
                channel = channelManager.getChannelById(id);
            } else {
                LOG.warn("ChannelServiceImpl#getChannelById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ChannelServiceImpl#getChannelById has error.", e);
        }
        return channel;
    }
}

