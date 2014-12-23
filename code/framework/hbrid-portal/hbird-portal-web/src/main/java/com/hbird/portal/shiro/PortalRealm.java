package com.hbird.portal.shiro;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.hbird.portal.domain.User;
import com.hbird.portal.domain.constant.CommonConstants;
import com.hbird.portal.domain.dto.MenuDto;
import com.hbird.portal.service.MenuService;
import com.hbird.portal.service.UserService;

/**
 * 自定义的指定Shiro验证用户登录的类
 * <p/>
 * 
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
public class PortalRealm extends AuthorizingRealm {

    private static final Logger log = LogManager.getLogger(PortalRealm.class);

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    /**
     * 为当前登录的Subject授予角色和权限
     * 
     * @param principals
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String currentUsername = (String) principals.fromRealm(getName()).iterator().next();
        User user = userService.getUserByName(currentUsername);
        if (null != user) {
            SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
            /*
             * List<MenuDto> menuDtos = (List<MenuDto>) SecurityUtils.getSubject().getSession().getAttribute("menus");
             * if (null != menuDtos && menuDtos.size() > 0) { for (MenuDto menuDto : menuDtos) { List<SubMenuDto>
             * subMenuDtos = menuDto.getSubMenus(); if (null != subMenuDtos && subMenuDtos.size() > 0) { for (SubMenuDto
             * subMenuDto : subMenuDtos) { //以菜单Url做为Shiro资源 String url = subMenuDto.getUrl(); if
             * (StringUtils.isNotEmpty(url)) { simpleAuthorInfo.addStringPermission(StringUtils.substringAfterLast(url,
             * StringUtil.SEP_SLASH)); } } }else{ log.error("当前登录用户[" + currentUsername + "]未授权!"); } } } else {
             * log.error("当前登录用户[" + currentUsername + "]未授权!"); }
             */

            return simpleAuthorInfo;
        }

        return null;
    }

    /**
     * 验证当前登录的Subject
     * 
     * @param authcToken
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        // 获取基于用户名和密码的令牌
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.getUserByName(token.getUsername());

        if (null != user) {
            List<MenuDto> menuDtos = menuService.getMenus(user);
            setSession(CommonConstants.LOGIN_MENUS_KEY, menuDtos);
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
            this.setSession(CommonConstants.LOGIN_USER_KEY, user);
            return authcInfo;
        } else {
            return null;
        }
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                log.debug("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
                session.setAttribute(key, value);
            }
        }
    }
}
