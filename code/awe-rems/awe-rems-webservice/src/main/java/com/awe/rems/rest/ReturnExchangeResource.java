package com.awe.rems.rest;

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
import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.sdk.api.request.ReturnExchangeRequest;
import com.awe.rems.sdk.api.request.dto.ReturnExchangeRequestDto;
import com.awe.rems.sdk.api.response.dto.ReturnExchangeResponseDto;
import com.awe.rems.service.ReturnExchangeService;

/**
 * 退换货REST服务：提供有关退换货的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:17
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ReturnExchangeResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ReturnExchangeService returnExchangeService; 

    /**
     * 查询退换货信息
     * 
     * @param request
     *            退换货请求参数
     * @return 退换货返回对象
     * 
     */
    @POST
    @Path("/returnExchange/getReturnExchange")
    public Wrapper<?> getReturnExchange(ReturnExchangeRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getReturnExchange 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ReturnExchangeRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getReturnExchange 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ReturnExchange returnExchange = returnExchangeService.getReturnExchangeById(requestDto.getId());
            ReturnExchangeResponseDto responseDto = convert(returnExchange);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询退换货数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ReturnExchangeResponseDto convert(ReturnExchange returnExchange) {
        if (null == returnExchange) {
            return null;
        }

        ReturnExchangeResponseDto returnExchangeResponseDto = new ReturnExchangeResponseDto();
        BeanUtils.copyProperties(returnExchange, returnExchangeResponseDto);
        return returnExchangeResponseDto;
    }

    // 数据转换
    private List<ReturnExchangeResponseDto> convertList(List<ReturnExchange> returnExchanges) {
        if (CollectionUtils.isEmpty(returnExchanges)) {
            return null;
        }

        List<ReturnExchangeResponseDto> list = new ArrayList<ReturnExchangeResponseDto>(returnExchanges.size());
        for (ReturnExchange returnExchange : returnExchanges) {
            list.add(convert(returnExchange));
        }
        return list;
    } 

}
