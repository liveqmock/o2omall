package com.awe.pay.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.pay.sdk.request.RefundRequest;
import com.awe.pay.sdk.request.dto.RefundRequestDto;
import com.awe.pay.sdk.response.RefundResponse;
import com.awe.pay.sdk.response.dto.RefundResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 逆向退款服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:55:04
 * 
 */
public class RefundClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(RefundClient.class);

    /**
     * 逆向退款查询服务
     * 
     * @param request
     *            查询请求对象
     * @return RefundResponseDto 接口返回的数据对象
     */
    public RefundResponseDto getRefund(RefundRequestDto requestDto) {
        Assert.notNull(requestDto);

        RefundRequest request = new RefundRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getRefund request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/refund/getRefund";
        RefundResponse response = super.getRestTemplate().postForObject(url, request, RefundResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getRefund url: " + url);
            LOG.debug("getRefund response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    
    /**
     * 退款写入接口
     * @param requestDto
     * @return
     */
    public Wrapper<?> addRefund(RefundRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("addRefund request: " + JsonHelper.toJson(requestDto));
        }

        RefundRequest request = new RefundRequest(super.getKey(), requestDto);
        RefundResponse response = null;
        String url = null;
        try {
   		 url = super.getServiceUrlDomain() + "services/refund/addRefund";
   		 response = super.getRestTemplate().postForObject(url, request, RefundResponse.class);
		} catch (Exception e) {
			LOG.error("#RefundClient.addRefund# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
           LOG.debug("addRefund url: " + url);
           LOG.debug("addRefund response: " + JsonHelper.toJson(response));
		}
		if (null != response) {
			return WrapMapper.wrap(response.getCode(),response.getMessage());
	    } else {
	    	return WrapMapper.error();
	    }
    }
}
