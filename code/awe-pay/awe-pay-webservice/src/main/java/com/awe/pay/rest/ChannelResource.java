package com.awe.pay.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.awe.pay.domain.Channel;
import com.awe.pay.sdk.api.request.ChannelRequest;
import com.awe.pay.sdk.api.request.dto.ChannelRequestDto;
import com.awe.pay.sdk.api.response.dto.ChannelResponseDto;
import com.awe.pay.service.ChannelService;

/**
 * 支付通道REST服务：提供有关支付通道的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ChannelResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ChannelService channelService; 

    /**
     * 查询支付通道信息
     * 
     * @param request
     *            支付通道请求参数
     * @return 支付通道返回对象
     * 
     */
    @POST
    @Path("/channel/getChannel")
    public Wrapper<?> getChannel(ChannelRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getChannel 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ChannelRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getChannel 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            Channel channel = channelService.getChannelById(requestDto.getId());
            ChannelResponseDto responseDto = convert(channel);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询支付通道数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ChannelResponseDto convert(Channel channel) {
        if (null == channel) {
            return null;
        }

        ChannelResponseDto channelResponseDto = new ChannelResponseDto();
        BeanUtils.copyProperties(channel, channelResponseDto);
        return channelResponseDto;
    }

    // 数据转换
    private List<ChannelResponseDto> convertList(List<Channel> channels) {
        if (CollectionUtils.isEmpty(channels)) {
            return null;
        }

        List<ChannelResponseDto> list = new ArrayList<ChannelResponseDto>(channels.size());
        for (Channel channel : channels) {
            list.add(convert(channel));
        }
        return list;
    } 

}
