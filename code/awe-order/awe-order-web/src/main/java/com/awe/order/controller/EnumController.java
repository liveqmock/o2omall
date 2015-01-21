package com.awe.order.controller;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.order.controller.base.BaseController;
import com.awe.order.enums.EnumInvoiceType;
import com.awe.order.enums.EnumOrderCancelStatus;
import com.awe.order.enums.EnumOrderStauts;
import com.awe.order.enums.EnumOrderType;
import com.awe.order.enums.EnumPayType;
import com.awe.order.enums.EnumPayWay;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 
 *EnumController	
 *
 * @author js
 * @version：2014年12月31日 上午11:20:26
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("enums")
public class EnumController extends BaseController{
	
    private static final Log LOG = LogFactory.getLog(EnumController.class);
    
    /**
     * 订单状态
     * Date:2014年12月31日下午2:08:52
     * user:js
     * @return
     */
	@RequestMapping(value = "queryOrderStauts")
	@ResponseBody
	public Wrapper<?> queryOrderStauts(){
		try {
			Map<String, String> map = (Map<String, String>) EnumOrderStauts.MapEnum();
			if (!CollectionUtils.isEmpty(map)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, map);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
		} catch (Exception e) {
			 LOG.error("Enum queryOrderStauts has error.", e);
	         return WrapMapper.error();
		}
	}
	
	/**
	 * 订单类型
	 * Date:2014年12月31日下午4:30:21
	 * user:js
	 * @return
	 */
	@RequestMapping(value = "queryOrderType")
	@ResponseBody
	public Wrapper<?> queryOrderType(){
		try {
			Map<String, String> map = (Map<String, String>) EnumOrderType.MapEnum();
			if (!CollectionUtils.isEmpty(map)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, map);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
		} catch (Exception e) {
			 LOG.error("Enum queryOrderStauts has error.", e);
	         return WrapMapper.error();
		}
	}
	
	/**
	 * 支付类型
	 * Date:2014年12月31日下午3:40:02
	 * user:js
	 * @return
	 */
	@RequestMapping(value = "queryPayType")
	@ResponseBody
	public Wrapper<?> queryPayType(){
		try {
			Map<String, String> map = (Map<String, String>) EnumPayType.MapEnum();
			if (!CollectionUtils.isEmpty(map)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, map);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
		} catch (Exception e) {
			 LOG.error("Enum queryOrderStauts has error.", e);
	         return WrapMapper.error();
		}
	}
	
	
	/**
	 * 支付方式
	 * Date:2014年12月31日下午3:40:02
	 * user:js
	 * @return
	 */
	@RequestMapping(value = "queryPayWay")
	@ResponseBody
	public Wrapper<?> queryPayWay(){
		try {
			Map<String, String> map = (Map<String, String>) EnumPayWay.MapEnum();
			if (!CollectionUtils.isEmpty(map)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, map);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
		} catch (Exception e) {
			 LOG.error("Enum queryOrderStauts has error.", e);
	         return WrapMapper.error();
		}
	}
	
	/**
	 * 发票类型
	 * Date:2014年12月31日下午3:58:39
	 * user:js
	 * @return
	 */
	@RequestMapping(value = "queryInvoiceType")
	@ResponseBody
	public Wrapper<?> queryInvoiceType(){
		try {
			Map<String, String> map = (Map<String, String>) EnumInvoiceType.MapEnum();
			if (!CollectionUtils.isEmpty(map)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, map);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
		} catch (Exception e) {
			 LOG.error("Enum queryOrderStauts has error.", e);
	         return WrapMapper.error();
		}
	}
	
	/**
	 * 发票类型
	 * Date:2014年12月31日下午3:58:39
	 * user:js
	 * @return
	 */
	@RequestMapping(value = "queryCanSta")
	@ResponseBody
	public Wrapper<?> queryCanSta(){
		try {
			Map<String, String> map = (Map<String, String>) EnumOrderCancelStatus.MapEnum();
			if (!CollectionUtils.isEmpty(map)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, map);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
		} catch (Exception e) {
			 LOG.error("Enum queryOrderStauts has error.", e);
	         return WrapMapper.error();
		}
	}
	
	
}
