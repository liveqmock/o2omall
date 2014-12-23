package com.hbird.portal.service;

import java.util.List;

import com.hbird.portal.domain.User;
import com.hbird.portal.domain.dto.MenuDto;

/**
 * 系统菜单服务接口：提供登录用户的菜单（资源）查询服务
 * 
 * @author ljz
 * 
 */
public interface MenuService {

    /**
     * 依据用户ID或账号查询菜单（一级和二级）列表
     * 
     * @param user
     * @return
     */
    List<MenuDto> getMenus(User user);
}
