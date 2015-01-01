package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.pms.domain.ProductDict;
import com.awe.pms.domain.query.ProductDictQuery;
import com.awe.pms.manager.ProductDictManager;
import com.awe.pms.service.ProductDictService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
 
/**
 * ProductDictService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
@Service
public class ProductDictServiceImpl implements ProductDictService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ProductDictServiceImpl.class);

    @Autowired
    private ProductDictManager productDictManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductDictService.batchInsert")
    public boolean insert(List<ProductDict> productDictList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(productDictList)) {
                resultFlag = productDictManager.insert(productDictList);
            } else {
                LOG.warn("ProductDictServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductDictServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductDictService.insert")
    public boolean insert(ProductDict productDict) {
        boolean resultFlag = false;
        try {
            if (null != productDict) {
                if (productDictManager.exist(productDict)) {
                    throw new ExistedException();
                }
                resultFlag = productDictManager.insert(productDict);
            } else {
                LOG.warn("ProductDictServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ProductDictServiceImpl#insert failed, productDict has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ProductDictServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductDictService.update")
    public boolean update(ProductDict productDict) {
        boolean resultFlag = false;
        try {
            if (null != productDict && null != productDict.getId()) {
                resultFlag = productDictManager.update(productDict);
            } else {
                LOG.warn("ProductDictServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductDictServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductDictService.queryProductDictList")
    public List<ProductDict> queryProductDictList(ProductDictQuery queryBean) {
        List<ProductDict> productDictList = null;
        try {
            productDictList = productDictManager.queryProductDictList(queryBean);
        } catch (Exception e) {
            LOG.error("ProductDictServiceImpl#queryProductDictList has error.", e);
        }
        return productDictList;
    }
    
    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductDictService.getPmsTypeDict")
    public List<ProductDict> getPmsTypeDict(int type) {
    	if (type < 0) {
    		return null;
    	}
    	List<ProductDict> productDictList = null;
    	try {
        	ProductDictQuery queryBean = new ProductDictQuery();
        	queryBean.setType(type);
    		productDictList = productDictManager.queryProductDictList(queryBean);
    	} catch (Exception e) {
    		LOG.error("ProductDictServiceImpl#queryProductDictList has error.", e);
    	}
    	return productDictList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductDictService.queryProductDictListWithPage")
    public List<ProductDict> queryProductDictListWithPage(ProductDictQuery queryBean, PageUtil pageUtil) {
        List<ProductDict> productDictList = null;
        try {
            productDictList = productDictManager.queryProductDictListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ProductDictServiceImpl#queryProductDictListWithPage has error.", e);
        }
        return productDictList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductDictService.delete")
    public boolean delete(ProductDict productDict) {
        boolean resultFlag = false;
        try {
            if (null != productDict && null != productDict.getId()) {
                resultFlag = productDictManager.delete(productDict);
            } else {
                LOG.warn("ProductDictServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductDictServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductDictService.batchDelete")
    public boolean delete(ProductDict[] productDicts) {
        boolean resultFlag = false;
        try {
            if (null != productDicts && productDicts.length > 0) {
                resultFlag = productDictManager.delete(productDicts);
            } else {
                LOG.warn("ProductDictServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductDictServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductDictService.getProductDictById")
    public ProductDict getProductDictById(Long id) {
        ProductDict productDict = null;
        try {
            if (null != id) {
                productDict = productDictManager.getProductDictById(id);
            } else {
                LOG.warn("ProductDictServiceImpl#getProductDictById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductDictServiceImpl#getProductDictById has error.", e);
        }
        return productDict;
    }
}

