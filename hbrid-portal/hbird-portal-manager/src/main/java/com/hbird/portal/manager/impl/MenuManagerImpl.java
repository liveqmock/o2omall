/**
 * 
 */
package com.hbird.portal.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbird.portal.dao.MenuDao;
import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.dto.MenuDto;
import com.hbird.portal.manager.MenuManager;

/**
 * 系统菜单查询Manager实现
 * 
 * @author ljz
 * 
 */
@Component
public class MenuManagerImpl implements MenuManager {

    @Autowired
    private MenuDao menuDao;

    /**
     * {@inheritDoc}
     */
    public List<MenuDto> getMenus(User user) {
        return menuDao.getMenus(user);
    }

    /**
     * {@inheritDoc}
     */
    public List<Resource> queryResourceListByUserId(User user) {
        return menuDao.queryResourceListByUserId(user);
    }

    /**
     * {@inheritDoc}
     */
    public List<Resource> queryButtonResources(Map<String, Object> map) {
        return menuDao.queryButtonResources(map);
    }
}
