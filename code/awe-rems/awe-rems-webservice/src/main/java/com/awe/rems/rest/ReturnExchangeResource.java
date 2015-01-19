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

import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.query.ReturnExchangeQuery;
import com.awe.rems.sdk.api.request.ReturnExchangeRequest;
import com.awe.rems.sdk.api.request.dto.ReturnExchangeRequestDto;
import com.awe.rems.sdk.api.response.dto.ReturnExchangeResponseDto;
import com.awe.rems.service.ReturnExchangeService;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.PageWrapMapper;
import com.hbird.common.utils.wrap.PageWrapper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 退换货REST服务：提供有关退换货的接口
 * 
 * @author zyq
 * @version 2014-12-25 9:16:23
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
    /**
     * 申请退换货
     * @param request
     * @return
     */
    @POST
    @Path("/returnExchange/addReturnExchange")
    public Wrapper<?> addReturnExchange(ReturnExchangeRequest request){
    	if (null == request || !request.checkSign()) {
            this.logger.error("addReturnExchange 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ReturnExchangeRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("addReturnExchange 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
        	ReturnExchange returnExchange = new ReturnExchange();
        	BeanUtils.copyProperties(requestDto, returnExchange);
            boolean ret = returnExchangeService.insert(returnExchange);
            if(ret){
            	return WrapMapper.ok();
            }else{
            	return WrapMapper.error();
            }
        } catch (Exception e) {
            this.logger.error("申请退换货数据异常", e);
            return WrapMapper.error();
        }
    }
    /**
     * 我的退换货列表
     * @param request
     * @param pageUtil
     * @return
     */
    @POST
    @Path("/returnExchange/queryReturnExchangeListWithPage")
    public PageWrapper<?> queryReturnExchangeListWithPage(ReturnExchangeRequest request){
    	if (null == request || !request.checkSign()) {
            this.logger.error("queryReturnExchangeListWithPage 拒绝访问");
            return PageWrapMapper.error();
        }
        
        ReturnExchangeRequestDto requestDto = request.getContent();
        PageUtil pageUtil = request.getPageUtil();
        if (null == requestDto) {
            this.logger.error("queryReturnExchangeListWithPage 传入参数有误");
            return PageWrapMapper.illegalArgument();
        }
        try {
        	ReturnExchangeQuery queryBean = new ReturnExchangeQuery();
        	BeanUtils.copyProperties(requestDto,queryBean);
        	
        	List<ReturnExchange> dataList = returnExchangeService.queryReturnExchangeListWithPage(queryBean, pageUtil);
        	List<ReturnExchangeResponseDto> responseDtoList = convertList(dataList);
        	return PageWrapMapper.ok().result(responseDtoList).pageUtil(pageUtil);
		} catch (Exception e) {
			this.logger.error("查询退换货数据异常", e);
            return PageWrapMapper.error();
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
