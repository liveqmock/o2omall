package com.awe.mall.service;

import java.util.List;

import com.awe.pms.sdk.request.dto.ProductDictRequestDto;
import com.awe.pms.sdk.response.dto.ProductDictResponseDto;

/**
 * ProductDictService接口
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
public interface ProductDictService {

    /**
     * 根据指定条件获取对象信息
     * 
     * @param requestDto
     *           	字段
     * @return 对象信息
     */
    public ProductDictResponseDto getProductDict(ProductDictRequestDto requestDto);
    

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductDictResponseDto> queryProductDictList(ProductDictRequestDto requestDto);
}
