package com.awe.pms.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pms.domain.ProductSelect;
import com.awe.pms.domain.query.ProductSelectQuery;
import com.awe.pms.dao.ProductSelectDao;
import com.awe.pms.manager.ProductSelectManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ProductSelectManager接口的实现类
 * 
 * @author ljz
 * @version 2015-1-21 10:47:32
 * 
 */
@Component
public class ProductSelectManagerImpl extends BaseManager implements ProductSelectManager {
	
    @Autowired
    private ProductSelectDao productSelectDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ProductSelect> productSelectList) {
        boolean resultFlag = false;
        if (null != productSelectList && productSelectList.size() > 0) {
            for (ProductSelect productSelect : productSelectList) {
                resultFlag = productSelectDao.insert(productSelect);
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
    public boolean insert(ProductSelect productSelect) {
        return productSelectDao.insert(productSelect);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ProductSelect productSelect) {
        return productSelectDao.update(productSelect);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductSelect> queryProductSelectList(ProductSelectQuery queryBean) {
        return productSelectDao.queryProductSelectList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductSelect> queryProductSelectListWithPage(ProductSelectQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ProductSelectQuery();
        }

        // 查询总数
        int totalItem = queryProductSelectCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return productSelectDao.queryProductSelectListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductSelectCount(ProductSelectQuery queryBean) {
        return productSelectDao.queryProductSelectCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductSelect productSelect) {
        return productSelectDao.delete(productSelect);
    }

    /**
     * {@inheritDoc}
     */
    public ProductSelect getProductSelectById(Long id) {
        return productSelectDao.getProductSelectById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ProductSelect[] productSelects) {
        boolean resultFlag = false;
        if (null != productSelects && productSelects.length > 0) {
            for (int i = 0; i < productSelects.length; i++) {
                resultFlag = delete(productSelects[i]);
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
    public boolean exist(ProductSelect productSelect) {
        return productSelectDao.exist(productSelect);
    }
}
