package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pms.domain.Product;
import com.awe.pms.domain.query.ProductQuery;
import com.awe.pms.manager.ProductManager;
import com.awe.pms.service.ProductService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ProductService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ProductServiceImpl.class);

    @Autowired
    private ProductManager productManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductService.batchInsert")
    public boolean insert(List<Product> productList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(productList)) {
                resultFlag = productManager.insert(productList);
            } else {
                LOG.warn("ProductServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductService.insert")
    public boolean insert(Product product) {
        boolean resultFlag = false;
        try {
            if (null != product) {
                if (productManager.exist(product)) {
                    throw new ExistedException();
                }
                resultFlag = productManager.insert(product);
            } else {
                LOG.warn("ProductServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ProductServiceImpl#insert failed, product has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ProductServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductService.update")
    public boolean update(Product product) {
        boolean resultFlag = false;
        try {
            if (null != product && null != product.getId()) {
                resultFlag = productManager.update(product);
            } else {
                LOG.warn("ProductServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductService.queryProductList")
    public List<Product> queryProductList(ProductQuery queryBean) {
        List<Product> productList = null;
        try {
            productList = productManager.queryProductList(queryBean);
        } catch (Exception e) {
            LOG.error("ProductServiceImpl#queryProductList has error.", e);
        }
        return productList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductService.queryProductListWithPage")
    public List<Product> queryProductListWithPage(ProductQuery queryBean, PageUtil pageUtil) {
        List<Product> productList = null;
        try {
            productList = productManager.queryProductListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ProductServiceImpl#queryProductListWithPage has error.", e);
        }
        return productList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductService.delete")
    public boolean delete(Product product) {
        boolean resultFlag = false;
        try {
            if (null != product && null != product.getId()) {
                resultFlag = productManager.delete(product);
            } else {
                LOG.warn("ProductServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductService.batchDelete")
    public boolean delete(Product[] products) {
        boolean resultFlag = false;
        try {
            if (null != products && products.length > 0) {
                resultFlag = productManager.delete(products);
            } else {
                LOG.warn("ProductServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductService.getProductById")
    public Product getProductById(Long id) {
        Product product = null;
        try {
            if (null != id) {
                product = productManager.getProductById(id);
            } else {
                LOG.warn("ProductServiceImpl#getProductById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductServiceImpl#getProductById has error.", e);
        }
        return product;
    }
}

