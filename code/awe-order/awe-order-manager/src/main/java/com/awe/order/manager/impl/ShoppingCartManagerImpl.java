package com.awe.order.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.order.domain.ShoppingCart;
import com.awe.order.domain.query.ShoppingCartQuery;
import com.awe.order.dao.ShoppingCartDao;
import com.awe.order.manager.ShoppingCartManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ShoppingCartManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:36
 * 
 */
@Component
public class ShoppingCartManagerImpl extends BaseManager implements ShoppingCartManager {
	
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ShoppingCart> shoppingCartList) {
        boolean resultFlag = false;
        if (null != shoppingCartList && shoppingCartList.size() > 0) {
            for (ShoppingCart shoppingCart : shoppingCartList) {
                resultFlag = shoppingCartDao.insert(shoppingCart);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ShoppingCart shoppingCart) {
        return shoppingCartDao.insert(shoppingCart);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ShoppingCart shoppingCart) {
        return shoppingCartDao.update(shoppingCart);
    }

    /**
     * {@inheritDoc}
     */
    public List<ShoppingCart> queryShoppingCartList(ShoppingCartQuery queryBean) {
        return shoppingCartDao.queryShoppingCartList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ShoppingCart> queryShoppingCartListWithPage(ShoppingCartQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ShoppingCartQuery();
        }

        // 查询总数
        int totalItem = queryShoppingCartCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return shoppingCartDao.queryShoppingCartListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryShoppingCartCount(ShoppingCartQuery queryBean) {
        return shoppingCartDao.queryShoppingCartCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ShoppingCart shoppingCart) {
        return shoppingCartDao.delete(shoppingCart);
    }

    /**
     * {@inheritDoc}
     */
    public ShoppingCart getShoppingCartById(Long id) {
        return shoppingCartDao.getShoppingCartById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ShoppingCart[] shoppingCarts) {
        boolean resultFlag = false;
        if (null != shoppingCarts && shoppingCarts.length > 0) {
            for (int i = 0; i < shoppingCarts.length; i++) {
                resultFlag = delete(shoppingCarts[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(ShoppingCart shoppingCart) {
        return shoppingCartDao.exist(shoppingCart);
    }
}
