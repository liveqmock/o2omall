package com.awe.pms.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pms.domain.ProductBrand;
import com.awe.pms.domain.query.ProductBrandQuery;
import com.awe.pms.dao.ProductBrandDao;
import com.awe.pms.manager.ProductBrandManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ProductBrandManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
@Component
public class ProductBrandManagerImpl extends BaseManager implements ProductBrandManager {
	
    @Autowired
    private ProductBrandDao productBrandDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ProductBrand> productBrandList) {
        boolean resultFlag = false;
        if (null != productBrandList && productBrandList.size() > 0) {
            for (ProductBrand productBrand : productBrandList) {
                resultFlag = productBrandDao.insert(productBrand);
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
    public boolean insert(ProductBrand productBrand) {
        return productBrandDao.insert(productBrand);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ProductBrand productBrand) {
        return productBrandDao.update(productBrand);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductBrand> queryProductBrandList(ProductBrandQuery queryBean) {
        return productBrandDao.queryProductBrandList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductBrand> queryProductBrandListWithPage(ProductBrandQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ProductBrandQuery();
        }

        // 查询总数
        int totalItem = queryProductBrandCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return productBrandDao.queryProductBrandListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductBrandCount(ProductBrandQuery queryBean) {
        return productBrandDao.queryProductBrandCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductBrand productBrand) {
        return productBrandDao.delete(productBrand);
    }

    /**
     * {@inheritDoc}
     */
    public ProductBrand getProductBrandById(Long id) {
        return productBrandDao.getProductBrandById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ProductBrand[] productBrands) {
        boolean resultFlag = false;
        if (null != productBrands && productBrands.length > 0) {
            for (int i = 0; i < productBrands.length; i++) {
                resultFlag = delete(productBrands[i]);
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
    public boolean exist(ProductBrand productBrand) {
        return productBrandDao.exist(productBrand);
    }
}
