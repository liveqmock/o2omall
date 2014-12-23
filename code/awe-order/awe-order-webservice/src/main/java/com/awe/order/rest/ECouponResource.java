package com.awe.order.rest;

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

import com.awe.order.domain.ECoupon;
import com.awe.order.sdk.api.request.ECouponRequest;
import com.awe.order.sdk.api.request.dto.ECouponRequestDto;
import com.awe.order.sdk.api.response.dto.ECouponResponseDto;
import com.awe.order.service.ECouponService;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 电子券REST服务：提供有关电子券的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:37
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ECouponResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ECouponService eCouponService; 

    /**
     * 查询电子券信息
     * 
     * @param request
     *            电子券请求参数
     * @return 电子券返回对象
     * 
     */
    @POST
    @Path("/eCoupon/getECoupon")
    public Wrapper<?> getECoupon(ECouponRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getECoupon 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ECouponRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getECoupon 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ECoupon eCoupon = eCouponService.getECouponById(requestDto.getId());
            ECouponResponseDto responseDto = convert(eCoupon);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询电子券数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ECouponResponseDto convert(ECoupon eCoupon) {
        if (null == eCoupon) {
            return null;
        }

        ECouponResponseDto eCouponResponseDto = new ECouponResponseDto();
        BeanUtils.copyProperties(eCoupon, eCouponResponseDto);
        return eCouponResponseDto;
    }

    // 数据转换
    private List<ECouponResponseDto> convertList(List<ECoupon> eCoupons) {
        if (CollectionUtils.isEmpty(eCoupons)) {
            return null;
        }

        List<ECouponResponseDto> list = new ArrayList<ECouponResponseDto>(eCoupons.size());
        for (ECoupon eCoupon : eCoupons) {
            list.add(convert(eCoupon));
        }
        return list;
    } 

}
