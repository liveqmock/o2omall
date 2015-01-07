package com.awe.pms.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.awe.pms.domain.Product;
import com.awe.pms.domain.ProductSku;
import com.awe.pms.domain.query.ProductQuery;
import com.awe.pms.domain.query.ProductSkuQuery;
import com.awe.pms.sdk.api.request.ProductRequest;
import com.awe.pms.sdk.api.request.ProductSkuRequest;
import com.awe.pms.sdk.api.request.dto.ProductRequestDto;
import com.awe.pms.sdk.api.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.api.response.dto.ProductResponseDto;
import com.awe.pms.sdk.api.response.dto.ProductSkuResponseDto;
import com.awe.pms.service.ProductService;
import com.awe.pms.service.ProductSkuService;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 商品信息REST服务：提供有关商品信息的接口
 * 
 * @author ljz
 * @version 2014-12-25 14:47:40
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
    
    @Autowired
    private ProductSkuService productSkuService;

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
        if (null == requestDto || (null == requestDto.getId() && StringUtils.isBlank(requestDto.getProductNo()))) {
            this.logger.error("getProduct 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
        	ProductQuery queryBean = new ProductQuery();
        	BeanUtils.copyProperties(requestDto, queryBean);
			
            List<Product> products = this.productService.queryProductList(queryBean);
            Product product = null;
            if (null != products && products.size() > 0) {
            	product = products.get(0);
            }
            ProductResponseDto responseDto = convert(product);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询商品信息数据异常", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 根据 SKU_NO 查询商品信息信息
     * 
     * @param request
     *            商品信息请求参数
     * @return 商品信息返回对象
     * 
     */
    @POST
    @Path("/product/getProductBySkuNo")
    public Wrapper<?> getProductBySkuNo(ProductSkuRequest request) {
    	if (null == request || !request.checkSign()) {
    		this.logger.error("getProduct 拒绝访问");
    		return WrapMapper.forbidden();
    	}
    	
    	ProductSkuRequestDto requestDto = request.getContent();
    	if (null == requestDto || StringUtils.isBlank(requestDto.getSkuNo())) {
    		this.logger.error("getProductBySkuNo 传入参数有误");
    		return WrapMapper.illegalArgument();
    	}
    	
    	try {
    		ProductSkuQuery queryBean = new ProductSkuQuery();
    		queryBean.setSkuNo(requestDto.getSkuNo());
    		List<ProductSku> productSkus = this.productSkuService.queryProductSkuList(queryBean);
    		
    		Product product = null;
    		if (null != productSkus && productSkus.size() > 0) {
    			String productNo = productSkus.get(0).getProductNo();
    			ProductQuery queryBean2 = new ProductQuery();
    			queryBean2.setProductNo(productNo);
    			List<Product> products = this.productService.queryProductList(queryBean2);
    			if (null != products && products.size() > 0) {
    				product = products.get(0);
    				product.setProductSkus(productSkus);
    			}
    		}
    		
    		ProductResponseDto responseDto = convert(product);
    		return WrapMapper.ok().result(responseDto);
    	} catch (Exception e) {
    		this.logger.error("根据 SKU_NO【" + requestDto.getSkuNo() + "】 查询商品信息信息数据异常", e);
    		return WrapMapper.error();
    	}
    }
    
    /**
     * 根据条件查询商品信息信息
     * 
     * @param request
     *            商品信息请求参数
     * @return 商品信息返回对象
     * 
     */
    @POST
    @Path("/product/getProducts")
    public Wrapper<?> getProducts(ProductRequest request) {
    	if (null == request || !request.checkSign()) {
    		this.logger.error("getProducts 拒绝访问");
    		return WrapMapper.forbidden();
    	}	
    	
    	ProductRequestDto requestDto = request.getContent();
    	ProductQuery queryBean = new ProductQuery();
    	if (null != requestDto) {
    		BeanUtils.copyProperties(requestDto, queryBean);
    	}
    	
    	try {
			List<Product> products = this.productService.queryProductList(queryBean);
    		List<ProductResponseDto> responseDtos = convertList(products);
    		return WrapMapper.ok().result(responseDtos);
    	} catch (Exception e) {
    		this.logger.error("根据条件查询商品信息数据异常", e);
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
        
        List<ProductSku> productSkus = product.getProductSkus();
        if (productSkus != null && productSkus.size() > 0) {
        	List<ProductSkuResponseDto> productSkuResponseDtos = new ArrayList<ProductSkuResponseDto>();
        	for (ProductSku productSku : productSkus) {
        		ProductSkuResponseDto productSkuResponseDto = new ProductSkuResponseDto();
        		BeanUtils.copyProperties(productSku, productSkuResponseDto);
        		productSkuResponseDtos.add(productSkuResponseDto);
        	}
        	productResponseDto.setProductSkuResponseDtos(productSkuResponseDtos);
        }
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
