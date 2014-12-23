package com.awe.pay.dao;

import java.util.List;

import com.awe.pay.domain.Channel;
import com.awe.pay.domain.query.ChannelQuery;
/**
 * ChannelDao接口<br/>
 * 对'支付通道'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
public interface ChannelDao {
    
    /**
     * 新增对象
     * 
     * @param channel 
     * @return
     */
    public boolean insert(Channel channel);

    /**
     * 更新对象
     * 
     * @param channel
     * @return
     */
    public boolean update(Channel channel);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Channel> queryChannelList(ChannelQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryChannelCount(ChannelQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Channel> queryChannelListWithPage(ChannelQuery queryBean);

    /**
     * 删除记录
     * 
     * @param channel
     * @return
     */
    public boolean delete(Channel channel);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public Channel getChannelById(Long id);

    /**
     * 判断是否存在
     * 
     * @param channel
     * @return
     */
    public boolean exist(Channel channel);

}
