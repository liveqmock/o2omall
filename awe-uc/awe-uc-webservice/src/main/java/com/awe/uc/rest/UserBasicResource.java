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
import com.awe.uc.domain.UserBasic;
import com.awe.uc.sdk.api.request.UserBasicRequest;
import com.awe.uc.sdk.api.response.UserBasicResponse;
import com.awe.uc.service.UserBasicService;

/**
 * 用户基本信息REST服务：提供有关用户基本信息的接口
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:54
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserBasicResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserBasicService userBasicService; 

    /**
     * 查询用户基本信息信息
     * 
     * @param request
     *            用户基本信息请求参数
     * @return 用户基本信息返回对象
     * 
     */
    @POST
    @Path("/userBasic/getUserBasic")
    public Wrapper<?> getUserBasic(UserBasicRequest request) {
        if (null == request || null == request.getId()) {
            this.logger.error("getUserBasic 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserBasic userBasic = userBasicService.getUserBasicById(request.getId());
            UserBasicResponse response = convert(userBasic);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询用户基本信息数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private UserBasicResponse convert(UserBasic userBasic) {
        if (null == userBasic) {
            return null;
        }

        UserBasicResponse userBasicResponse = new UserBasicResponse();
        BeanUtils.copyProperties(userBasic, userBasicResponse);
        return userBasicResponse;
    }

    // 数据转换
    private List<UserBasicResponse> convertList(List<UserBasic> userBasics) {
        if (CollectionUtils.isEmpty(userBasics)) {
            return null;
        }

        List<UserBasicResponse> list = new ArrayList<UserBasicResponse>(userBasics.size());
        for (UserBasic userBasic : userBasics) {
            list.add(convert(userBasic));
        }
        return list;
    } 

}
