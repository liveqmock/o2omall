package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.SkuImagesRequest;
import com.awe.pms.sdk.request.dto.SkuImagesRequestDto;
import com.awe.pms.sdk.response.SkuImagesResponse;
import com.awe.pms.sdk.response.dto.SkuImagesResponseDto;

/**
 * sku图片服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:50:15
 * 
 */
public class SkuImagesClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(SkuImagesClient.class);

    /**
     * sku图片查询服务
     * 
     * @param request
     *            查询请求对象
     * @return SkuImagesResponseDto 接口返回的数据对象
     */
    public SkuImagesResponseDto getSkuImages(SkuImagesRequestDto requestDto) {
        Assert.notNull(requestDto);

        SkuImagesRequest request = new SkuImagesRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getSkuImages request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/skuImages/getSkuImages";
        SkuImagesResponse response = super.getRestTemplate().postForObject(url, request, SkuImagesResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getSkuImages url: " + url);
            LOG.debug("getSkuImages response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
