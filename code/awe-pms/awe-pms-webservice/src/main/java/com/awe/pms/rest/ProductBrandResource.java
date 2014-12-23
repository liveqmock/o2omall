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
import com.awe.pms.domain.ProductBrand;
import com.awe.pms.sdk.api.request.ProductBrandRequest;
import com.awe.pms.sdk.api.request.dto.ProductBrandRequestDto;
import com.awe.pms.sdk.api.response.dto.ProductBrandResponseDto;
import com.awe.pms.service.ProductBrandService;

/**
 * 商品类别品牌REST服务：提供有关商品类别品牌的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ProductBrandResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ProductBrandService productBrandService; 

    /**
     * 查询商品类别品牌信息
     * 
     * @param request
     *            商品类别品牌请求参数
     * @return 商品类别品牌返回对象
     * 
     */
    @POST
    @Path("/productBrand/getProductBrand")
    public Wrapper<?> getProductBrand(ProductBrandRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getProductBrand 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ProductBrandRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getProductBrand 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ProductBrand productBrand = productBrandService.getProductBrandById(requestDto.getId());
            ProductBrandResponseDto responseDto = convert(productBrand);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询商品类别品牌数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ProductBrandResponseDto convert(ProductBrand productBrand) {
        if (null == productBrand) {
            return null;
        }

        ProductBrandResponseDto productBrandResponseDto = new ProductBrandResponseDto();
        BeanUtils.copyProperties(productBrand, productBrandResponseDto);
        return productBrandResponseDto;
    }

    // 数据转换
    private List<ProductBrandResponseDto> convertList(List<ProductBrand> productBrands) {
        if (CollectionUtils.isEmpty(productBrands)) {
            return null;
        }

        List<ProductBrandResponseDto> list = new ArrayList<ProductBrandResponseDto>(productBrands.size());
        for (ProductBrand productBrand : productBrands) {
            list.add(convert(productBrand));
        }
        return list;
    } 

}
