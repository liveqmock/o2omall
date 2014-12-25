package com.awe.pms.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pms.domain.ProductTaxRate;
import com.awe.pms.domain.query.ProductTaxRateQuery;
import com.awe.pms.dao.ProductTaxRateDao;
import com.awe.pms.manager.ProductTaxRateManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ProductTaxRateManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 9:31:54
 * 
 */
@Component
public class ProductTaxRateManagerImpl extends BaseManager implements ProductTaxRateManager {
	
    @Autowired
    private ProductTaxRateDao productTaxRateDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ProductTaxRate> productTaxRateList) {
        boolean resultFlag = false;
        if (null != productTaxRateList && productTaxRateList.size() > 0) {
            for (ProductTaxRate productTaxRate : productTaxRateList) {
                resultFlag = productTaxRateDao.insert(productTaxRate);
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
    public boolean insert(ProductTaxRate productTaxRate) {
        return productTaxRateDao.insert(productTaxRate);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ProductTaxRate productTaxRate) {
        return productTaxRateDao.update(productTaxRate);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductTaxRate> queryProductTaxRateList(ProductTaxRateQuery queryBean) {
        return productTaxRateDao.queryProductTaxRateList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductTaxRate> queryProductTaxRateListWithPage(ProductTaxRateQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ProductTaxRateQuery();
        }

        // 查询总数
        int totalItem = queryProductTaxRateCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return productTaxRateDao.queryProductTaxRateListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductTaxRateCount(ProductTaxRateQuery queryBean) {
        return productTaxRateDao.queryProductTaxRateCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductTaxRate productTaxRate) {
        return productTaxRateDao.delete(productTaxRate);
    }

    /**
     * {@inheritDoc}
     */
    public ProductTaxRate getProductTaxRateById(Long id) {
        return productTaxRateDao.getProductTaxRateById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ProductTaxRate[] productTaxRates) {
        boolean resultFlag = false;
        if (null != productTaxRates && productTaxRates.length > 0) {
            for (int i = 0; i < productTaxRates.length; i++) {
                resultFlag = delete(productTaxRates[i]);
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
    public boolean exist(ProductTaxRate productTaxRate) {
        return productTaxRateDao.exist(productTaxRate);
    }
}
