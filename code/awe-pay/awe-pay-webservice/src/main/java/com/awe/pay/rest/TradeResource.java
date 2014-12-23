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
import com.awe.pay.domain.Trade;
import com.awe.pay.sdk.api.request.TradeRequest;
import com.awe.pay.sdk.api.request.dto.TradeRequestDto;
import com.awe.pay.sdk.api.response.dto.TradeResponseDto;
import com.awe.pay.service.TradeService;

/**
 * 正向交易REST服务：提供有关正向交易的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class TradeResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TradeService tradeService; 

    /**
     * 查询正向交易信息
     * 
     * @param request
     *            正向交易请求参数
     * @return 正向交易返回对象
     * 
     */
    @POST
    @Path("/trade/getTrade")
    public Wrapper<?> getTrade(TradeRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getTrade 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        TradeRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getTrade 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            Trade trade = tradeService.getTradeById(requestDto.getId());
            TradeResponseDto responseDto = convert(trade);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询正向交易数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TradeResponseDto convert(Trade trade) {
        if (null == trade) {
            return null;
        }

        TradeResponseDto tradeResponseDto = new TradeResponseDto();
        BeanUtils.copyProperties(trade, tradeResponseDto);
        return tradeResponseDto;
    }

    // 数据转换
    private List<TradeResponseDto> convertList(List<Trade> trades) {
        if (CollectionUtils.isEmpty(trades)) {
            return null;
        }

        List<TradeResponseDto> list = new ArrayList<TradeResponseDto>(trades.size());
        for (Trade trade : trades) {
            list.add(convert(trade));
        }
        return list;
    } 

}
