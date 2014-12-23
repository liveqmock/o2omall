package com.awe.pms.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pms.domain.ProductSku;
import com.awe.pms.domain.query.ProductSkuQuery;
import com.awe.pms.dao.ProductSkuDao;
import com.awe.pms.manager.ProductSkuManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ProductSkuManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
 * 
 */
@Component
public class ProductSkuManagerImpl extends BaseManager implements ProductSkuManager {
	
    @Autowired
    private ProductSkuDao productSkuDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ProductSku> productSkuList) {
        boolean resultFlag = false;
        if (null != productSkuList && productSkuList.size() > 0) {
            for (ProductSku productSku : productSkuList) {
                resultFlag = productSkuDao.insert(productSku);
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
    public boolean insert(ProductSku productSku) {
        return productSkuDao.insert(productSku);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ProductSku productSku) {
        return productSkuDao.update(productSku);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductSku> queryProductSkuList(ProductSkuQuery queryBean) {
        return productSkuDao.queryProductSkuList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductSku> queryProductSkuListWithPage(ProductSkuQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ProductSkuQuery();
        }

        // 查询总数
        int totalItem = queryProductSkuCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return productSkuDao.queryProductSkuListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductSkuCount(ProductSkuQuery queryBean) {
        return productSkuDao.queryProductSkuCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductSku productSku) {
        return productSkuDao.delete(productSku);
    }

    /**
     * {@inheritDoc}
     */
    public ProductSku getProductSkuById(Long id) {
        return productSkuDao.getProductSkuById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ProductSku[] productSkus) {
        boolean resultFlag = false;
        if (null != productSkus && productSkus.length > 0) {
            for (int i = 0; i < productSkus.length; i++) {
                resultFlag = delete(productSkus[i]);
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
    public boolean exist(ProductSku productSku) {
        return productSkuDao.exist(productSku);
    }
}
