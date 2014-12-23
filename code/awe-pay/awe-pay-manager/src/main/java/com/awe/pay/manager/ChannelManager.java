package com.awe.pay.manager;

import java.util.List;

import com.awe.pay.domain.Channel;
import com.awe.pay.domain.query.ChannelQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * ChannelManager接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
public interface ChannelManager {

    /**
     * 批量增加对象信息
     * 
     * @param channelList
     * @return
     */
    public boolean insert(List<Channel> channelList);

    /**
     * 单个增加对象信息
     * 
     * @param channel
     * @return
     */
    public boolean insert(Channel channel);

    /**
     * 更新 对象信息
     * 
     * @param channel
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(Channel channel);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Channel> queryChannelList(ChannelQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<Channel> queryChannelListWithPage(ChannelQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryChannelCount(ChannelQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param channel
     *            　
     * @return
     */
    public boolean delete(Channel channel);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public Channel getChannelById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param channels
     *            Channel集合
     * @return
     */
    public boolean delete(Channel[] channels);

    /**
     * 判断是否存在
     * 
     * @param channel
     * @return
     */
    public boolean exist(Channel channel);
}
