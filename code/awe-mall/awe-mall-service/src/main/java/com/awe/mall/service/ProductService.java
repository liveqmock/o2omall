package com.awe.mall.service;

import java.util.List;

import com.awe.pms.sdk.request.dto.ProductRequestDto;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.dto.ProductResponseDto;

/**
 * ProductService接口
 * 
 * @author zhc
 * @version 2014-12-25 14:47:31
 * 
 */
public interface ProductService {

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductResponseDto> queryProducts(ProductRequestDto requestDto);

    /**
     * 根据主键获取对象信息
     * 
     * @param requestDto
     *            对象
     * @return 对象信息
     */
    public ProductResponseDto getProduct(ProductRequestDto requestDto);
    
    /**
     * 根据 SKU_NO 查询商品信息信息
     * 
     * @param requestDto
     *            对象
     * @return 对象信息
     */
    public ProductResponseDto getProductBySkuNo(ProductSkuRequestDto requestDto);
}
