package com.awe.pms.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.awe.pms.domain.ProductCategory;
import com.awe.pms.sdk.api.request.ProductCategoryRequest;
import com.awe.pms.sdk.api.request.dto.ProductCategoryRequestDto;
import com.awe.pms.sdk.api.response.dto.ProductCategoryResponseDto;
import com.awe.pms.service.ProductCategoryService;

/**
 * 商品类别REST服务：提供有关商品类别的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ProductCategoryResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ProductCategoryService productCategoryService; 

    /**
     * 查询商品类别信息
     * 
     * @param request
     *            商品类别请求参数
     * @return 商品类别返回对象
     * 
     */
    @POST
    @Path("/productCategory/getProductCategory")
    public Wrapper<?> getProductCategory(ProductCategoryRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getProductCategory 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ProductCategoryRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getProductCategory 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ProductCategory productCategory = productCategoryService.getProductCategoryById(requestDto.getId());
            ProductCategoryResponseDto responseDto = convert(productCategory);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询商品类别数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ProductCategoryResponseDto convert(ProductCategory productCategory) {
        if (null == productCategory) {
            return null;
        }

        ProductCategoryResponseDto productCategoryResponseDto = new ProductCategoryResponseDto();
        BeanUtils.copyProperties(productCategory, productCategoryResponseDto);
        return productCategoryResponseDto;
    }

    // 数据转换
    private List<ProductCategoryResponseDto> convertList(List<ProductCategory> productCategorys) {
        if (CollectionUtils.isEmpty(productCategorys)) {
            return null;
        }

        List<ProductCategoryResponseDto> list = new ArrayList<ProductCategoryResponseDto>(productCategorys.size());
        for (ProductCategory productCategory : productCategorys) {
            list.add(convert(productCategory));
        }
        return list;
    } 

}
