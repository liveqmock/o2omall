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
import com.awe.uc.domain.UserCommonly;
import com.awe.uc.sdk.api.request.UserCommonlyRequest;
import com.awe.uc.sdk.api.response.UserCommonlyResponse;
import com.awe.uc.service.UserCommonlyService;

/**
 * 用户-常用信息REST服务：提供有关用户-常用信息的接口
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:54
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserCommonlyResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserCommonlyService userCommonlyService; 

    /**
     * 查询用户-常用信息信息
     * 
     * @param request
     *            用户-常用信息请求参数
     * @return 用户-常用信息返回对象
     * 
     */
    @POST
    @Path("/userCommonly/getUserCommonly")
    public Wrapper<?> getUserCommonly(UserCommonlyRequest request) {
        if (null == request || null == request.getId()) {
            this.logger.error("getUserCommonly 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserCommonly userCommonly = userCommonlyService.getUserCommonlyById(request.getId());
            UserCommonlyResponse response = convert(userCommonly);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询用户-常用信息数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private UserCommonlyResponse convert(UserCommonly userCommonly) {
        if (null == userCommonly) {
            return null;
        }

        UserCommonlyResponse userCommonlyResponse = new UserCommonlyResponse();
        BeanUtils.copyProperties(userCommonly, userCommonlyResponse);
        return userCommonlyResponse;
    }

    // 数据转换
    private List<UserCommonlyResponse> convertList(List<UserCommonly> userCommonlys) {
        if (CollectionUtils.isEmpty(userCommonlys)) {
            return null;
        }

        List<UserCommonlyResponse> list = new ArrayList<UserCommonlyResponse>(userCommonlys.size());
        for (UserCommonly userCommonly : userCommonlys) {
            list.add(convert(userCommonly));
        }
        return list;
    } 

}
