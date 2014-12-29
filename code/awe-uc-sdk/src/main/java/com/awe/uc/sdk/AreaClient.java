package com.awe.uc.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.request.AreaRequest;
import com.awe.uc.sdk.request.dto.AreaRequestDto;
import com.awe.uc.sdk.response.AreaResponse;
import com.awe.uc.sdk.response.dto.AreaResponseDto;
import com.awe.uc.sdk.util.MixContents;

/**
 * 三级地址服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class AreaClient extends AbstractSecureClient {

    private final static Log LOG = LogFactory.getLog(AreaClient.class);

    /**
     * 三级地址查询服务
     * 
     * @param request
     *            查询请求对象
     * @return AreaDto 对象
     */
    public List<AreaResponseDto> getArea(AreaRequestDto requestDto) {
        Assert.notNull(requestDto);

        AreaRequest request = new AreaRequest(super.getKey(), requestDto);
        
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

    /**
     * 获取所有省
     * 
     * @return
     */
    public List<AreaResponseDto> getProvinces() {
        AreaRequestDto requestDto = new AreaRequestDto();
        requestDto.setLevel(MixContents.PROVINCE_LEVEL);
        return this.getArea(requestDto);
    }

    /**
     * 获取省下面的所有市
     * 
     * @param provinceCode
     *            省编码
     * @return
     */
    public List<AreaResponseDto> getCities(String provinceCode) {
        AreaRequestDto requestDto = new AreaRequestDto();
        requestDto.setLevel(MixContents.CITY_LEVEL);
        requestDto.setParentCode(provinceCode);
        return this.getArea(requestDto);
    }

    /**
     * 获取市下面的所有县
     * 
     * @param cityCode
     *            市编码
     * @return
     */
    public List<AreaResponseDto> getCountys(String cityCode) {
        AreaRequestDto requestDto = new AreaRequestDto();
        requestDto.setLevel(MixContents.COUNTY_LEVEL);
        requestDto.setParentCode(cityCode);
        return this.getArea(requestDto);
    }

   
}
