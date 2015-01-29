package com.awe.mall.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.ProductService;
import com.awe.mall.service.ShoppingCartService;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.response.dto.ShoppingCartResponseDto;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.dto.ProductResponseDto;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.hbird.common.web.context.UserContext;
/**
 * 购物车控制器
 * @author zyq
 * @version 1.0.0.0
 * @since 2015-1-6
 */
@Controller
@RequestMapping("cart")
public class ShoppingCartController extends BaseController{

	private static final Log LOG = LogFactory.getLog(ShoppingCartController.class);
	private static final String VIEW_ADD_CART_SUCCESS = "cart/addCartSuccess";
	private static final String VIEW_LIST_CART = "cart/myCart";
	
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private ProductService productService;
	/**
	 * 添加购物车
	 * @param model
	 * @param skuNo
	 * @param skuCount
	 * @return
	 */
	@RequestMapping(value = "addCart", method = {RequestMethod.POST, RequestMethod.GET})
	public String addCart(Model model,String skuNo,String skuCount){
		if(StringUtils.isEmpty(skuNo) || StringUtils.isEmpty(skuCount)){
			return "";//转到异常页面
		}
		try {
			ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
			requestDto.setSkuNo(skuNo);
			requestDto.setSkuCount(Integer.valueOf(skuCount));
			requestDto.setStatus(1);
			requestDto.setUserId(getLoginUserId());
			requestDto.setCreateUser(UserContext.get().getCnName());
			requestDto.setUpdateUser(UserContext.get().getCnName());
			Wrapper<?> wrapper = shoppingCartService.addShoppingCart(requestDto);
			
			//以下字段携带到添加购物车成功页面，用于继续购物按钮使用
			ProductSkuRequestDto productSkuRequestDto = new ProductSkuRequestDto();
			productSkuRequestDto.setSkuNo(skuNo);
			ProductResponseDto productResponseDto = productService.getProductBySkuNo(productSkuRequestDto);
			model.addAttribute("skuNo", skuNo);
			model.addAttribute("productNo", productResponseDto.getProductNo());
			
			if(wrapper.isSuccess()){
				return VIEW_ADD_CART_SUCCESS;
			}else{
				return "";//转到异常页面
			}
		} catch (Exception e) {
			LOG.error("#ShoppingCartController.addCart# Error:" + e);
			return "";//转到异常页面
		}
	}
	/**
	 * 我的购物车列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "listCart", method = {RequestMethod.POST, RequestMethod.GET})
	public String listCart(Model model){
		try {
			ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
			requestDto.setUserId(getLoginUserId());
			//调用商品接口查出其它字段
			List<ShoppingCartResponseDto> responseDtoList = shoppingCartService.queryShoppingCartList(requestDto);
			model.addAttribute("dataList", responseDtoList);
			return VIEW_LIST_CART;
		} catch (Exception e) {
			LOG.error("#ShoppingCartController.listCart# Error:" + e);
			return "";//转到异常页面
		}
	}
	/**
	 * 删除购物车中商品
	 * @param model
	 * @param skuNo
	 * @return
	 */
	@RequestMapping(value = "deleteCart", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Wrapper<?> deleteCart(Model model,String skuNo){
		if(StringUtils.isEmpty(skuNo)){
			return WrapMapper.error();
		}
		try {
			ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
			requestDto.setSkuNo(skuNo);
			Wrapper<?> wrapper = shoppingCartService.deleteShoppingCart(requestDto);
			if (null != wrapper) {
				return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
            	LOG.error("deleteCart fail.");
            	return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
		} catch (Exception e) {
			LOG.error("#ShoppingCartController.deleteCart# Error:" + e);
			return WrapMapper.error();
		}
	}
	/**
	 * 购物车列表中增加或减少商品数据量
	 * @param model
	 * @param shoppingCartId
	 * @param skuCount
	 * @return
	 */
	@RequestMapping(value = "updateCart", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Wrapper<?> updateCart(Model model,ShoppingCartRequestDto requestDto){
		if(null == requestDto){
			return WrapMapper.illegalArgument();
		}
		if(StringUtils.isEmpty(requestDto.getSkuNo()) || requestDto.getSkuCount()==0){
			return WrapMapper.illegalArgument();
		}
		Wrapper<?> wrapper = null;
		try {
			wrapper = shoppingCartService.updateShoppingCart(requestDto);
			if (null != wrapper) {
				return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
            	LOG.error("updateCart fail.");
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
		} catch (Exception e) {
			LOG.error("#ShoppingCartController.updateCart# Error:" + e);
			return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新异常！");
		}
	}
	
}
