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
import com.awe.uc.domain.UserAccount;
import com.awe.uc.sdk.api.request.UserAccountRequest;
import com.awe.uc.sdk.api.request.dto.UserAccountRequestDto;
import com.awe.uc.sdk.api.response.dto.UserAccountResponseDto;
import com.awe.uc.service.UserAccountService;

/**
 * 用户账号REST服务：提供有关用户账号的接口
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserAccountResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserAccountService userAccountService; 

    /**
     * 查询用户账号信息
     * 
     * @param request
     *            用户账号请求参数
     * @return 用户账号返回对象
     * 
     */
    @POST
    @Path("/userAccount/getUserAccount")
    public Wrapper<?> getUserAccount(UserAccountRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getUserAccount 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        UserAccountRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getUserAccount 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserAccount userAccount = userAccountService.getUserAccountById(requestDto.getId());
            UserAccountResponseDto responseDto = convert(userAccount);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询用户账号数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private UserAccountResponseDto convert(UserAccount userAccount) {
        if (null == userAccount) {
            return null;
        }

        UserAccountResponseDto userAccountResponseDto = new UserAccountResponseDto();
        BeanUtils.copyProperties(userAccount, userAccountResponseDto);
        return userAccountResponseDto;
    }

    // 数据转换
    private List<UserAccountResponseDto> convertList(List<UserAccount> userAccounts) {
        if (CollectionUtils.isEmpty(userAccounts)) {
            return null;
        }

        List<UserAccountResponseDto> list = new ArrayList<UserAccountResponseDto>(userAccounts.size());
        for (UserAccount userAccount : userAccounts) {
            list.add(convert(userAccount));
        }
        return list;
    } 

}
