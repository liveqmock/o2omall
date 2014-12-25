package com.awe.pms.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pms.domain.ProductDict;
import com.awe.pms.domain.query.ProductDictQuery;
import com.awe.pms.dao.ProductDictDao;
import com.awe.pms.manager.ProductDictManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ProductDictManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 9:31:54
 * 
 */
@Component
public class ProductDictManagerImpl extends BaseManager implements ProductDictManager {
	
    @Autowired
    private ProductDictDao productDictDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ProductDict> productDictList) {
        boolean resultFlag = false;
        if (null != productDictList && productDictList.size() > 0) {
            for (ProductDict productDict : productDictList) {
                resultFlag = productDictDao.insert(productDict);
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
    public boolean insert(ProductDict productDict) {
        return productDictDao.insert(productDict);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ProductDict productDict) {
        return productDictDao.update(productDict);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductDict> queryProductDictList(ProductDictQuery queryBean) {
        return productDictDao.queryProductDictList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductDict> queryProductDictListWithPage(ProductDictQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ProductDictQuery();
        }

        // 查询总数
        int totalItem = queryProductDictCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return productDictDao.queryProductDictListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductDictCount(ProductDictQuery queryBean) {
        return productDictDao.queryProductDictCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductDict productDict) {
        return productDictDao.delete(productDict);
    }

    /**
     * {@inheritDoc}
     */
    public ProductDict getProductDictById(Long id) {
        return productDictDao.getProductDictById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ProductDict[] productDicts) {
        boolean resultFlag = false;
        if (null != productDicts && productDicts.length > 0) {
            for (int i = 0; i < productDicts.length; i++) {
                resultFlag = delete(productDicts[i]);
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
    public boolean exist(ProductDict productDict) {
        return productDictDao.exist(productDict);
    }
}
