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
import com.awe.pay.domain.TradeRefundFail;
import com.awe.pay.sdk.api.request.TradeRefundFailRequest;
import com.awe.pay.sdk.api.request.dto.TradeRefundFailRequestDto;
import com.awe.pay.sdk.api.response.dto.TradeRefundFailResponseDto;
import com.awe.pay.service.TradeRefundFailService;

/**
 * 正向交易及逆向退款失败表REST服务：提供有关正向交易及逆向退款失败表的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class TradeRefundFailResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TradeRefundFailService tradeRefundFailService; 

    /**
     * 查询正向交易及逆向退款失败表信息
     * 
     * @param request
     *            正向交易及逆向退款失败表请求参数
     * @return 正向交易及逆向退款失败表返回对象
     * 
     */
    @POST
    @Path("/tradeRefundFail/getTradeRefundFail")
    public Wrapper<?> getTradeRefundFail(TradeRefundFailRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getTradeRefundFail 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        TradeRefundFailRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getTradeRefundFail 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TradeRefundFail tradeRefundFail = tradeRefundFailService.getTradeRefundFailById(requestDto.getId());
            TradeRefundFailResponseDto responseDto = convert(tradeRefundFail);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询正向交易及逆向退款失败表数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private TradeRefundFailResponseDto convert(TradeRefundFail tradeRefundFail) {
        if (null == tradeRefundFail) {
            return null;
        }

        TradeRefundFailResponseDto tradeRefundFailResponseDto = new TradeRefundFailResponseDto();
        BeanUtils.copyProperties(tradeRefundFail, tradeRefundFailResponseDto);
        return tradeRefundFailResponseDto;
    }

    // 数据转换
    private List<TradeRefundFailResponseDto> convertList(List<TradeRefundFail> tradeRefundFails) {
        if (CollectionUtils.isEmpty(tradeRefundFails)) {
            return null;
        }

        List<TradeRefundFailResponseDto> list = new ArrayList<TradeRefundFailResponseDto>(tradeRefundFails.size());
        for (TradeRefundFail tradeRefundFail : tradeRefundFails) {
            list.add(convert(tradeRefundFail));
        }
        return list;
    } 

}
