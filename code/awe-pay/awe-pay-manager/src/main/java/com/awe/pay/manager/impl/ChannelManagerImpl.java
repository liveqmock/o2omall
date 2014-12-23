package com.awe.pay.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pay.domain.Channel;
import com.awe.pay.domain.query.ChannelQuery;
import com.awe.pay.dao.ChannelDao;
import com.awe.pay.manager.ChannelManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ChannelManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Component
public class ChannelManagerImpl extends BaseManager implements ChannelManager {
	
    @Autowired
    private ChannelDao channelDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<Channel> channelList) {
        boolean resultFlag = false;
        if (null != channelList && channelList.size() > 0) {
            for (Channel channel : channelList) {
                resultFlag = channelDao.insert(channel);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(Channel channel) {
        return channelDao.insert(channel);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final Channel channel) {
        return channelDao.update(channel);
    }

    /**
     * {@inheritDoc}
     */
    public List<Channel> queryChannelList(ChannelQuery queryBean) {
        return channelDao.queryChannelList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Channel> queryChannelListWithPage(ChannelQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ChannelQuery();
        }

        // 查询总数
        int totalItem = queryChannelCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return channelDao.queryChannelListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryChannelCount(ChannelQuery queryBean) {
        return channelDao.queryChannelCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Channel channel) {
        return channelDao.delete(channel);
    }

    /**
     * {@inheritDoc}
     */
    public Channel getChannelById(Long id) {
        return channelDao.getChannelById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final Channel[] channels) {
        boolean resultFlag = false;
        if (null != channels && channels.length > 0) {
            for (int i = 0; i < channels.length; i++) {
                resultFlag = delete(channels[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(Channel channel) {
        return channelDao.exist(channel);
    }
}
