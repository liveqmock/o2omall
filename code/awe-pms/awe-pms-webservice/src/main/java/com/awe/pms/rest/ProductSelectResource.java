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
import com.awe.pms.domain.ProductSelect;
import com.awe.pms.domain.query.ProductSelectQuery;
import com.awe.pms.sdk.api.request.ProductSelectRequest;
import com.awe.pms.sdk.api.request.dto.ProductSelectRequestDto;
import com.awe.pms.sdk.api.response.dto.ProductSelectResponseDto;
import com.awe.pms.service.ProductSelectService;

/**
 * 商品查询综合表REST服务：提供有关商品查询综合表的接口
 * 
 * @author ljz
 * @version 2015-1-21 10:47:34
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ProductSelectResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ProductSelectService productSelectService; 

    /**
     * 查询商品查询综合表信息
     * 
     * @param request
     *            商品查询综合表请求参数
     * @return 商品查询综合表返回对象
     * 
     */
    @POST
    @Path("/productSelect/getProductSelect")
    public Wrapper<?> getProductSelect(ProductSelectRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getProductSelect 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ProductSelectRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getProductSelect 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ProductSelect productSelect = productSelectService.getProductSelectById(requestDto.getId());
            ProductSelectResponseDto responseDto = convert(productSelect);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询商品查询综合表数据异常", e);
            return WrapMapper.error();
        }
    } 
    
    /**
     * 查询商品综合表数据集合
     * 
     * @param request
     *            商品查询综合表请求参数
     * @return 商品查询综合表返回对象
     * 
     */
    @POST
    @Path("/productSelect/getProductSelects")
    public Wrapper<?> getProductSelects(ProductSelectRequest request) {
    	if (null == request || !request.checkSign()) {
    		this.logger.error("getProductSelects 拒绝访问");
    		return WrapMapper.forbidden();
    	}
    	
    	ProductSelectRequestDto requestDto = request.getContent();
    	ProductSelectQuery queryBean = new ProductSelectQuery();
    	if (requestDto != null) {
    		BeanUtils.copyProperties(requestDto, queryBean);
    	}
    	
    	try {
			List<ProductSelect> productSelects = this.productSelectService.queryProductSelectList(queryBean);
    		List<ProductSelectResponseDto> responseDtos = convertList(productSelects);
    		return WrapMapper.ok().result(responseDtos);
    	} catch (Exception e) {
    		this.logger.error("查询商品综合表数据集合异常", e);
    		return WrapMapper.error();
    	}
    } 

    // 数据转换
    private ProductSelectResponseDto convert(ProductSelect productSelect) {
        if (null == productSelect) {
            return null;
        }

        ProductSelectResponseDto productSelectResponseDto = new ProductSelectResponseDto();
        BeanUtils.copyProperties(productSelect, productSelectResponseDto);
        return productSelectResponseDto;
    }

    // 数据转换
    private List<ProductSelectResponseDto> convertList(List<ProductSelect> productSelects) {
        if (CollectionUtils.isEmpty(productSelects)) {
            return null;
        }

        List<ProductSelectResponseDto> list = new ArrayList<ProductSelectResponseDto>(productSelects.size());
        for (ProductSelect productSelect : productSelects) {
            list.add(convert(productSelect));
        }
        return list;
    } 

}
