package com.awe.pms.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pms.domain.ProductCategory;
import com.awe.pms.domain.query.ProductCategoryQuery;
import com.awe.pms.dao.ProductCategoryDao;
import com.awe.pms.manager.ProductCategoryManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ProductCategoryManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
@Component
public class ProductCategoryManagerImpl extends BaseManager implements ProductCategoryManager {
	
    @Autowired
    private ProductCategoryDao productCategoryDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ProductCategory> productCategoryList) {
        boolean resultFlag = false;
        if (null != productCategoryList && productCategoryList.size() > 0) {
            for (ProductCategory productCategory : productCategoryList) {
                resultFlag = productCategoryDao.insert(productCategory);
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
    public boolean insert(ProductCategory productCategory) {
        return productCategoryDao.insert(productCategory);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ProductCategory productCategory) {
        return productCategoryDao.update(productCategory);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductCategory> queryProductCategoryList(ProductCategoryQuery queryBean) {
        return productCategoryDao.queryProductCategoryList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductCategory> queryProductCategoryListWithPage(ProductCategoryQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ProductCategoryQuery();
        }

        // 查询总数
        int totalItem = queryProductCategoryCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return productCategoryDao.queryProductCategoryListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductCategoryCount(ProductCategoryQuery queryBean) {
        return productCategoryDao.queryProductCategoryCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductCategory productCategory) {
        return productCategoryDao.delete(productCategory);
    }

    /**
     * {@inheritDoc}
     */
    public ProductCategory getProductCategoryById(Long id) {
        return productCategoryDao.getProductCategoryById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ProductCategory[] productCategorys) {
        boolean resultFlag = false;
        if (null != productCategorys && productCategorys.length > 0) {
            for (int i = 0; i < productCategorys.length; i++) {
                resultFlag = delete(productCategorys[i]);
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
    public boolean exist(ProductCategory productCategory) {
        return productCategoryDao.exist(productCategory);
    }
}
