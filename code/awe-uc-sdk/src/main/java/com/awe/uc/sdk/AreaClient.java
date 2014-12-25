package com.awe.uc.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.request.AreaRequest;
import com.awe.uc.sdk.response.AreaResponse;
import com.awe.uc.sdk.response.dto.AreaResponseDto;

/**
 * 三级地址服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class AreaClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(AreaClient.class);

    /**
     * 三级地址查询服务
     * 
     * @param request
     *            查询请求对象
     * @return AreaDto 对象
     */
    public List<AreaResponseDto> getArea(AreaRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getArea request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/area/getArea";
        AreaResponse response = super.getRestTemplate().postForObject(url, request, AreaResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getArea url: " + url);
            LOG.debug("getArea response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
