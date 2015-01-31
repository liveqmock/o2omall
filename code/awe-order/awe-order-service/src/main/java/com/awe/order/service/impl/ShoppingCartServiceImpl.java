package com.awe.order.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.order.domain.ShoppingCart;
import com.awe.order.domain.query.ShoppingCartQuery;
import com.awe.order.manager.ShoppingCartManager;
import com.awe.order.service.ShoppingCartService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
 
/**
 * ShoppingCartService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ShoppingCartServiceImpl.class);

    @Autowired
    private ShoppingCartManager shoppingCartManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShoppingCartService.batchInsert")
    public boolean insert(List<ShoppingCart> shoppingCartList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(shoppingCartList)) {
                resultFlag = shoppingCartManager.insert(shoppingCartList);
            } else {
                LOG.warn("ShoppingCartServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ShoppingCartServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShoppingCartService.insert")
    public boolean insert(ShoppingCart shoppingCart) {
        boolean resultFlag = false;
        try {
            if (null != shoppingCart) {
                if (shoppingCartManager.exist(shoppingCart)) {
                	ShoppingCart shoppingCartOfExisted = shoppingCartManager.getShoppingCart(shoppingCart);
                	if(null == shoppingCartOfExisted){
                		LOG.warn("ShoppingCartServiceImpl#insert failed, shoppingCartOfExisted is null.");
                		return resultFlag;
                	}
                	int skuCount = shoppingCartOfExisted.getSkuCount() + shoppingCart.getSkuCount();
                	shoppingCart.setSkuCount(skuCount);
                	resultFlag = shoppingCartManager.update(shoppingCart);
                }else{
                	resultFlag = shoppingCartManager.insert(shoppingCart);
                }
            } else {
                LOG.warn("ShoppingCartServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ShoppingCartServiceImpl#insert failed, shoppingCart has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ShoppingCartServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShoppingCartService.update")
    public boolean update(ShoppingCart shoppingCart) {
        boolean resultFlag = false;
        try {
            if (null != shoppingCart && null != shoppingCart.getSkuNo()) {
                resultFlag = shoppingCartManager.update(shoppingCart);
            } else {
                LOG.warn("ShoppingCartServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ShoppingCartServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShoppingCartService.queryShoppingCartList")
    public List<ShoppingCart> queryShoppingCartList(ShoppingCartQuery queryBean) {
        List<ShoppingCart> shoppingCartList = null;
        try {
            shoppingCartList = shoppingCartManager.queryShoppingCartList(queryBean);
        } catch (Exception e) {
            LOG.error("ShoppingCartServiceImpl#queryShoppingCartList has error.", e);
        }
        return shoppingCartList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShoppingCartService.queryShoppingCartListWithPage")
    public List<ShoppingCart> queryShoppingCartListWithPage(ShoppingCartQuery queryBean, PageUtil pageUtil) {
        List<ShoppingCart> shoppingCartList = null;
        try {
            shoppingCartList = shoppingCartManager.queryShoppingCartListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ShoppingCartServiceImpl#queryShoppingCartListWithPage has error.", e);
        }
        return shoppingCartList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShoppingCartService.delete")
    public boolean delete(ShoppingCart shoppingCart) {
        boolean resultFlag = false;
        try {
            if (null != shoppingCart && null != shoppingCart.getSkuNo()) {
                resultFlag = shoppingCartManager.delete(shoppingCart);
            } else {
                LOG.warn("ShoppingCartServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ShoppingCartServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShoppingCartService.batchDelete")
    public boolean delete(ShoppingCart[] shoppingCarts) {
        boolean resultFlag = false;
        try {
            if (null != shoppingCarts && shoppingCarts.length > 0) {
                resultFlag = shoppingCartManager.delete(shoppingCarts);
            } else {
                LOG.warn("ShoppingCartServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ShoppingCartServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ShoppingCartService.getShoppingCartById")
    public ShoppingCart getShoppingCartById(Long id) {
        ShoppingCart shoppingCart = null;
        try {
            if (null != id) {
                shoppingCart = shoppingCartManager.getShoppingCartById(id);
            } else {
                LOG.warn("ShoppingCartServiceImpl#getShoppingCartById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ShoppingCartServiceImpl#getShoppingCartById has error.", e);
        }
        return shoppingCart;
    }
}

