package com.hbird.portal.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.hbird.portal.test.BaseTransactionTestCase;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.dto.MenuDto;
import com.hbird.portal.domain.dto.SubMenuDto;

/**
 * MenuService TestCase
 * 
 * @author ljz
 * 
 */
public class MenuServiceTestCase extends BaseTransactionTestCase {

    @Autowired
    private MenuService menuService;

    @Test
    public void testGetMenusByUserId() {
        Long userId = 951L;
        User user = new User();
        user.setId(userId);
        List<MenuDto> menuDtos = menuService.getMenus(user);
        Assert.notEmpty(menuDtos);

        for (MenuDto menuDto : menuDtos) {
            logger.info(menuDto.getMenuName());

            List<SubMenuDto> subMenuDtos = menuDto.getSubMenus();
            Assert.notEmpty(subMenuDtos);
            for (SubMenuDto subMenuDto : subMenuDtos) {
                logger.info(subMenuDto.getSubMenuCode() + " " + subMenuDto.getSubMenuName() + " "
                        + subMenuDto.getSubMenuUrl());
            }
        }
    }

    @Test
    public void testGetMenusByUserIdFailure() {
        Long userId = -2l;
        User user = new User();
        user.setId(userId);
        List<MenuDto> menuDtos = menuService.getMenus(user);
        Assert.isTrue(CollectionUtils.isEmpty(menuDtos));
    }

    @Test
    public void testGetMenusByUserName() {
        String name = "a";
        User user = new User();
        user.setName(name);
        List<MenuDto> menuDtos = menuService.getMenus(user);
        Assert.notEmpty(menuDtos);

        for (MenuDto menuDto : menuDtos) {
            logger.info(menuDto.getMenuName());

            List<SubMenuDto> subMenuDtos = menuDto.getSubMenus();
            Assert.notEmpty(subMenuDtos);
            for (SubMenuDto subMenuDto : subMenuDtos) {
                logger.info(subMenuDto.getSubMenuCode() + " " + subMenuDto.getSubMenuName() + " "
                        + subMenuDto.getSubMenuUrl());
            }
        }
    }

    @Test
    public void testGetMenusByUserNameFailure() {
        String name = "#EDFV@WSX%TGHa";
        User user = new User();
        user.setName(name);
        List<MenuDto> menuDtos = menuService.getMenus(user);
        Assert.isTrue(CollectionUtils.isEmpty(menuDtos));
    }
}
