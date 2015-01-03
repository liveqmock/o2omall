package com.awe.mall.service;

import java.util.List;

import com.awe.pms.sdk.request.dto.ProductCategoryRequestDto;
import com.awe.pms.sdk.response.dto.ProductCategoryResponseDto;

/**
 * ProductCategoryService接口
 * 
 * @author zhc
 * @version 2014-12-25 14:47:31
 * 
 */
public interface ProductCategoryService {

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductCategoryResponseDto> queryProductCategoryList(ProductCategoryRequestDto requestDto);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ProductCategoryResponseDto getProductCategoryById(ProductCategoryRequestDto requestDto);
}
