package com.awe.mall.service;

import java.util.List;

import com.awe.pms.sdk.request.dto.ProductBrandRequestDto;
import com.awe.pms.sdk.response.dto.ProductBrandResponseDto;

/**
 * ProductBrandService接口
 * 
 * @author zhc
 * @version 2014-12-25 14:47:31
 * 
 */
public interface ProductBrandService {

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductBrandResponseDto> queryProductBrandList(ProductBrandRequestDto requestDto);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ProductBrandResponseDto getProductBrandById(ProductBrandRequestDto requestDto);
}
