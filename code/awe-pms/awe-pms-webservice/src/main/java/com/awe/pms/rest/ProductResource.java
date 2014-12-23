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
import com.awe.pms.domain.Product;
import com.awe.pms.sdk.api.request.ProductRequest;
import com.awe.pms.sdk.api.request.dto.ProductRequestDto;
import com.awe.pms.sdk.api.response.dto.ProductResponseDto;
import com.awe.pms.service.ProductService;

/**
 * 商品信息REST服务：提供有关商品信息的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ProductResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ProductService productService; 

    /**
     * 查询商品信息信息
     * 
     * @param request
     *            商品信息请求参数
     * @return 商品信息返回对象
     * 
     */
    @POST
    @Path("/product/getProduct")
    public Wrapper<?> getProduct(ProductRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getProduct 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ProductRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getProduct 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            Product product = productService.getProductById(requestDto.getId());
            ProductResponseDto responseDto = convert(product);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询商品信息数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ProductResponseDto convert(Product product) {
        if (null == product) {
            return null;
        }

        ProductResponseDto productResponseDto = new ProductResponseDto();
        BeanUtils.copyProperties(product, productResponseDto);
        return productResponseDto;
    }

    // 数据转换
    private List<ProductResponseDto> convertList(List<Product> products) {
        if (CollectionUtils.isEmpty(products)) {
            return null;
        }

        List<ProductResponseDto> list = new ArrayList<ProductResponseDto>(products.size());
        for (Product product : products) {
            list.add(convert(product));
        }
        return list;
    } 

}
