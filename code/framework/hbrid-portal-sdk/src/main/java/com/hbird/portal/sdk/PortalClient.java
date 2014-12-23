package com.hbird.portal.sdk;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.portal.sdk.dto.Role;
import com.hbird.portal.sdk.dto.User;
import com.hbird.portal.sdk.request.UserRequest;
import com.hbird.portal.sdk.response.RoleResponse;
import com.hbird.portal.sdk.response.UserPageListResponse;
import com.hbird.portal.sdk.response.UserResponse;

/**
 * Portal客户端，调用portal提供的rest服务。<br />
 * 主要提供如下接口： <br />
 * <li>用户查询</li> <li>角色查询</li><br />
 * 支持设置连接超时时间和读超时时间
 * 
 * @see com.hbird.common.client.AbstractClient#setConnectTimeout(int)
 * @see com.hbird.common.client.AbstractClient#setReadTimeout(int)
 * 
 * @author ljz
 * @version 2014-8-1 11:11:47
 * 
 */
public class PortalClient extends AbstractClient {

    /**
     * 依据ID或账号查询用户信息
     * 
     * @param user
     * @return
     */
    public User getUser(User user) {
        if (null != user) {
            String url = getServiceUrlDomain() + "services/user/getUser";
            UserRequest request = toUserRequest(user);
            UserResponse response = getRestTemplate().postForObject(url, request, UserResponse.class);
            return getResult(response);
        }
        return null;
    }

    /**
     * 依据账号模糊查询用户信息的集合
     * 
     * @param user
     * @param pageUtil
     * @return
     */
    public List<User> getUserListByName(User user, PageUtil pageUtil) {
        if (null != user) {
            if (null == pageUtil) {
                pageUtil = new PageUtil();
            }
            String url = getServiceUrlDomain() + "services/user/getUserListByName";
            UserRequest request = toUserRequest(user);
            request.setPageUtil(pageUtil);
            UserPageListResponse response = getRestTemplate().postForObject(url, request, UserPageListResponse.class);
            PageUtil pageUtil2 = getPageUtil(response);
            if (null != pageUtil2) {
                pageUtil.setTotalRow(pageUtil2.getTotalRow());
                pageUtil.init();
            }
            return getResult(response);
        }
        return null;
    }

    /**
     * 依据用户ID查询用户所拥有的角色信息（角色名称）
     * 
     * @param user
     * @return 角色信息集合
     */
    public List<Role> getUserRoleList(User user) {
        if (null != user) {
            String url = getServiceUrlDomain() + "services/role/getUserRoleList";

            UserRequest request = toUserRequest(user);
            RoleResponse response = getRestTemplate().postForObject(url, request, RoleResponse.class);
            return getResult(response);
        }
        return null;
    }

    /**
     * 数据转换
     * 
     * @param user
     * @return
     */
    private UserRequest toUserRequest(User user) {
        UserRequest request = new UserRequest();
        BeanUtils.copyProperties(user, request);
        return request;
    }
}
