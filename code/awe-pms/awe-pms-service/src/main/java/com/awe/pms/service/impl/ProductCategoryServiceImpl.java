package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pms.domain.ProductCategory;
import com.awe.pms.domain.query.ProductCategoryQuery;
import com.awe.pms.manager.ProductCategoryManager;
import com.awe.pms.service.ProductCategoryService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ProductCategoryService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 9:31:54
 * 
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ProductCategoryServiceImpl.class);

    @Autowired
    private ProductCategoryManager productCategoryManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.batchInsert")
    public boolean insert(List<ProductCategory> productCategoryList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(productCategoryList)) {
                resultFlag = productCategoryManager.insert(productCategoryList);
            } else {
                LOG.warn("ProductCategoryServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.insert")
    public boolean insert(ProductCategory productCategory) {
        boolean resultFlag = false;
        try {
            if (null != productCategory) {
                if (productCategoryManager.exist(productCategory)) {
                    throw new ExistedException();
                }
                resultFlag = productCategoryManager.insert(productCategory);
            } else {
                LOG.warn("ProductCategoryServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ProductCategoryServiceImpl#insert failed, productCategory has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.update")
    public boolean update(ProductCategory productCategory) {
        boolean resultFlag = false;
        try {
            if (null != productCategory && null != productCategory.getId()) {
                resultFlag = productCategoryManager.update(productCategory);
            } else {
                LOG.warn("ProductCategoryServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.queryProductCategoryList")
    public List<ProductCategory> queryProductCategoryList(ProductCategoryQuery queryBean) {
        List<ProductCategory> productCategoryList = null;
        try {
            productCategoryList = productCategoryManager.queryProductCategoryList(queryBean);
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#queryProductCategoryList has error.", e);
        }
        return productCategoryList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.queryProductCategoryListWithPage")
    public List<ProductCategory> queryProductCategoryListWithPage(ProductCategoryQuery queryBean, PageUtil pageUtil) {
        List<ProductCategory> productCategoryList = null;
        try {
            productCategoryList = productCategoryManager.queryProductCategoryListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#queryProductCategoryListWithPage has error.", e);
        }
        return productCategoryList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.delete")
    public boolean delete(ProductCategory productCategory) {
        boolean resultFlag = false;
        try {
            if (null != productCategory && null != productCategory.getId()) {
                resultFlag = productCategoryManager.delete(productCategory);
            } else {
                LOG.warn("ProductCategoryServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.batchDelete")
    public boolean delete(ProductCategory[] productCategorys) {
        boolean resultFlag = false;
        try {
            if (null != productCategorys && productCategorys.length > 0) {
                resultFlag = productCategoryManager.delete(productCategorys);
            } else {
                LOG.warn("ProductCategoryServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.getProductCategoryById")
    public ProductCategory getProductCategoryById(Long id) {
        ProductCategory productCategory = null;
        try {
            if (null != id) {
                productCategory = productCategoryManager.getProductCategoryById(id);
            } else {
                LOG.warn("ProductCategoryServiceImpl#getProductCategoryById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#getProductCategoryById has error.", e);
        }
        return productCategory;
    }
}

