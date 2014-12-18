package com.hbird.portal.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.portal.sdk.dto.ButtonResourceResponse;
import com.hbird.portal.sdk.request.PermissionCheckRequest;
import com.hbird.portal.sdk.request.PermissionQueryRequest;
import com.hbird.portal.sdk.response.ButtonResourceDto;
import com.hbird.portal.sdk.response.PermissionCheckResponse;
import com.hbird.portal.sdk.response.PermissionQueryResponse;

/**
 * * Portal客户端，调用portal提供的rest服务。<br />
 * 主要提供如下接口： <br />
 * <li>权限验证</li> <li>权限查询</li><br />
 * 支持设置连接超时时间和读超时时间
 * 
 * @see com.hbird.common.client.AbstractClient#setConnectTimeout(int)
 * @see com.hbird.common.client.AbstractClient#setReadTimeout(int)
 * @author ljz
 * @version 2014-11-21 上午10:50:20
 */
public class PermissionClient extends AbstractClient {

    private static final Log LOG = LogFactory.getLog(PermissionClient.class);

    /**
     * 验证用户是否拥有某个资源的访问权限
     * 
     * @param userId
     *            用户ID
     * @param resourceCode
     *            资源码
     * @return
     */
    public boolean isPermitted(PermissionCheckRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.warn("isPermitted request：" + JsonHelper.toJson(request));
        }

        String url = getServiceUrlDomain() + "services/permission/isPermitted";
        PermissionCheckResponse response = getRestTemplate().postForObject(url, request, PermissionCheckResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("isPermitted url: " + url);
            LOG.debug("isPermitted response: " + JsonHelper.toJson(response));
        }

        return super.isSuccess(response);
    }

    /**
     * 根据用户ID和父资源码获取其有权限子资源列表
     * 
     * @param userId
     *            用户ID
     * @param parentResourceCode
     *            父资源码
     * @return
     */
    public List<String> getPermissionByParentCode(PermissionQueryRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.warn("isPermitted request：" + JsonHelper.toJson(request));
        }

        String url = getServiceUrlDomain() + "services/permission/getPermissionByParentCode";
        PermissionQueryResponse response = getRestTemplate().postForObject(url, request, PermissionQueryResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getPermissionByParentCode url: " + url);
            LOG.debug("getPermissionByParentCode response: " + JsonHelper.toJson(response));
        }

        return getResult(response);
    }

    /**
     * 根据用户ID和父资源码获取其有权限子资源列表
     * 
     * @param userId
     *            用户ID
     * @param parentResourceCode
     *            父资源码
     * @return
     */
    public List<ButtonResourceDto> buttonResource(PermissionCheckRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.warn("buttonResource request：" + JsonHelper.toJson(request));
        }

        String url = getServiceUrlDomain() + "services/permission/buttonResource";
        ButtonResourceResponse response = getRestTemplate().postForObject(url, request, ButtonResourceResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("buttonResource url: " + url);
            LOG.debug("buttonResource response: " + JsonHelper.toJson(response));
        }

        return getResult(response);
    }
}
