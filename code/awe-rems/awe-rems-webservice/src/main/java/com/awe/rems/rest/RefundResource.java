package com.awe.rems.rest;

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

import com.awe.rems.domain.Refund;
import com.awe.rems.domain.query.RefundQuery;
import com.awe.rems.sdk.api.request.RefundRequest;
import com.awe.rems.sdk.api.request.dto.RefundRequestDto;
import com.awe.rems.sdk.api.response.dto.RefundResponseDto;
import com.awe.rems.service.RefundService;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.PageWrapMapper;
import com.hbird.common.utils.wrap.PageWrapper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 退款表REST服务：提供有关退款表的接口
 * 
 * @author zyq
 * @version 2014-12-25 9:16:23
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
     * 查询退款表信息
     * 
     * @param request
     *            退款表请求参数
     * @return 退款表返回对象
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
            this.logger.error("查询退款表数据异常", e);
            return WrapMapper.error();
        }
    } 
    /**
     * 查询退款列表
     * @param request
     * @return
     */
    @POST
    @Path("/refund/queryRefundListWithPage")
    public PageWrapper<?> queryRefundListWithPage(RefundRequest request){
    	if (null == request || !request.checkSign()) {
            this.logger.error("queryRefundListWithPage 拒绝访问");
            return PageWrapMapper.error();
        }
        
        RefundRequestDto requestDto = request.getContent();
        PageUtil pageUtil = request.getPageUtil();
        if (null == requestDto || null == requestDto.getServiceNo()) {
            this.logger.error("queryRefundListWithPage 传入参数有误");
            return PageWrapMapper.illegalArgument();
        }

        try {
        	RefundQuery queryBean = new RefundQuery();
        	queryBean.setOrderNo(requestDto.getOrderNo());
        	queryBean.setServiceNo(requestDto.getServiceNo());
        	List<Refund> dataList = refundService.queryRefundListWithPage(queryBean, pageUtil);
            List<RefundResponseDto> responseDtoList = convertList(dataList);
            return PageWrapMapper.ok().result(responseDtoList).pageUtil(pageUtil);
        } catch (Exception e) {
            this.logger.error("查询退款表数据异常", e);
            return PageWrapMapper.error();
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
