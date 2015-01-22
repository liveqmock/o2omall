package com.awe.mall.service;

import java.util.List;

import com.awe.pms.sdk.request.dto.ProductSelectRequestDto;
import com.awe.pms.sdk.response.dto.ProductSelectResponseDto;
import com.hbird.common.utils.page.PageUtil;

/**
 * ProductService接口
 * 
 * @author zhc
 * @version 2014-12-25 14:47:31
 * 
 */
public interface ProductSelectService {

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductSelectResponseDto> queryProductSelects(ProductSelectRequestDto requestDto);
    
    /**
     * 分页根据条件查询商品信息服务
     * 
     * @param request
     *            查询请求对象
     * @return List<ProductSelectResponseDto> 接口返回的数据对象
     */
    public List<ProductSelectResponseDto> getProductSelectsWithPage(ProductSelectRequestDto requestDto, PageUtil pageUtil);
}
