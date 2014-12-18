package com.hbird.portal.rest;

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

import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.common.utils.wrap.PageWrapMapper;
import com.hbird.common.utils.wrap.PageWrapper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.UserRole;
import com.hbird.portal.domain.constant.CommonConstants;
import com.hbird.portal.domain.query.UserQuery;
import com.hbird.portal.domain.query.UserRoleQuery;
import com.hbird.portal.sdk.api.request.UserRequest;
import com.hbird.portal.sdk.api.response.dto.UserDto;
import com.hbird.portal.service.UserRoleService;
import com.hbird.portal.service.UserService;

/**
 * 用户REST服务：提供用户查询的接口
 * 
 * @author ljz
 */
@Component
@Path(CommonConstants.REST_URL)
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 依据账号或ID查询用户信息（ID,账号，中文姓名，邮箱）
     * 
     * @param request
     *            查询参数
     * @return
     */
    @POST
    @Path("/user/getUser")
    public Wrapper<UserDto> getUser(UserRequest request) {
        if (null == request || (null == request.getId() && null == request.getName())) {
            this.logger.error("getUser 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        User user = null;
        try {
            if (null != request.getId()) {
                user = userService.getUserById(request.getId());
            } else {
                user = userService.getUserByName(request.getName());
            }

            UserDto response = convert(user);
            return new Wrapper<UserDto>().result(response);
        } catch (Exception e) {
            this.logger.error("查询用户数据异常", e);
            return WrapMapper.error();
        }
    }

    /**
     * 依据账号模糊查询用户信息的集合。用户信息包括ID,账号，中文姓名，邮箱。
     * 
     * @param request
     *            查询参数
     * @return
     */
    @POST
    @Path("/user/getUserListByName")
    public PageWrapper<?> getUserListByName(UserRequest request) {
        if (null == request || (null == request.getName() && null == request.getCnName())) {
            this.logger.error("getUserListByName 传入参数有误");
            return PageWrapMapper.illegalArgument();
        }
        PageUtil pageUtil = request.getPageUtil();
        if (null == pageUtil) {
            pageUtil = new PageUtil();
        }

        UserQuery queryBean = new UserQuery();
        queryBean.setName(request.getName());
        queryBean.setCnName(request.getCnName());

        try {
            PaginatedArrayList<User> paginatedArrayList = userService.queryUserListWithPage(queryBean,
                    pageUtil.getCurPage(), pageUtil.getPageSize());
            if (null != paginatedArrayList) {
                List<User> users = paginatedArrayList.getRows();
                List<UserDto> list = convertList(users);
                pageUtil.setTotalRow(paginatedArrayList.getTotalItem());
                pageUtil.init();
                return PageWrapMapper.wrap(list, pageUtil);
            } else {
                return PageWrapMapper.ok();
            }
        } catch (Exception e) {
            this.logger.error("查询用户数据异常", e);
            return PageWrapMapper.error();
        }
    }

    /**
     * 依据角色编码查询拥有该角色的用户信息（账号、邮箱、中文名、联系方式）
     * 
     * @param request
     *            (角色Id) 查询参数
     * @return
     */
    @POST
    @Path("/user/getUserListByRoleId")
    @Produces("application/json;charset=utf-8")
    public Wrapper<List<UserDto>> getUserListByRoleId(UserRequest request) {
        if (null == request || null == request.getId()) {
            this.logger.error("getUserListByRoleId 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        UserRoleQuery queryBean = new UserRoleQuery();
        queryBean.setRoleId(request.getId());
        try {
            List<UserRole> userRoles = userRoleService.queryUserRoleList(queryBean);

            List<UserDto> list = convertListUser(userRoles);
            return new Wrapper<List<UserDto>>().result(list);
        } catch (Exception e) {
            this.logger.error("查询用户数据异常", e);
            return WrapMapper.error();
        }
    }

    // 数据转换,同时查询用户对应的部门名称
    private UserDto convert(User user) {
        if (null == user) {
            return null;
        }

        UserDto userResponse = new UserDto();
        BeanUtils.copyProperties(user, userResponse);

        if (null != user.getDep()) {
            userResponse.setDepName(user.getDep().getName());
        }
        return userResponse;
    }

    // 数据转换
    private List<UserDto> convertList(List<User> users) {
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>(users.size());
        for (User user : users) {
            list.add(convert(user));
        }
        return list;
    }

    // 转换数据 查询用户信息
    private List<UserDto> convertListUser(List<UserRole> ueserRoles) {
        List<UserDto> list = new ArrayList<UserDto>();
        for (UserRole obj : ueserRoles) {
            User user = userService.getUserById(obj.getUserId());
            if (null != user) {
                list.add(convert(user));
            }
        }
        return list;
    }

}
