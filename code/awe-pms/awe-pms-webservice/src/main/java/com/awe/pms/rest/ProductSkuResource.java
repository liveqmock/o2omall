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
import com.awe.pms.domain.ProductSku;
import com.awe.pms.sdk.api.request.ProductSkuRequest;
import com.awe.pms.sdk.api.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.api.response.dto.ProductSkuResponseDto;
import com.awe.pms.service.ProductSkuService;

/**
 * 商品SKUREST服务：提供有关商品SKU的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ProductSkuResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ProductSkuService productSkuService; 

    /**
     * 查询商品SKU信息
     * 
     * @param request
     *            商品SKU请求参数
     * @return 商品SKU返回对象
     * 
     */
    @POST
    @Path("/productSku/getProductSku")
    public Wrapper<?> getProductSku(ProductSkuRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getProductSku 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ProductSkuRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getProductSku 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ProductSku productSku = productSkuService.getProductSkuById(requestDto.getId());
            ProductSkuResponseDto responseDto = convert(productSku);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询商品SKU数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ProductSkuResponseDto convert(ProductSku productSku) {
        if (null == productSku) {
            return null;
        }

        ProductSkuResponseDto productSkuResponseDto = new ProductSkuResponseDto();
        BeanUtils.copyProperties(productSku, productSkuResponseDto);
        return productSkuResponseDto;
    }

    // 数据转换
    private List<ProductSkuResponseDto> convertList(List<ProductSku> productSkus) {
        if (CollectionUtils.isEmpty(productSkus)) {
            return null;
        }

        List<ProductSkuResponseDto> list = new ArrayList<ProductSkuResponseDto>(productSkus.size());
        for (ProductSku productSku : productSkus) {
            list.add(convert(productSku));
        }
        return list;
    } 

}
