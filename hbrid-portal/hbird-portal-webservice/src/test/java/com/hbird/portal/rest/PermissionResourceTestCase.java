/**
 * 
 */
package com.hbird.portal.rest;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.portal.sdk.api.request.PermissionCheckRequest;
import com.hbird.portal.sdk.dto.ButtonResourceResponse;
import com.hbird.portal.sdk.response.ButtonResourceDto;

/**
 * 权限rest服务测试用例
 * 
 * @author ljz
 * @version 2014-12-2 下午5:07:47
 */
public class PermissionResourceTestCase {

    private static final String SERVICES_BUTTON_RESOURCE = Urls.API_DOMAIN + "services/permission/buttonResource";

    @Test
    public void testButtonResource() throws UnsupportedEncodingException {
        PermissionCheckRequest request = new PermissionCheckRequest();
        request.setUserId(951L);
        request.setResourceUrl("http://local.i.shop.hbird.com:8080/user/resetPassword");
        RestTemplate template = new RestTemplate();
        String s = template.postForObject(SERVICES_BUTTON_RESOURCE, request, String.class);
        Assert.notNull(s);
        byte[] bytes = template.postForObject(SERVICES_BUTTON_RESOURCE, request, byte[].class);
        ButtonResourceResponse re = template.postForObject(SERVICES_BUTTON_RESOURCE, request,
                ButtonResourceResponse.class);
        Assert.notNull(re);
        String str = new String(bytes, "UTF-8");
        Assert.notNull(str);
    }

    public static String postForObject(String url, String mediaType, String content) throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);// 设置超时时间
        post.setHeader("Content-Type", mediaType);
        String retStr = "";
        // 这种单独传字符串进去
        StringEntity reqEntity = new StringEntity(content, "utf-8");// 请求字符的编码
        post.setEntity(reqEntity);
        HttpResponse response = client.execute(post);
        int code = response.getStatusLine().getStatusCode();
        if (code == 200) {
            HttpEntity entity = response.getEntity();
            retStr = EntityUtils.toString(entity, "UTF-8");// 返回字符的编码
        } else
            throw new Exception(String.valueOf(code));
        return retStr;
    }

    @Test
    public void testButtonResource2() throws Exception {
        PermissionCheckRequest request = new PermissionCheckRequest();
        request.setUserId(951L);
        request.setResourceUrl("http://local.i.shop.hbird.com:8080/user/resetPassword");
        String json = JsonHelper.toJson(request);
        String url = "http://local.iapi.shop.hbird.com:8090/services/permission/buttonResource";
        String ret = PermissionResourceTestCase.postForObject(url, "application/json;charset=utf-8", json);
        System.out.println(ret);
        ButtonResourceResponse resourceResponse = JsonHelper.toBean(ret, ButtonResourceResponse.class);
        List<ButtonResourceDto> list = resourceResponse.getResult();
        for (ButtonResourceDto buttonResourceDto : list) {
            System.out.println(buttonResourceDto.getButtonName());
        }
    }

}
