package com.awe.uc.rest;

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
import com.awe.uc.domain.UserAddress;
import com.awe.uc.sdk.api.request.UserAddressRequest;
import com.awe.uc.sdk.api.request.dto.UserAddressRequestDto;
import com.awe.uc.sdk.api.response.dto.UserAddressResponseDto;
import com.awe.uc.service.UserAddressService;

/**
 * 收货地址REST服务：提供有关收货地址的接口
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserAddressResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserAddressService userAddressService; 

    /**
     * 查询收货地址信息
     * 
     * @param request
     *            收货地址请求参数
     * @return 收货地址返回对象
     * 
     */
    @POST
    @Path("/userAddress/getUserAddress")
    public Wrapper<?> getUserAddress(UserAddressRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getUserAddress 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        UserAddressRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getUserAddress 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserAddress userAddress = userAddressService.getUserAddressById(requestDto.getId());
            UserAddressResponseDto responseDto = convert(userAddress);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询收货地址数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private UserAddressResponseDto convert(UserAddress userAddress) {
        if (null == userAddress) {
            return null;
        }

        UserAddressResponseDto userAddressResponseDto = new UserAddressResponseDto();
        BeanUtils.copyProperties(userAddress, userAddressResponseDto);
        return userAddressResponseDto;
    }

    // 数据转换
    private List<UserAddressResponseDto> convertList(List<UserAddress> userAddresss) {
        if (CollectionUtils.isEmpty(userAddresss)) {
            return null;
        }

        List<UserAddressResponseDto> list = new ArrayList<UserAddressResponseDto>(userAddresss.size());
        for (UserAddress userAddress : userAddresss) {
            list.add(convert(userAddress));
        }
        return list;
    } 

}
