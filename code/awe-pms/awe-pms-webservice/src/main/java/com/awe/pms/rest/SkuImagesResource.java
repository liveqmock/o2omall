package com.awe.pms.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.awe.pms.domain.SkuImages;
import com.awe.pms.domain.query.SkuImagesQuery;
import com.awe.pms.sdk.api.request.SkuImagesRequest;
import com.awe.pms.sdk.api.request.dto.SkuImagesRequestDto;
import com.awe.pms.sdk.api.response.dto.SkuImagesResponseDto;
import com.awe.pms.service.SkuImagesService;

/**
 * sku图片REST服务：提供有关sku图片的接口
 * 
 * @author ljz
 * @version 2014-12-25 14:47:40
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class SkuImagesResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private SkuImagesService skuImagesService; 

    /**
     * 查询sku图片信息
     * 
     * @param request
     *            sku图片请求参数
     * @return sku图片返回对象
     * 
     */
    @POST
    @Path("/skuImages/getSkuImages")
    public Wrapper<?> getSkuImages(SkuImagesRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getSkuImages 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        SkuImagesRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getSkuImages 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            SkuImages skuImages = skuImagesService.getSkuImagesById(requestDto.getId());
            SkuImagesResponseDto responseDto = convert(skuImages);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询sku图片数据异常", e);
            return WrapMapper.error();
        }
    } 
    
    /**
     * 查询sku图片信息
     * 
     * @param request
     *            sku图片请求参数
     * @return sku图片返回对象
     * 
     */
    @POST
    @Path("/skuImages/getSkuImageList")
    public Wrapper<?> getSkuImageList(SkuImagesRequest request) {
    	if (null == request || !request.checkSign()) {
    		this.logger.error("getSkuImageList 拒绝访问");
    		return WrapMapper.forbidden();
    	}
    	
    	SkuImagesRequestDto requestDto = request.getContent();
    	if (null == requestDto || (null == requestDto.getId() && StringUtils.isBlank(requestDto.getSkuNo()))) {
    		this.logger.error("getSkuImageList 传入参数有误");
    		return WrapMapper.illegalArgument();
    	}
    	
    	try {
    		SkuImagesQuery queryBean = new SkuImagesQuery();
    		BeanUtils.copyProperties(requestDto, queryBean);
    		List<SkuImages> list = this.skuImagesService.querySkuImagesList(queryBean);
    		List<SkuImagesResponseDto> responseDtos = convertList(list);
    		return WrapMapper.ok().result(responseDtos);
    	} catch (Exception e) {
    		this.logger.error("查询sku图片list数据异常", e);
    		return WrapMapper.error();
    	}
    } 

    // 数据转换
    private SkuImagesResponseDto convert(SkuImages skuImages) {
        if (null == skuImages) {
            return null;
        }

        SkuImagesResponseDto skuImagesResponseDto = new SkuImagesResponseDto();
        BeanUtils.copyProperties(skuImages, skuImagesResponseDto);
        return skuImagesResponseDto;
    }

    // 数据转换
    private List<SkuImagesResponseDto> convertList(List<SkuImages> skuImagess) {
        if (CollectionUtils.isEmpty(skuImagess)) {
            return null;
        }

        List<SkuImagesResponseDto> list = new ArrayList<SkuImagesResponseDto>(skuImagess.size());
        for (SkuImages skuImages : skuImagess) {
            list.add(convert(skuImages));
        }
        return list;
    } 

}
