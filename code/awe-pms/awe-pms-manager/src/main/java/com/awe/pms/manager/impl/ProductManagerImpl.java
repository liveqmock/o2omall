package com.awe.pms.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pms.domain.Product;
import com.awe.pms.domain.query.ProductQuery;
import com.awe.pms.dao.ProductDao;
import com.awe.pms.manager.ProductManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ProductManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
@Component
public class ProductManagerImpl extends BaseManager implements ProductManager {
	
    @Autowired
    private ProductDao productDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<Product> productList) {
        boolean resultFlag = false;
        if (null != productList && productList.size() > 0) {
            for (Product product : productList) {
                resultFlag = productDao.insert(product);
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
    public boolean insert(Product product) {
        return productDao.insert(product);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final Product product) {
        return productDao.update(product);
    }

    /**
     * {@inheritDoc}
     */
    public List<Product> queryProductList(ProductQuery queryBean) {
        return productDao.queryProductList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Product> queryProductListWithPage(ProductQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ProductQuery();
        }

        // 查询总数
        int totalItem = queryProductCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return productDao.queryProductListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductCount(ProductQuery queryBean) {
        return productDao.queryProductCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Product product) {
        return productDao.delete(product);
    }

    /**
     * {@inheritDoc}
     */
    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final Product[] products) {
        boolean resultFlag = false;
        if (null != products && products.length > 0) {
            for (int i = 0; i < products.length; i++) {
                resultFlag = delete(products[i]);
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
    public boolean exist(Product product) {
        return productDao.exist(product);
    }
}
