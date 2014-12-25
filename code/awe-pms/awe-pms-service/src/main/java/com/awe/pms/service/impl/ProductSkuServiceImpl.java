package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pms.domain.ProductSku;
import com.awe.pms.domain.query.ProductSkuQuery;
import com.awe.pms.manager.ProductSkuManager;
import com.awe.pms.service.ProductSkuService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ProductSkuService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
@Service
public class ProductSkuServiceImpl implements ProductSkuService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ProductSkuServiceImpl.class);

    @Autowired
    private ProductSkuManager productSkuManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSkuService.batchInsert")
    public boolean insert(List<ProductSku> productSkuList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(productSkuList)) {
                resultFlag = productSkuManager.insert(productSkuList);
            } else {
                LOG.warn("ProductSkuServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductSkuServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSkuService.insert")
    public boolean insert(ProductSku productSku) {
        boolean resultFlag = false;
        try {
            if (null != productSku) {
                if (productSkuManager.exist(productSku)) {
                    throw new ExistedException();
                }
                resultFlag = productSkuManager.insert(productSku);
            } else {
                LOG.warn("ProductSkuServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ProductSkuServiceImpl#insert failed, productSku has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ProductSkuServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSkuService.update")
    public boolean update(ProductSku productSku) {
        boolean resultFlag = false;
        try {
            if (null != productSku && null != productSku.getId()) {
                resultFlag = productSkuManager.update(productSku);
            } else {
                LOG.warn("ProductSkuServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductSkuServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSkuService.queryProductSkuList")
    public List<ProductSku> queryProductSkuList(ProductSkuQuery queryBean) {
        List<ProductSku> productSkuList = null;
        try {
            productSkuList = productSkuManager.queryProductSkuList(queryBean);
        } catch (Exception e) {
            LOG.error("ProductSkuServiceImpl#queryProductSkuList has error.", e);
        }
        return productSkuList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSkuService.queryProductSkuListWithPage")
    public List<ProductSku> queryProductSkuListWithPage(ProductSkuQuery queryBean, PageUtil pageUtil) {
        List<ProductSku> productSkuList = null;
        try {
            productSkuList = productSkuManager.queryProductSkuListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ProductSkuServiceImpl#queryProductSkuListWithPage has error.", e);
        }
        return productSkuList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSkuService.delete")
    public boolean delete(ProductSku productSku) {
        boolean resultFlag = false;
        try {
            if (null != productSku && null != productSku.getId()) {
                resultFlag = productSkuManager.delete(productSku);
            } else {
                LOG.warn("ProductSkuServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductSkuServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSkuService.batchDelete")
    public boolean delete(ProductSku[] productSkus) {
        boolean resultFlag = false;
        try {
            if (null != productSkus && productSkus.length > 0) {
                resultFlag = productSkuManager.delete(productSkus);
            } else {
                LOG.warn("ProductSkuServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductSkuServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSkuService.getProductSkuById")
    public ProductSku getProductSkuById(Long id) {
        ProductSku productSku = null;
        try {
            if (null != id) {
                productSku = productSkuManager.getProductSkuById(id);
            } else {
                LOG.warn("ProductSkuServiceImpl#getProductSkuById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductSkuServiceImpl#getProductSkuById has error.", e);
        }
        return productSku;
    }
}

