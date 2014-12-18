package com.hbird.portal.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbird.portal.domain.User;
import com.hbird.portal.domain.dto.MenuDto;
import com.hbird.portal.manager.MenuManager;
import com.hbird.portal.service.MenuService;

/**
 * 系统菜单服务实现类：提供登录用户的菜单（资源）查询服务
 * 
 * @author ljz
 * 
 */
@Service
public class MenuServiceImpl implements MenuService {

    private final static Logger log = LogManager.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuManager menuManager;

    /**
     * 依据用户ID或账号查询菜单（一级和二级）列表
     * 
     * @param user
     * @return
     */
    @Profiled(tag = "MenuService.getMenus")
    public List<MenuDto> getMenus(User user) {
        List<MenuDto> menuDtos = null;
        try {
            menuDtos = menuManager.getMenus(user);
        } catch (Exception e) {
            log.error("MenuServiceImpl -> getMenus(User user) error!!", e);
        }
        return menuDtos;
    }

}
