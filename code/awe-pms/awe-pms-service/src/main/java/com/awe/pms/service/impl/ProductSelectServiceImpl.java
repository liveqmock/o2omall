package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pms.domain.Product;
import com.awe.pms.domain.ProductSelect;
import com.awe.pms.domain.ProductSku;
import com.awe.pms.domain.query.ProductQuery;
import com.awe.pms.domain.query.ProductSelectQuery;
import com.awe.pms.manager.ProductSelectManager;
import com.awe.pms.service.ProductSelectService;
import com.awe.pms.service.ProductService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ProductSelectService接口的实现类
 * 
 * @author ljz
 * @version 2015-1-21 10:47:32
 * 
 */
@Service
public class ProductSelectServiceImpl implements ProductSelectService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ProductSelectServiceImpl.class);

    @Autowired
    private ProductSelectManager productSelectManager;
    
    @Autowired
    private ProductService productService;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSelectService.batchInsert")
    public boolean insert(List<ProductSelect> productSelectList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(productSelectList)) {
                resultFlag = productSelectManager.insert(productSelectList);
            } else {
                LOG.warn("ProductSelectServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductSelectServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSelectService.insert")
    public boolean insert(ProductSelect productSelect) {
        boolean resultFlag = false;
        try {
            if (null != productSelect) {
                if (productSelectManager.exist(productSelect)) {
                    throw new ExistedException();
                }
                resultFlag = productSelectManager.insert(productSelect);
            } else {
                LOG.warn("ProductSelectServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ProductSelectServiceImpl#insert failed, productSelect has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ProductSelectServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSelectService.update")
    public boolean update(ProductSelect productSelect) {
        boolean resultFlag = false;
        try {
            if (null != productSelect && null != productSelect.getId()) {
                resultFlag = productSelectManager.update(productSelect);
            } else {
                LOG.warn("ProductSelectServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductSelectServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSelectService.queryProductSelectList")
    public List<ProductSelect> queryProductSelectList(ProductSelectQuery queryBean) {
        List<ProductSelect> productSelectList = null;
        try {
            productSelectList = productSelectManager.queryProductSelectList(queryBean);
        } catch (Exception e) {
            LOG.error("ProductSelectServiceImpl#queryProductSelectList has error.", e);
        }
        return productSelectList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSelectService.queryProductSelectListWithPage")
    public List<ProductSelect> queryProductSelectListWithPage(ProductSelectQuery queryBean, PageUtil pageUtil) {
        List<ProductSelect> productSelectList = null;
        try {
            productSelectList = productSelectManager.queryProductSelectListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ProductSelectServiceImpl#queryProductSelectListWithPage has error.", e);
        }
        return productSelectList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSelectService.delete")
    public boolean delete(ProductSelect productSelect) {
        boolean resultFlag = false;
        try {
            if (null != productSelect && null != productSelect.getId()) {
                resultFlag = productSelectManager.delete(productSelect);
            } else {
                LOG.warn("ProductSelectServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductSelectServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSelectService.batchDelete")
    public boolean delete(ProductSelect[] productSelects) {
        boolean resultFlag = false;
        try {
            if (null != productSelects && productSelects.length > 0) {
                resultFlag = productSelectManager.delete(productSelects);
            } else {
                LOG.warn("ProductSelectServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductSelectServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductSelectService.getProductSelectById")
    public ProductSelect getProductSelectById(Long id) {
        ProductSelect productSelect = null;
        try {
            if (null != id) {
                productSelect = productSelectManager.getProductSelectById(id);
            } else {
                LOG.warn("ProductSelectServiceImpl#getProductSelectById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductSelectServiceImpl#getProductSelectById has error.", e);
        }
        return productSelect;
    }

	public boolean addOrDelete(ProductSku productSku) {
		if (productSku != null && productSku.getSaleStatus() != null && StringUtils.isNotBlank(productSku.getProductNo())) {
			ProductSelect productSelect = new ProductSelect();
			if (productSku.getSaleStatus().equals(0)) {
				// 下架，删除信息
				productSelect.setSkuNo(productSku.getSkuNo());
				LOG.info("ProductSelectServiceImpl#addOrDelete 删除商品信息，SkuNo【" + productSku.getSkuNo() + "】");
				return this.productSelectManager.delete(productSelect);
			} else {
				LOG.info("ProductSelectServiceImpl#addOrDelete 增加商品信息，SkuNo【" + productSku.getSkuNo() + "】");
				// 获取商品对象
				ProductQuery queryBean = new ProductQuery();
				queryBean.setProductNo(productSku.getProductNo());
				List<Product> products = this.productService.queryProductList(queryBean);
				if (products != null && products.size() > 0) {
					Product product = products.get(0);
					// 设置商品对象
					productSelect.setProductNo(product.getProductNo());
					productSelect.setProductName(product.getProductName());
					productSelect.setCategoryOneId(product.getCategoryOneId());
					productSelect.setCategoryTwoId(product.getCategoryTwoId());
					productSelect.setCategoryThreeId(product.getCategoryThreeId());
					productSelect.setApplicableStep(product.getApplicableStep());
					productSelect.setBrandCode(product.getBrandCode());
					productSelect.setMode(product.getMode());
					productSelect.setIsRecommend(product.getLevel());
					
					// 设置商品SKU对象
					productSelect.setSkuNo(productSku.getSkuNo());
					productSelect.setSkuName(productSku.getSkuName());
					productSelect.setPrice(productSku.getPrice());
					productSelect.setSalePrice(productSku.getSalePrice());
					productSelect.setImgPath(productSku.getImgPath());
					productSelect.setSaleStatus(productSku.getSaleStatus());
					
					productSelect.setSaleQuantityTotal(0L);
					productSelect.setSaleQuantityWeek(0L);
					productSelect.setRecommendAmount(0L);
					productSelect.setHitCountTotal(0L);
					productSelect.setHitCountWeek(0L);
					
					return this.insert(productSelect);
				}
			}
		}
		return Boolean.FALSE;
	}
}

