package com.awe.pms.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.pms.sdk.request.SkuImagesRequest;
import com.awe.pms.sdk.response.SkuImagesResponse;
import com.awe.pms.sdk.response.dto.SkuImagesResponseDto;

/**
 * sku图片服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
public class SkuImagesClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(SkuImagesClient.class);

    /**
     * sku图片查询服务
     * 
     * @param request
     *            查询请求对象
     * @return SkuImagesDto 对象
     */
    public SkuImagesResponseDto getSkuImages(SkuImagesRequest request) {
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
