package com.awe.rems.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.rems.sdk.request.ReturnExchangeRequest;
import com.awe.rems.sdk.request.dto.ReturnExchangeRequestDto;
import com.awe.rems.sdk.response.ReturnExchangeResponse;
import com.awe.rems.sdk.response.ReturnExchangeResponseList;
import com.awe.rems.sdk.response.dto.ReturnExchangeResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 退换货服务的客户端
 * 
 * @author ljz,zyq
 * @version 2014-12-25 17:54:00
 * 
 */
public class ReturnExchangeClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ReturnExchangeClient.class);

    /**
     * 退换货查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ReturnExchangeResponseDto 接口返回的数据对象
     */
    public ReturnExchangeResponseDto getReturnExchange(ReturnExchangeRequestDto requestDto) {
        Assert.notNull(requestDto);

        ReturnExchangeRequest request = new ReturnExchangeRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getReturnExchange request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/returnExchange/getReturnExchange";
        ReturnExchangeResponse response = super.getRestTemplate().postForObject(url, request, ReturnExchangeResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getReturnExchange url: " + url);
            LOG.debug("getReturnExchange response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    /**
     * 申请退换货
     * @param requestDto
     * @return
     */
    public Wrapper<?> addReturnExchange(ReturnExchangeRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("addReturnExchange request: " + JsonHelper.toJson(requestDto));
        }
    	ReturnExchangeRequest request = new ReturnExchangeRequest(super.getKey(), requestDto);
    	ReturnExchangeResponse response = null;
    	String url = null;
    	try {
    		 url = super.getServiceUrlDomain() + "services/returnExchange/addReturnExchange";
    	     response = super.getRestTemplate().postForObject(url, request, ReturnExchangeResponse.class);
		} catch (Exception e) {
			LOG.error("#ReturnExchangeClient.addReturnExchange# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("addReturnExchange url: " + url);
            LOG.debug("addReturnExchange response: " + JsonHelper.toJson(response));
        }
		if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    /**
     * 我的退换货列表
     * @param requestDto
     * @return
     */
    public List<ReturnExchangeResponseDto> queryReturnExchangeListWithPage(ReturnExchangeRequestDto requestDto,PageUtil pageUtil){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("queryReturnExchangeListWithPage request: " + JsonHelper.toJson(requestDto));
        }
    	ReturnExchangeRequest request = new ReturnExchangeRequest(super.getKey(), requestDto, pageUtil);
    	List<ReturnExchangeResponseDto> responseDtoList = null;
    	ReturnExchangeResponseList responseList = null;
    	String url = null;
    	try {
    		int totalRow;
    		 url = super.getServiceUrlDomain() + "services/returnExchange/queryReturnExchangeListWithPage";
    		 responseList = super.getRestTemplate().postForObject(url, request, ReturnExchangeResponseList.class);
    		 responseDtoList = responseList.getResult();
    		 totalRow = responseList.getPageUtil().getTotalRow();
    		 pageUtil.setTotalRow(totalRow);
    		 pageUtil.init();
		} catch (Exception e) {
			LOG.error("#ReturnExchangeClient.queryReturnExchangeListWithPage# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("queryReturnExchangeListWithPage url: " + url);
            LOG.debug("queryReturnExchangeListWithPage response: " + JsonHelper.toJson(responseList));
        }
		return responseDtoList;
    }
    
}
