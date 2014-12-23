package com.hbird.portal.clients.sso;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.MapUtils;

import com.hbird.common.utils.security.MD5Util;
import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.portal.clients.sso.response.BaseSsoResponse;
import com.hbird.portal.clients.sso.response.TransCodeResponse;
import com.hbird.portal.clients.sso.response.UserQueryResponse;
import com.hbird.portal.clients.sso.response.UserResponse;

/**
 * 单点登录服务客户端
 * 
 * @author ljz
 * 
 */
public class SsoUserClient extends AbstractSsoClient {

    private static final String SUCCESS_STATUS = "1";
    private static final String ENCODE = "ENCODE";
    private static final String DECODE = "DECODE";

    /**
     * 账号密码验证
     * 
     * @param name
     * @param password
     * @return
     */
    public boolean checkUser(String name, String password) {
        String url = super.getServiceUrlDomain() + "check_user.php";

        TreeMap<String, String> urlVariableMap = new TreeMap<String, String>();
        urlVariableMap.put("username", name);
        urlVariableMap.put("password", this.encode(password));
        urlVariableMap.put("site", this.getSite());
        urlVariableMap.put("time", this.getTimestamp());

        UserResponse response = this.getForEntity(url, UserResponse.class, urlVariableMap);
        return isSuccess(response);
    }

    /**
     * 依据账号查询详细信息
     * 
     * @param username
     * @return
     */
    public Map<String, Object> queryUser(String username) {
        String url = super.getServiceUrlDomain() + "user.php";

        TreeMap<String, String> urlVariableMap = new TreeMap<String, String>();
        urlVariableMap.put("username", username);
        urlVariableMap.put("site", this.getSite());
        urlVariableMap.put("time", this.getTimestamp());

        UserQueryResponse response = this.getForEntity(url, UserQueryResponse.class, urlVariableMap);
        if (isSuccess(response)) {
            return response.getObjects();
        }
        return null;
    }

    /**
     * 加密
     * 
     * @param value
     * @return
     */
    public String encode(String value) {
        return this.transcode(ENCODE, urlEncode(value));
    }

    /**
     * 解密
     * 
     * @param value
     * @return
     */
    public String decode(String value) {
        return this.transcode(DECODE, value);
    }

    /**
     * 调用单点登录系统进行加密解密
     * 
     * @param type
     * @param value
     * @return
     */
    protected String transcode(String type, String value) {
        String url = super.getServiceUrlDomain() + "transcode.php";

        TreeMap<String, String> urlVariableMap = new TreeMap<String, String>();
        urlVariableMap.put("v", value);
        urlVariableMap.put("type", type);
        urlVariableMap.put("site", this.getSite());
        urlVariableMap.put("time", this.getTimestamp());

        TransCodeResponse response = this.getForEntity(url, TransCodeResponse.class, urlVariableMap);

        if (isSuccess(response)) {
            return response.getObjects();
        }
        return null;
    }

    // hbird sso接口调用要求url参数有序，故使用TreeMap有序的特点。
    protected <T> T getForEntity(String url, Class<T> responseType, TreeMap<String, String> urlVariableMap) {
        if (MapUtils.isEmpty(urlVariableMap)) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : urlVariableMap.entrySet()) {

            builder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }
        String signKey = getSignKey();
        String urlVariables = builder.substring(1);// 去掉第一个 &
        String sign = MD5Util.md5Hex(urlVariables + signKey);// md5 32位小写

        url = url + "?" + urlVariables + "&sign=" + sign;
        String json = super.getRestTemplate().getForObject(url, String.class);
        T response = JsonHelper.toBean(json, responseType);
        return response;
    }

    /**
     * @param v
     * @return
     * 
     */
    private String urlEncode(String v) {
        try {
            return URLEncoder.encode(v, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

    private boolean isSuccess(BaseSsoResponse<?> response) {
        return null != response && null != response.getRespond()
                && SUCCESS_STATUS.equals(response.getRespond().getStatus());
    }

}
