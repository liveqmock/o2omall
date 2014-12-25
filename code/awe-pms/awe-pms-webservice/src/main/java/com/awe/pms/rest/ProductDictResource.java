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
import com.awe.pms.domain.ProductDict;
import com.awe.pms.sdk.api.request.ProductDictRequest;
import com.awe.pms.sdk.api.request.dto.ProductDictRequestDto;
import com.awe.pms.sdk.api.response.dto.ProductDictResponseDto;
import com.awe.pms.service.ProductDictService;

/**
 * 配置表REST服务：提供有关配置表的接口
 * 
 * @author ljz
 * @version 2014-12-25 14:47:40
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ProductDictResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ProductDictService productDictService; 

    /**
     * 查询配置表信息
     * 
     * @param request
     *            配置表请求参数
     * @return 配置表返回对象
     * 
     */
    @POST
    @Path("/productDict/getProductDict")
    public Wrapper<?> getProductDict(ProductDictRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getProductDict 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ProductDictRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getProductDict 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ProductDict productDict = productDictService.getProductDictById(requestDto.getId());
            ProductDictResponseDto responseDto = convert(productDict);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询配置表数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ProductDictResponseDto convert(ProductDict productDict) {
        if (null == productDict) {
            return null;
        }

        ProductDictResponseDto productDictResponseDto = new ProductDictResponseDto();
        BeanUtils.copyProperties(productDict, productDictResponseDto);
        return productDictResponseDto;
    }

    // 数据转换
    private List<ProductDictResponseDto> convertList(List<ProductDict> productDicts) {
        if (CollectionUtils.isEmpty(productDicts)) {
            return null;
        }

        List<ProductDictResponseDto> list = new ArrayList<ProductDictResponseDto>(productDicts.size());
        for (ProductDict productDict : productDicts) {
            list.add(convert(productDict));
        }
        return list;
    } 

}
