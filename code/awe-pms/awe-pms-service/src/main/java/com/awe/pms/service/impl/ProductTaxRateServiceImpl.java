package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pms.domain.ProductTaxRate;
import com.awe.pms.domain.query.ProductTaxRateQuery;
import com.awe.pms.manager.ProductTaxRateManager;
import com.awe.pms.service.ProductTaxRateService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ProductTaxRateService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 9:31:54
 * 
 */
@Service
public class ProductTaxRateServiceImpl implements ProductTaxRateService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ProductTaxRateServiceImpl.class);

    @Autowired
    private ProductTaxRateManager productTaxRateManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductTaxRateService.batchInsert")
    public boolean insert(List<ProductTaxRate> productTaxRateList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(productTaxRateList)) {
                resultFlag = productTaxRateManager.insert(productTaxRateList);
            } else {
                LOG.warn("ProductTaxRateServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductTaxRateServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductTaxRateService.insert")
    public boolean insert(ProductTaxRate productTaxRate) {
        boolean resultFlag = false;
        try {
            if (null != productTaxRate) {
                if (productTaxRateManager.exist(productTaxRate)) {
                    throw new ExistedException();
                }
                resultFlag = productTaxRateManager.insert(productTaxRate);
            } else {
                LOG.warn("ProductTaxRateServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ProductTaxRateServiceImpl#insert failed, productTaxRate has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ProductTaxRateServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductTaxRateService.update")
    public boolean update(ProductTaxRate productTaxRate) {
        boolean resultFlag = false;
        try {
            if (null != productTaxRate && null != productTaxRate.getId()) {
                resultFlag = productTaxRateManager.update(productTaxRate);
            } else {
                LOG.warn("ProductTaxRateServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductTaxRateServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductTaxRateService.queryProductTaxRateList")
    public List<ProductTaxRate> queryProductTaxRateList(ProductTaxRateQuery queryBean) {
        List<ProductTaxRate> productTaxRateList = null;
        try {
            productTaxRateList = productTaxRateManager.queryProductTaxRateList(queryBean);
        } catch (Exception e) {
            LOG.error("ProductTaxRateServiceImpl#queryProductTaxRateList has error.", e);
        }
        return productTaxRateList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductTaxRateService.queryProductTaxRateListWithPage")
    public List<ProductTaxRate> queryProductTaxRateListWithPage(ProductTaxRateQuery queryBean, PageUtil pageUtil) {
        List<ProductTaxRate> productTaxRateList = null;
        try {
            productTaxRateList = productTaxRateManager.queryProductTaxRateListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ProductTaxRateServiceImpl#queryProductTaxRateListWithPage has error.", e);
        }
        return productTaxRateList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductTaxRateService.delete")
    public boolean delete(ProductTaxRate productTaxRate) {
        boolean resultFlag = false;
        try {
            if (null != productTaxRate && null != productTaxRate.getId()) {
                resultFlag = productTaxRateManager.delete(productTaxRate);
            } else {
                LOG.warn("ProductTaxRateServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductTaxRateServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductTaxRateService.batchDelete")
    public boolean delete(ProductTaxRate[] productTaxRates) {
        boolean resultFlag = false;
        try {
            if (null != productTaxRates && productTaxRates.length > 0) {
                resultFlag = productTaxRateManager.delete(productTaxRates);
            } else {
                LOG.warn("ProductTaxRateServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductTaxRateServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductTaxRateService.getProductTaxRateById")
    public ProductTaxRate getProductTaxRateById(Long id) {
        ProductTaxRate productTaxRate = null;
        try {
            if (null != id) {
                productTaxRate = productTaxRateManager.getProductTaxRateById(id);
            } else {
                LOG.warn("ProductTaxRateServiceImpl#getProductTaxRateById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductTaxRateServiceImpl#getProductTaxRateById has error.", e);
        }
        return productTaxRate;
    }
}

