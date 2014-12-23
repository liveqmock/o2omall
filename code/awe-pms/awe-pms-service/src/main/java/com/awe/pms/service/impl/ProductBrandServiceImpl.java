package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pms.domain.ProductBrand;
import com.awe.pms.domain.query.ProductBrandQuery;
import com.awe.pms.manager.ProductBrandManager;
import com.awe.pms.service.ProductBrandService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ProductBrandService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
 * 
 */
@Service
public class ProductBrandServiceImpl implements ProductBrandService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ProductBrandServiceImpl.class);

    @Autowired
    private ProductBrandManager productBrandManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductBrandService.batchInsert")
    public boolean insert(List<ProductBrand> productBrandList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(productBrandList)) {
                resultFlag = productBrandManager.insert(productBrandList);
            } else {
                LOG.warn("ProductBrandServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductBrandServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductBrandService.insert")
    public boolean insert(ProductBrand productBrand) {
        boolean resultFlag = false;
        try {
            if (null != productBrand) {
                if (productBrandManager.exist(productBrand)) {
                    throw new ExistedException();
                }
                resultFlag = productBrandManager.insert(productBrand);
            } else {
                LOG.warn("ProductBrandServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ProductBrandServiceImpl#insert failed, productBrand has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ProductBrandServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductBrandService.update")
    public boolean update(ProductBrand productBrand) {
        boolean resultFlag = false;
        try {
            if (null != productBrand && null != productBrand.getId()) {
                resultFlag = productBrandManager.update(productBrand);
            } else {
                LOG.warn("ProductBrandServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductBrandServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductBrandService.queryProductBrandList")
    public List<ProductBrand> queryProductBrandList(ProductBrandQuery queryBean) {
        List<ProductBrand> productBrandList = null;
        try {
            productBrandList = productBrandManager.queryProductBrandList(queryBean);
        } catch (Exception e) {
            LOG.error("ProductBrandServiceImpl#queryProductBrandList has error.", e);
        }
        return productBrandList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductBrandService.queryProductBrandListWithPage")
    public List<ProductBrand> queryProductBrandListWithPage(ProductBrandQuery queryBean, PageUtil pageUtil) {
        List<ProductBrand> productBrandList = null;
        try {
            productBrandList = productBrandManager.queryProductBrandListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ProductBrandServiceImpl#queryProductBrandListWithPage has error.", e);
        }
        return productBrandList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductBrandService.delete")
    public boolean delete(ProductBrand productBrand) {
        boolean resultFlag = false;
        try {
            if (null != productBrand && null != productBrand.getId()) {
                resultFlag = productBrandManager.delete(productBrand);
            } else {
                LOG.warn("ProductBrandServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductBrandServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductBrandService.batchDelete")
    public boolean delete(ProductBrand[] productBrands) {
        boolean resultFlag = false;
        try {
            if (null != productBrands && productBrands.length > 0) {
                resultFlag = productBrandManager.delete(productBrands);
            } else {
                LOG.warn("ProductBrandServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductBrandServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductBrandService.getProductBrandById")
    public ProductBrand getProductBrandById(Long id) {
        ProductBrand productBrand = null;
        try {
            if (null != id) {
                productBrand = productBrandManager.getProductBrandById(id);
            } else {
                LOG.warn("ProductBrandServiceImpl#getProductBrandById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductBrandServiceImpl#getProductBrandById has error.", e);
        }
        return productBrand;
    }
}

