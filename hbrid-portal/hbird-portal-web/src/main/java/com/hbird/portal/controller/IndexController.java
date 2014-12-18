package com.hbird.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbird.common.utils.security.MD5Util;
import com.hbird.common.web.context.LoginUser;
import com.hbird.common.web.context.LoginUserUtils;
import com.hbird.portal.controller.base.BaseController;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.constant.CommonConstants;
import com.hbird.portal.domain.dto.MenuDto;
import com.hbird.portal.domain.dto.SubMenuDto;
import com.hbird.portal.service.MenuService;
import com.hbird.portal.service.SSOService;
import com.hbird.portal.service.SyncDataService;
import com.hbird.portal.service.UserService;

/**
 * 主界面控制器：首页、登录等
 * 
 * @author ljz
 * @修改 ljz 增加Shiro部分 20140421
 */
@Controller
@RequestMapping("")
public class IndexController extends BaseController {

    private static final String LOGIN_MSG_KEY = "login_msg";
    private static final String LOGIN_MSG_VALUE_NOT_LOGIN = "<script>alert('请输入用户名和密码登录');</script>";
    private static final String LOGIN_MSG_VALUE_ERROR = "用户名或密码错误";
    private static final String LOGIN_MSG_VALUE_ILLEGAL = "用户名或密码不能空";
    private static final String REDIRECT = "redirect:";
    private static final String VIEW_LOGIN = "login";
    private static final String VIEW_INDEX = "index";
    private static final String FORWARD_URL = "forwardUrl";
    private static final String LOGIN_FORWARD = "loginForward";
    private static final String VIEW_403 = "403";

    @Autowired
    private SSOService ssoService;
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private SyncDataService syncDataService;

    private final Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(Model model) {
        return index(model);
    }

    @RequiresPermissions("index")
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // User loginUser = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        // by ljz 去shiro
        User loginUser = getLoginUser();

        if (loginUser == null) {
            model.addAttribute(LOGIN_MSG_KEY, LOGIN_MSG_VALUE_NOT_LOGIN);
            return login(model, VIEW_INDEX);
        }

        model.addAttribute("name", loginUser.getCnName());
        // initMenu(model);
        // by ljz 20140514 menus改查库不从session取
        initMenu(model, loginUser);
        return VIEW_INDEX;
    }

    /**
     * 初始化菜单
     * 
     * @author ljz 20140514
     * @param model
     */
    private void initMenu(Model model, User user) {
        List<MenuDto> menus = menuService.getMenus(user);
        // 过滤子菜单中的URL，拼接上UID
        for (MenuDto menuDto : menus) {
            if (null != menuDto && !CollectionUtils.isEmpty(menuDto.getSubMenus())) {
                for (SubMenuDto subMenuDto : menuDto.getSubMenus()) {
                    menuFilter(user.getId(), subMenuDto);
                }
            }
        }
        model.addAttribute(CommonConstants.LOGIN_MENUS_KEY, menus);
    }

    /**
     * @param userId
     * @param subMenuDto
     */
    public void menuFilter(Long userId, SubMenuDto subMenuDto) {
        if (null != subMenuDto && StringUtils.isNotBlank(subMenuDto.getSubMenuUrl())) {
            if (subMenuDto.getSubMenuUrl().contains("?")) {
                subMenuDto.setSubMenuUrl(subMenuDto.getSubMenuUrl() + "&UID=" + userId);
            } else {
                subMenuDto.setSubMenuUrl(subMenuDto.getSubMenuUrl() + "?UID=" + userId);
            }
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, @RequestParam("ReturnUrl") String forwardUrl) {
        model.addAttribute(FORWARD_URL, forwardUrl);
        return VIEW_LOGIN;
    }

    @RequestMapping("quit")
    public String quit(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 用户登出
        // SecurityUtils.getSubject().logout();
        LoginUserUtils.invalidateCookie(response);
        return REDIRECT + VIEW_INDEX;
    }

    @RequestMapping(value = "403", method = RequestMethod.GET)
    public String noAuthority(HttpServletRequest request, HttpServletResponse response, Model model) {
        return REDIRECT + VIEW_403;
    }

    /**
     * 登录事件，处理流程:<br />
     * 1.依据用户账号查询用户信息；<br />
     * 2.如果用户信息不存在，返回并提示；如果存在，继续下一步判断用户类型。<br />
     * 3.如果用户类型为公司内用户，则调用公司内单点登录系统验证；<br />
     * 如果不是，则直接判断数据库的用户密码和输入的密码是否相等。
     * 
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "loginSys", method = RequestMethod.POST)
    public String loginSys(User user, Model model, HttpServletResponse response, String forwardUrl) {
        if (user == null || StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
            // 缺少参数
            model.addAttribute(LOGIN_MSG_KEY, LOGIN_MSG_VALUE_ILLEGAL);
            return VIEW_LOGIN;
        }

        String name = user.getName();
        String password = user.getPassword();
        this.logger.info("loginSys: user name=" + name);

        try {
            User loginUser = userService.getUserByName(name);

            if (loginUser == null) {
                boolean isReturn = Boolean.TRUE;
                String tempUserName = name;
                if (!tempUserName.toLowerCase().endsWith("@hbird.com")) {
                    tempUserName += "@hbird.com";
                }

                User result = this.syncDataService.syncUser(tempUserName);
                if (null != result) {
                    this.logger.info("补全用户[" + tempUserName + "]信息成功");
                    isReturn = Boolean.FALSE;
                    loginUser = userService.getUserByName(name);
                }

                if (isReturn) {
                    this.logger.warn("补全用户[" + tempUserName + "]信息不成功");
                    model.addAttribute(LOGIN_MSG_KEY, LOGIN_MSG_VALUE_ERROR);
                    return VIEW_LOGIN;
                }
            }

            boolean checkResult = false;
            if (loginUser != null) {
                if (CommonConstants.USER_TYPE_INNER == loginUser.getUserType()) { // 内部用户
                    checkResult = ssoService.checkUser(name, password);
                } else { // 其他：外派
                    checkResult = MD5Util.md5Hex(password).equals(loginUser.getPassword());
                }
            }

            if (checkResult) {
                setCookie(response, loginUser);
                if (StringUtils.isBlank(forwardUrl)) {
                    forwardUrl = VIEW_INDEX;
                }
                model.addAttribute(FORWARD_URL, forwardUrl);
                return LOGIN_FORWARD;
            } else {
                model.addAttribute(LOGIN_MSG_KEY, LOGIN_MSG_VALUE_ERROR);
                return VIEW_LOGIN;
            }
        } catch (Exception e) {
            // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.error("对用户[" + name + "]进行登录验证未通过,堆栈轨迹如下:", e);
            model.addAttribute(LOGIN_MSG_KEY, LOGIN_MSG_VALUE_ERROR);
            return VIEW_LOGIN;
        }
    }

    /**
     * @param response
     * @param loginUser
     */
    private void setCookie(HttpServletResponse response, User user) {
        if (null == user) {
            return;
        }

        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(user.getId());
        loginUser.setUserName(user.getName());
        loginUser.setCnName(user.getCnName());
        if (null != user.getDep()) {
            loginUser.setDepId(user.getDep().getId());
            loginUser.setDepName(user.getDep().getName());
        }
        LoginUserUtils.setCookie(response, loginUser);
    }

}
