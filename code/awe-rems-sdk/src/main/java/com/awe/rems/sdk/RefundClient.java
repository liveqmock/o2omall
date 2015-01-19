package com.awe.rems.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.rems.sdk.request.RefundRequest;
import com.awe.rems.sdk.request.dto.RefundRequestDto;
import com.awe.rems.sdk.response.RefundResponse;
import com.awe.rems.sdk.response.RefundResponseList;
import com.awe.rems.sdk.response.dto.RefundResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * 退款表服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:54:00
 * 
 */
public class RefundClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(RefundClient.class);

    /**
     * 退款表查询服务
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
     * 查询退款列表
     * @param requestDto
     * @return
     */
    public List<RefundResponseDto> queryRefundListWithPage(RefundRequestDto requestDto,PageUtil pageUtil){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("queryRefundListWithPage request: " + JsonHelper.toJson(requestDto));
        }
    	RefundRequest request = new RefundRequest(super.getKey(), requestDto, pageUtil);
    	List<RefundResponseDto> responseDtoList = null;
    	RefundResponseList responseList = null;
    	String url = null;
    	try {
    		int totalRow;
    		 url = super.getServiceUrlDomain() + "services/refund/queryRefundListWithPage";
    		 responseList = super.getRestTemplate().postForObject(url, request, RefundResponseList.class);
    		 responseDtoList = responseList.getResult();
    		 totalRow = responseList.getPageUtil().getTotalRow();
    		 pageUtil.setTotalRow(totalRow);
    		 pageUtil.init();
		} catch (Exception e) {
			LOG.error("#RefundClient.queryRefundListWithPage# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("queryRefundListWithPage url: " + url);
            LOG.debug("queryRefundListWithPage response: " + JsonHelper.toJson(responseDtoList));
        }
		return responseDtoList;
    }
    
}
