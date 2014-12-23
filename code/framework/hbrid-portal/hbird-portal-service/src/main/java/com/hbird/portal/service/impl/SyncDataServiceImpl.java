package com.hbird.portal.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbird.common.core.util.DateUtil;
import com.hbird.portal.clients.sso.SsoDataCenterClient;
import com.hbird.portal.clients.sso.SsoUserClient;
import com.hbird.portal.domain.Dep;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.constant.CommonConstants;
import com.hbird.portal.manager.DepManager;
import com.hbird.portal.manager.UserManager;
import com.hbird.portal.service.SyncDataService;

/**
 * 数据同步服务
 * 
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-15 下午04:30:58
 */
@Service("syncDataService")
public class SyncDataServiceImpl implements SyncDataService {

    @Autowired
    private UserManager userManager;

    @Autowired
    private DepManager depManager;

    @Autowired
    private SsoDataCenterClient ssoDataCenterClient;

    @Autowired
    private SsoUserClient ssoUserClient;

    private final static Logger log = LogManager.getLogger(SSOServiceImpl.class);

    @Profiled(tag = "SyncDataService.executeDep")
    public void executeDep() {
        try {
            List<Map<String, Object>> depDtos = ssoDataCenterClient.getDepData();
            List<Dep> deps = toDepList(depDtos);
            this.depManager.syncDepDatas(deps);
        } catch (Exception e) {
            log.error("SyncDataService executeDep has error,", e);
        }
    }

    @Profiled(tag = "SyncDataService.executeUser")
    public void executeUser() {
        try {

            List<Map<String, Object>> userDtos = ssoDataCenterClient.getUserData();
            List<User> users = toUserList(userDtos);
            this.userManager.syncUserDatas(users);
        } catch (Exception e) {
            log.error("SyncDataService executeUser has error,", e);
        }
    }

    @Profiled(tag = "SyncDataService.syncUser")
    public User syncUser(String username) {
        User user = null;
        try {
            Map<String, Object> userMap = ssoUserClient.queryUser(username);
            if (userMap != null && !userMap.isEmpty()) {
                List<Map<String, Object>> userMapList = new ArrayList<Map<String, Object>>(1);
                userMapList.add(userMap);
                List<User> users = this.toUserList(userMapList);
                int count = this.userManager.syncUserDatas(users);
                if (count > 0) {
                    user = users.get(0);
                }
            }
        } catch (Exception e) {
            log.error("SyncDataService syncUser has error,", e);
        }
        return user;
    }

    private List<Dep> toDepList(List<Map<String, Object>> depDtoMaps) {
        if (depDtoMaps == null || depDtoMaps.size() <= 0) {
            return null;
        }
        List<Dep> deps = new ArrayList<Dep>();
        for (Map<String, Object> depMap : depDtoMaps) {
            Dep dep = new Dep();
            dep.setCode((String) depMap.get("org_num"));
            dep.setName((String) depMap.get("org_name"));
            dep.setParentNum((String) depMap.get("pnum"));
            dep.setLastModifyTime(DateUtil.toDate((Long) depMap.get("last_modify_date")));
            dep.setEffect((Integer) depMap.get("effect"));
            deps.add(dep);
        }
        return deps;
    }

    private List<User> toUserList(List<Map<String, Object>> userDtoMaps) {
        if (userDtoMaps == null || userDtoMaps.isEmpty()) {
            return null;
        }

        List<User> users = new ArrayList<User>();
        for (Map<String, Object> userMap : userDtoMaps) {
            User user = new User();
            user.setCode((String) userMap.get("staff_no"));
            user.setName((String) userMap.get("username"));
            user.setCnName((String) userMap.get("nickname"));
            if (CommonConstants.SYNC_USER_STATUS_OFF.equals((String) userMap.get("status"))) {
                user.setStatus(CommonConstants.USER_STATUS_OFF);
            } else {
                user.setStatus(CommonConstants.USER_STATUS_ON);
            }

            String orgNum = (String) userMap.get("org_num");
            if (StringUtils.isNotBlank(orgNum)) {
                Dep dep = this.depManager.getDepByCode(orgNum);
                if (dep != null) {
                    user.setDepId(dep.getId());
                }
            }

            user.setUserType(CommonConstants.USER_TYPE_INNER);
            user.setPhoneNo((String) userMap.get("phone"));
            user.setEmail((String) userMap.get("email"));
            user.setJobTitle((String) userMap.get("job_title"));
            Object lastModifyDate = userMap.get("last_modify_date");
            if (lastModifyDate != null) {
                user.setLastModifyTime(DateUtil.toDate((Long) userMap.get("last_modify_date")));
            } else {
                user.setLastModifyTime(new Date());
            }
            users.add(user);
        }
        return users;
    }
}
