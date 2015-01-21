package com.awe.mall.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.domain.dto.OrderInfo;
import com.awe.mall.service.OrderInfoService;
import com.awe.mall.service.ProductService;
import com.awe.mall.service.UserAddressService;
import com.awe.mall.utils.OrderCodeUtil;
import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.response.dto.OrderDetailsResponseDto;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.uc.sdk.request.dto.PasswordModifyRequestDto;
import com.awe.uc.sdk.request.dto.UserAddressRequestDto;
import com.awe.uc.sdk.response.dto.UserAddressResponseDto;
import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
/**
 * @description 填写并核对订单信息
 * @author js
 * @date 2014-1-3
 * @version 1.0.0
 */
@Controller
@RequestMapping("orderinfo")
@SuppressWarnings("all")
public class OrderInfoController extends BaseController{
	
	private static final Log LOG = LogFactory.getLog(OrderInfoController.class);
	
	private static final String VIEW_WORKSPACE = "trade/";
	private static final String VIEW_order_info = "orderinfo";
	private static final String VIEW_order_submit = "submit_order";
	
	@Autowired
	private UserAddressService userAddressService;
	@Autowired
	private OrderInfoService orderInfoService;
	
	@RequestMapping(value = "view",method = { RequestMethod.POST, RequestMethod.GET })
	public String view(Model model,String parameters){
		return VIEW_WORKSPACE + VIEW_order_info;
	}
	@RequestMapping(value = "info",method = { RequestMethod.POST, RequestMethod.GET })
	public String orderInfo(Model model,String parameters){
		//parameters = "[{\"skuNo\":\"10000000000001\",\"skuCount\":13},{\"skuNo\":\"10000000000002\",\"skuCount\":2}]";
		//商品总数量
		Integer count = 0;
		//商品总价格
		Double countPrice = 0.0;
		LOG.info("#parameters#" + parameters);
		List<ShoppingCartRequestDto> dataList = JsonHelper.toList(parameters.toString(), ShoppingCartRequestDto.class);
		List<OrderInfo> listOrderInfos = orderInfoService.getOrderInfoBySkuNo(dataList);
		for (OrderInfo orderInfo : listOrderInfos) {
			count += orderInfo.getSkuCount();
			countPrice += orderInfo.getSkuCount() * orderInfo.getSalePrice();
		}
		LOG.info("-- welcome to orderInfo index --");
		//1：根据商品编码查询商品信息
		model.addAttribute("userId", getLoginUserId());
		model.addAttribute("orderInfo",listOrderInfos);
		//数量
		model.addAttribute("count",count);
		//总价
		model.addAttribute("countPrice",countPrice);
		return VIEW_WORKSPACE + VIEW_order_info;
	}

	/**
	 * 生成订单
	 * Date:2015年1月11日下午5:12:05
	 * user:js
	 * @param model
	 * @param requestDto
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="addOrders",method = { RequestMethod.POST, RequestMethod.GET })
    public String addOrders(Model model, OrdersRequestDto requestDto,HttpServletRequest request,String skuName,String skuCount,String skuNo) {
		//商品总价格
		double countPrice = 0.0;
		try {
    	  requestDto.setCreateUser(getLoginUserName());
    	  requestDto.setOrderStatus(40);
    	  //1:插入订单
    	  Wrapper<?>  wrapper = orderInfoService.addOrderDetails(requestDto,skuName,skuNo,skuCount,request.getRemoteAddr());
    	  if(wrapper.getCode() == 200){
    		  Map<String,Double> map=  (Map<String, Double>) wrapper.getResult();
    		  for (String key : map.keySet()) {
    			  countPrice += map.get(key);
    		  }
    		  model.addAttribute("message", "感谢您，订单提交成功");
    		  model.addAttribute("mapResult", map);
    		  model.addAttribute("countPrice", countPrice);
    		  model.addAttribute("code", "200"); 
    	  }else{
    		  model.addAttribute("message", "非常抱歉，提交订单失败");
    		  model.addAttribute("code", "500");
    	  }
    	  return VIEW_WORKSPACE + VIEW_order_submit;
       } catch (Exception e) {
           logger.error("addOrders has error,", e);
           model.addAttribute("message", "非常抱歉，提交订单异常");
           model.addAttribute("code","500");
           return VIEW_WORKSPACE + VIEW_order_submit;
       }
   }
	/**
	  * 加载用户配送地址 
	  * Date:2015年1月4日下午4:30:03
	  * user:js
	  * @param model
	  * @param request
	  * @return
	  */
	 @RequestMapping("address")
	 @ResponseBody
     public Wrapper<?> address(Model model, UserAddressRequestDto requestDto) {
		 List<UserAddressResponseDto> ret = null;
        try {
        	ret = userAddressService.queryUserAddressList(requestDto);
        	if (!CollectionUtils.isEmpty(ret)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, ret);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "没有查询到信息！");
            }
        } catch (Exception e) {
            logger.error("modifyPassword has error,", e);
            return WrapMapper.error();
        }
    }
	 
	 
	 /**
	  * 根据id查询单个地址
	  * Date:2015年1月5日下午1:53:58
	  * user:js
	  * @param model
	  * @param requestDto
	  * @return
	  */
	 @RequestMapping("addr")
	 @ResponseBody
     public Wrapper<?> addr(Model model, UserAddressRequestDto requestDto) {
		 UserAddressResponseDto ret = null;
        try {
        	ret = userAddressService.queryUserAddress(requestDto);
        	if (ret != null) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, ret);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "没有查询到信息！");
            }
        } catch (Exception e) {
            logger.error("modifyPassword has error,", e);
            return WrapMapper.error();
        }
    } 
	 

	 /**
	  * 根据id修改
	  * Date:2015年1月5日下午1:54:19
	  * user:js
	  * @param requestDto
	  * @return
	  */
	 @RequestMapping("updateAdress")
	 @ResponseBody
	 public Wrapper<?> updateAdress(UserAddressRequestDto requestDto) {
			Wrapper<?> wrapper = null;
			try {
				wrapper = userAddressService.update(requestDto);
			} catch (Exception e) {
				LOG.error("#UserAddressServiceImpl.update# Error:" + e);
			}
			return wrapper;
		}
	
	 /**
	  * 添加
	  * Date:2015年1月5日下午1:54:19
	  * user:js
	  * @param requestDto
	  * @return
	  */
	 @RequestMapping("addAddress")
	 @ResponseBody
	 public Wrapper<?> addAddress(UserAddressRequestDto requestDto) {
			Wrapper<?> wrapper = null;
			try {
				wrapper = userAddressService.insert(requestDto);
			} catch (Exception e) {
				LOG.error("#UserAddressServiceImpl.update# Error:" + e);
			}
			return wrapper;
		}
	 
	 /**
	  * 删除地址
	  * Date:2015年1月5日下午1:54:19
	  * user:js
	  * @param requestDto
	  * @return
	  */
	 @RequestMapping("deleteAddress")
	 @ResponseBody
	 public Wrapper<?> deleteAddress(UserAddressRequestDto requestDto) {
			Wrapper<?> wrapper = null;
			try {
				wrapper = userAddressService.delete(requestDto);
			} catch (Exception e) {
				LOG.error("#UserAddressServiceImpl.update# Error:" + e);
			}
			return wrapper;
		}
	
	
}
