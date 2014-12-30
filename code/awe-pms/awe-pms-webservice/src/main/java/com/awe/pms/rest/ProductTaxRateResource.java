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
import com.awe.pms.domain.ProductTaxRate;
import com.awe.pms.sdk.api.request.ProductTaxRateRequest;
import com.awe.pms.sdk.api.request.dto.ProductTaxRateRequestDto;
import com.awe.pms.sdk.api.response.dto.ProductTaxRateResponseDto;
import com.awe.pms.service.ProductTaxRateService;

/**
 * 税率REST服务：提供有关税率的接口
 * 
 * @author ljz
 * @version 2014-12-29 11:45:59
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ProductTaxRateResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ProductTaxRateService productTaxRateService; 

    /**
     * 查询税率信息
     * 
     * @param request
     *            税率请求参数
     * @return 税率返回对象
     * 
     */
    @POST
    @Path("/productTaxRate/getProductTaxRate")
    public Wrapper<?> getProductTaxRate(ProductTaxRateRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getProductTaxRate 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ProductTaxRateRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getProductTaxRate 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ProductTaxRate productTaxRate = productTaxRateService.getProductTaxRateById(requestDto.getId());
            ProductTaxRateResponseDto responseDto = convert(productTaxRate);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询税率数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ProductTaxRateResponseDto convert(ProductTaxRate productTaxRate) {
        if (null == productTaxRate) {
            return null;
        }

        ProductTaxRateResponseDto productTaxRateResponseDto = new ProductTaxRateResponseDto();
        BeanUtils.copyProperties(productTaxRate, productTaxRateResponseDto);
        return productTaxRateResponseDto;
    }

    // 数据转换
    private List<ProductTaxRateResponseDto> convertList(List<ProductTaxRate> productTaxRates) {
        if (CollectionUtils.isEmpty(productTaxRates)) {
            return null;
        }

        List<ProductTaxRateResponseDto> list = new ArrayList<ProductTaxRateResponseDto>(productTaxRates.size());
        for (ProductTaxRate productTaxRate : productTaxRates) {
            list.add(convert(productTaxRate));
        }
        return list;
    } 

}
