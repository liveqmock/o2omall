package com.hbird.portal.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hbird.common.dao.mybatis.BaseDao;
import com.hbird.portal.dao.MenuDao;
import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.dto.MenuDto;

/**
 * 系统菜单查询DAO实现
 * 
 * @author ljz
 * 
 */
@Repository
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MenuDaoImpl extends BaseDao implements MenuDao {

    public List<MenuDto> getMenus(User user) {
        return (List<MenuDto>) queryForList("Menu.getMenus", user);
    }

    public List<Resource> queryResourceListByUserId(User user) {
        return (List<Resource>) queryForList("Menu.queryResourceListByUserId", user);
    }

    public List<Resource> queryButtonResources(Map<String, Object> map) {
        return (List<Resource>) queryForList("Menu.queryButtonResources", map);
    }
}
