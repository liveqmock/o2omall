package com.hbird.portal.dao;

import java.util.List;
import java.util.Map;

import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.dto.MenuDto;

/**
 * 系统菜单查询DAO接口
 * 
 * @author ljz
 * 
 */
public interface MenuDao {

    /**
     * 依据用户ID或账号查询菜单（一级和二级）列表
     * 
     * @param user
     * @return
     */
    List<MenuDto> getMenus(User user);

    /**
     * 根据用户ID集合查询拥有资源列表
     * 
     * @param user
     *            #id
     * @return
     */
    List<Resource> queryResourceListByUserId(User user);

    /**
     * 根据用户ID和父资源查询按钮资源列表
     * 
     * @param map
     * @return
     */
    List<Resource> queryButtonResources(Map<String, Object> map);

}
