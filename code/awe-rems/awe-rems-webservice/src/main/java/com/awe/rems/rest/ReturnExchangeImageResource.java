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

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.awe.rems.domain.ReturnExchangeImage;
import com.awe.rems.sdk.api.request.ReturnExchangeImageRequest;
import com.awe.rems.sdk.api.request.dto.ReturnExchangeImageRequestDto;
import com.awe.rems.sdk.api.response.dto.ReturnExchangeImageResponseDto;
import com.awe.rems.service.ReturnExchangeImageService;

/**
 * 退换货图片表REST服务：提供有关退换货图片表的接口
 * 
 * @author zyq
 * @version 2014-12-25 9:16:23
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ReturnExchangeImageResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ReturnExchangeImageService returnExchangeImageService; 

    /**
     * 查询退换货图片表信息
     * 
     * @param request
     *            退换货图片表请求参数
     * @return 退换货图片表返回对象
     * 
     */
    @POST
    @Path("/returnExchangeImage/getReturnExchangeImage")
    public Wrapper<?> getReturnExchangeImage(ReturnExchangeImageRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getReturnExchangeImage 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ReturnExchangeImageRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getReturnExchangeImage 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ReturnExchangeImage returnExchangeImage = returnExchangeImageService.getReturnExchangeImageById(requestDto.getId());
            ReturnExchangeImageResponseDto responseDto = convert(returnExchangeImage);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询退换货图片表数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ReturnExchangeImageResponseDto convert(ReturnExchangeImage returnExchangeImage) {
        if (null == returnExchangeImage) {
            return null;
        }

        ReturnExchangeImageResponseDto returnExchangeImageResponseDto = new ReturnExchangeImageResponseDto();
        BeanUtils.copyProperties(returnExchangeImage, returnExchangeImageResponseDto);
        return returnExchangeImageResponseDto;
    }

    // 数据转换
    private List<ReturnExchangeImageResponseDto> convertList(List<ReturnExchangeImage> returnExchangeImages) {
        if (CollectionUtils.isEmpty(returnExchangeImages)) {
            return null;
        }

        List<ReturnExchangeImageResponseDto> list = new ArrayList<ReturnExchangeImageResponseDto>(returnExchangeImages.size());
        for (ReturnExchangeImage returnExchangeImage : returnExchangeImages) {
            list.add(convert(returnExchangeImage));
        }
        return list;
    } 

}
