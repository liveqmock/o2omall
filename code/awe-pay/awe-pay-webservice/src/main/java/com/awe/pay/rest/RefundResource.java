package com.awe.pay.rest;

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
import com.awe.pay.domain.Refund;
import com.awe.pay.sdk.api.request.RefundRequest;
import com.awe.pay.sdk.api.request.dto.RefundRequestDto;
import com.awe.pay.sdk.api.response.dto.RefundResponseDto;
import com.awe.pay.service.RefundService;

/**
 * 逆向退款REST服务：提供有关逆向退款的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RefundResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private RefundService refundService; 

    /**
     * 查询逆向退款信息
     * 
     * @param request
     *            逆向退款请求参数
     * @return 逆向退款返回对象
     * 
     */
    @POST
    @Path("/refund/getRefund")
    public Wrapper<?> getRefund(RefundRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getRefund 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        RefundRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getRefund 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            Refund refund = refundService.getRefundById(requestDto.getId());
            RefundResponseDto responseDto = convert(refund);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询逆向退款数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private RefundResponseDto convert(Refund refund) {
        if (null == refund) {
            return null;
        }

        RefundResponseDto refundResponseDto = new RefundResponseDto();
        BeanUtils.copyProperties(refund, refundResponseDto);
        return refundResponseDto;
    }

    // 数据转换
    private List<RefundResponseDto> convertList(List<Refund> refunds) {
        if (CollectionUtils.isEmpty(refunds)) {
            return null;
        }

        List<RefundResponseDto> list = new ArrayList<RefundResponseDto>(refunds.size());
        for (Refund refund : refunds) {
            list.add(convert(refund));
        }
        return list;
    } 

}
