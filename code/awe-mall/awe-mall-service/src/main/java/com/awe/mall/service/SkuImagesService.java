package com.awe.mall.service;

import java.util.List;

import com.awe.pms.sdk.request.dto.SkuImagesRequestDto;
import com.awe.pms.sdk.response.dto.SkuImagesResponseDto;


/**
 * SkuImagesService接口
 * 
 * @author zhc
 * @version 2014-12-25 14:47:31
 * 
 */
public interface SkuImagesService {

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<SkuImagesResponseDto> querySkuImageList(SkuImagesRequestDto requestDto);
    
}
