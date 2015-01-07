package com.awe.order.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.awe.order.domain.ShoppingCart;
import com.awe.order.domain.query.ShoppingCartQuery;
import com.awe.order.sdk.api.request.ShoppingCartRequest;
import com.awe.order.sdk.api.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.api.response.dto.ShoppingCartResponseDto;
import com.awe.order.service.ShoppingCartService;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 购物车REST服务：提供有关购物车的接口
 * 
 * @author ljz,zyq
 * @version 2014-12-23 10:58:09
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ShoppingCartResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ShoppingCartService shoppingCartService; 

    /**
     * 查询购物车信息
     * 
     * @param request
     *            购物车请求参数
     * @return 购物车返回对象
     * 
     */
    @POST
    @Path("/shoppingCart/getShoppingCart")
    public Wrapper<?> getShoppingCart(ShoppingCartRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getShoppingCart 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ShoppingCartRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getShoppingCart 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(requestDto.getId());
            ShoppingCartResponseDto responseDto = convert(shoppingCart);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询购物车数据异常", e);
            return WrapMapper.error();
        }
    } 
    /**
     * 购物车列表数据获取
     * @param request
     * @return
     */
    @POST
    @Path("/shoppingCart/queryShoppingCartList")
    public Wrapper<?> queryShoppingCartList(ShoppingCartRequest request){
    	if (null == request || !request.checkSign()) {
            this.logger.error("queryShoppingCartList 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ShoppingCartRequestDto requestDto = request.getContent();
        if (null == requestDto || StringUtils.isEmpty(requestDto.getUserNo())) {
            this.logger.error("queryShoppingCartList 传入参数有误");
            return WrapMapper.illegalArgument();
        }
        try {
        	ShoppingCartQuery queryBean = new ShoppingCartQuery();
        	queryBean.setUserNo(requestDto.getUserNo());
        	List<ShoppingCart> dataList = shoppingCartService.queryShoppingCartList(queryBean);
        	List<ShoppingCartResponseDto> responseDtoList = convertList(dataList);
        	return WrapMapper.ok().result(responseDtoList);
		} catch (Exception e) {
			this.logger.error("查询购物车数据列表异常", e);
            return WrapMapper.error();
		}
    }
    /**
     * 删除购物车指定商品数据
     * @param request
     * @return
     */
    @POST
    @Path("/shoppingCart/deleteShoppingCart")
    public Wrapper<?> deleteShoppingCart(ShoppingCartRequest request){
    	if (null == request || !request.checkSign()) {
            this.logger.error("deleteShoppingCart 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ShoppingCartRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getSkuNo()) {
            this.logger.error("deleteShoppingCart 传入参数有误");
            return WrapMapper.illegalArgument();
        }
        try {
        	ShoppingCart shoppingCart = new ShoppingCart();
        	shoppingCart.setSkuNo(requestDto.getSkuNo());
        	boolean ret = shoppingCartService.delete(shoppingCart);
        	if(ret){
        		return WrapMapper.ok();
        	}else{
        		return WrapMapper.error();
        	}
		} catch (Exception e) {
			this.logger.error("删除购物车数据异常", e);
            return WrapMapper.error();
		}
    }
    /**
     * 添加购物车
     * @param request
     * @return
     */
    @POST
    @Path("/shoppingCart/addShoppingCart")
    public Wrapper<?> addShoppingCart(ShoppingCartRequest request){
    	if (null == request || !request.checkSign()) {
            this.logger.error("addShoppingCart 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ShoppingCartRequestDto requestDto = request.getContent();
        if (null == requestDto || StringUtils.isEmpty(requestDto.getUserNo())) {
            this.logger.error("addShoppingCart 传入参数有误");
            return WrapMapper.illegalArgument();
        }
        try {
        	ShoppingCart shoppingCart = new ShoppingCart();

        	BeanUtils.copyProperties(requestDto,shoppingCart);
        	boolean ret = shoppingCartService.insert(shoppingCart);
        	if(ret){
        		return WrapMapper.ok();
        	}else{
        		return WrapMapper.error();
        	}
		} catch (Exception e) {
			this.logger.error("添加购物车数据异常", e);
            return WrapMapper.error();
		}
    }
    /**
     * 更新购物车数据
     * @param request
     * @return
     */
    @POST
    @Path("/shoppingCart/updateShoppingCart")
    public Wrapper<?> updateShoppingCart(ShoppingCartRequest request){
    	if (null == request || !request.checkSign()) {
            this.logger.error("updateShoppingCart 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ShoppingCartRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getSkuNo()) {
            this.logger.error("updateShoppingCart 传入参数有误");
            return WrapMapper.illegalArgument();
        }
        try {
        	ShoppingCart shoppingCart = new ShoppingCart();

        	BeanUtils.copyProperties(requestDto,shoppingCart);
        	boolean ret = shoppingCartService.update(shoppingCart);
        	if(ret){
        		return WrapMapper.ok();
        	}else{
        		return WrapMapper.error();
        	}
		} catch (Exception e) {
			this.logger.error("更新购物车数据异常", e);
            return WrapMapper.error();
		}
    }
    
    // 数据转换
    private ShoppingCartResponseDto convert(ShoppingCart shoppingCart) {
        if (null == shoppingCart) {
            return null;
        }

        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        BeanUtils.copyProperties(shoppingCart, shoppingCartResponseDto);
        return shoppingCartResponseDto;
    }

    // 数据转换
    private List<ShoppingCartResponseDto> convertList(List<ShoppingCart> shoppingCarts) {
        if (CollectionUtils.isEmpty(shoppingCarts)) {
            return null;
        }

        List<ShoppingCartResponseDto> list = new ArrayList<ShoppingCartResponseDto>(shoppingCarts.size());
        for (ShoppingCart shoppingCart : shoppingCarts) {
            list.add(convert(shoppingCart));
        }
        return list;
    } 

}
