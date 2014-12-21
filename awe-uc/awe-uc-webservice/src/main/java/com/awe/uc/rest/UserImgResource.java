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
import com.awe.uc.domain.UserImg;
import com.awe.uc.sdk.api.request.UserImgRequest;
import com.awe.uc.sdk.api.response.UserImgResponse;
import com.awe.uc.service.UserImgService;

/**
 * 用户关联图片REST服务：提供有关用户关联图片的接口
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:54
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserImgResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserImgService userImgService; 

    /**
     * 查询用户关联图片信息
     * 
     * @param request
     *            用户关联图片请求参数
     * @return 用户关联图片返回对象
     * 
     */
    @POST
    @Path("/userImg/getUserImg")
    public Wrapper<?> getUserImg(UserImgRequest request) {
        if (null == request || null == request.getId()) {
            this.logger.error("getUserImg 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserImg userImg = userImgService.getUserImgById(request.getId());
            UserImgResponse response = convert(userImg);
            return WrapMapper.ok().result(response);
        } catch (Exception e) {
            this.logger.error("查询用户关联图片数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private UserImgResponse convert(UserImg userImg) {
        if (null == userImg) {
            return null;
        }

        UserImgResponse userImgResponse = new UserImgResponse();
        BeanUtils.copyProperties(userImg, userImgResponse);
        return userImgResponse;
    }

    // 数据转换
    private List<UserImgResponse> convertList(List<UserImg> userImgs) {
        if (CollectionUtils.isEmpty(userImgs)) {
            return null;
        }

        List<UserImgResponse> list = new ArrayList<UserImgResponse>(userImgs.size());
        for (UserImg userImg : userImgs) {
            list.add(convert(userImg));
        }
        return list;
    } 

}
