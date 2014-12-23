package com.hbird.portal.clients.sso;

import java.util.List;
import java.util.Map;

import com.hbird.common.core.util.DateUtil;
import com.hbird.common.core.util.security.MD5Encode;
import com.hbird.portal.clients.sso.response.BaseSsoResponse;
import com.hbird.portal.clients.sso.response.DataCenterResponse;

/**
 * 数据中心同步服务客户端
 * 
 * @author ljz
 * @version 2014-11-27 下午9:33:12
 */
public class SsoDataCenterClient extends AbstractSsoClient {

    private static final String SUCCESS_STATUS = "200";
    private String startTime;

    /**
     * 查询用户数据
     * 
     * @return
     */
    public List<Map<String, Object>> getUserData() {
        String url = getServiceUrlDomain() + "UserSynchronizer";
        return this.getData(url);
    }

    /**
     * 查询部门数据
     * 
     * @return
     */
    public List<Map<String, Object>> getDepData() {
        String url = getServiceUrlDomain() + "OrgSynchronizer";
        return this.getData(url);
    }

    /**
     * 查询数据
     * 
     * @param url
     * @return
     */
    protected List<Map<String, Object>> getData(String url) {
        String time = String.valueOf(DateUtil.getCurrentTime());
        String time_end = DateUtil.getCurrentDateStr(DateUtil.DEFAULE_DATEFORMAT_PATTERN);
        String key = "site=" + super.getSite() + "&time=" + time + "&time_end=" + time_end + "&time_start=" + startTime
                + super.getSignKey();
        String paramStr = "site=" + super.getSite() + "&time=" + time + "&time_end=" + time_end + "&time_start="
                + startTime + "&sign=" + MD5Encode.encode(key);

        DataCenterResponse responseDto = super.getRestTemplate().getForObject(url + "?" + paramStr,
                DataCenterResponse.class);
        if (isSuccess(responseDto)) {
            return responseDto.getObjects();
        }
        return null;
    }

    private boolean isSuccess(BaseSsoResponse<?> response) {
        return null != response && null != response.getRespond()
                && SUCCESS_STATUS.equals(response.getRespond().getStatus());
    }

    /**
     * @param startTime
     *            the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
