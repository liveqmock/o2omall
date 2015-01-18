package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.pms.domain.ProductCategory;
import com.awe.pms.domain.enums.ProductCategoryEnum;
import com.awe.pms.domain.query.BusinessInfoQuery;
import com.awe.pms.domain.query.ProductBrandQuery;
import com.awe.pms.domain.query.ProductCategoryQuery;
import com.awe.pms.domain.query.ProductQuery;
import com.awe.pms.domain.query.ProductTaxRateQuery;
import com.awe.pms.manager.BusinessInfoManager;
import com.awe.pms.manager.ProductBrandManager;
import com.awe.pms.manager.ProductCategoryManager;
import com.awe.pms.manager.ProductManager;
import com.awe.pms.manager.ProductTaxRateManager;
import com.awe.pms.service.ProductCategoryService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
 
/**
 * ProductCategoryService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ProductCategoryServiceImpl.class);

    @Autowired
    private ProductCategoryManager productCategoryManager;
    
    @Autowired
    private ProductManager productManager;
    
    @Autowired
    private ProductBrandManager productBrandManager;
    
    @Autowired
    private BusinessInfoManager businessInfoManager;
    
    @Autowired
    private ProductTaxRateManager productTaxRateManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.batchInsert")
    public boolean insert(List<ProductCategory> productCategoryList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(productCategoryList)) {
                resultFlag = productCategoryManager.insert(productCategoryList);
            } else {
                LOG.warn("ProductCategoryServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.insert")
    public boolean insert(ProductCategory productCategory) {
        boolean resultFlag = false;
        try {
            if (null != productCategory) {
                if (productCategoryManager.exist(productCategory)) {
                    throw new ExistedException();
                }
                resultFlag = productCategoryManager.insert(productCategory);
            } else {
                LOG.warn("ProductCategoryServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ProductCategoryServiceImpl#insert failed, productCategory has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.update")
    public boolean update(ProductCategory productCategory) {
        boolean resultFlag = false;
        try {
            if (null != productCategory && null != productCategory.getId()) {
                resultFlag = productCategoryManager.update(productCategory);
            } else {
                LOG.warn("ProductCategoryServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.queryProductCategoryList")
    public List<ProductCategory> queryProductCategoryList(ProductCategoryQuery queryBean) {
        List<ProductCategory> productCategoryList = null;
        try {
            productCategoryList = productCategoryManager.queryProductCategoryList(queryBean);
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#queryProductCategoryList has error.", e);
        }
        return productCategoryList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.queryProductCategoryListWithPage")
    public List<ProductCategory> queryProductCategoryListWithPage(ProductCategoryQuery queryBean, PageUtil pageUtil) {
        List<ProductCategory> productCategoryList = null;
        try {
            productCategoryList = productCategoryManager.queryProductCategoryListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#queryProductCategoryListWithPage has error.", e);
        }
        return productCategoryList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.delete")
    public boolean delete(ProductCategory productCategory) {
        boolean resultFlag = false;
        try {
            if (null != productCategory && null != productCategory.getId() && null != productCategory.getLevel()) {
            	Long id = productCategory.getId();
            	Integer level = productCategory.getLevel();
				// 查询是否有引用
            	ProductCategoryQuery queryBean = new ProductCategoryQuery();
            	queryBean.setFid(id);
            	int resultCount = this.productCategoryManager.queryProductCategoryCount(queryBean);
            	if (resultCount == 0) {
					// 验证是否有品牌信息
            		ProductBrandQuery productBrandQueryBean = new ProductBrandQuery();
            		if (level == ProductCategoryEnum.CATEGORY_ONE.getKey()) {
            			productBrandQueryBean.setCategoryOneId(id);
            		} else if (level == ProductCategoryEnum.CATEGORY_TWO.getKey()) {
            			productBrandQueryBean.setCategoryTwoId(id);
            		} else if (level == ProductCategoryEnum.CATEGORY_THREE.getKey()) {
            			productBrandQueryBean.setCategoryThreeId(id);
            		}
            		resultCount = this.productBrandManager.queryProductBrandCount(productBrandQueryBean);
            		if (resultCount == 0) {
            			// 验证是否含有商家信息
            			BusinessInfoQuery businessInfoQueryBean = new BusinessInfoQuery();
            			if (level == ProductCategoryEnum.CATEGORY_ONE.getKey()) {
            				businessInfoQueryBean.setCategoryOneId(id);
        				} else if (level == ProductCategoryEnum.CATEGORY_TWO.getKey()) {
        					businessInfoQueryBean.setCategoryTwoId(id);
        				} else if (level == ProductCategoryEnum.CATEGORY_THREE.getKey()) {
        					businessInfoQueryBean.setCategoryThreeId(id);
        				}
            			resultCount = this.businessInfoManager.queryBusinessInfoCount(businessInfoQueryBean );
            			if (resultCount == 0) {
            				// 验证是否设置税率
            				ProductTaxRateQuery productTaxRateQueryBean = new ProductTaxRateQuery();
            				if (level == ProductCategoryEnum.CATEGORY_ONE.getKey()) {
            					productTaxRateQueryBean.setCategoryOneId(id);
            				} else if (level == ProductCategoryEnum.CATEGORY_TWO.getKey()) {
            					productTaxRateQueryBean.setCategoryTwoId(id);
            				} else if (level == ProductCategoryEnum.CATEGORY_THREE.getKey()) {
            					productTaxRateQueryBean.setCategoryThreeId(id);
            				}
            				resultCount = this.productTaxRateManager.queryProductTaxRateCount(productTaxRateQueryBean );
            				if (resultCount == 0) {
            					// 验证是否有商品信息
            					ProductQuery productQueryBean = new ProductQuery();
            					if (level == ProductCategoryEnum.CATEGORY_ONE.getKey()) {
            						productQueryBean.setCategoryOneId(id);
            					} else if (level == ProductCategoryEnum.CATEGORY_TWO.getKey()) {
            						productQueryBean.setCategoryTwoId(id);
            					} else if (level == ProductCategoryEnum.CATEGORY_THREE.getKey()) {
            						productQueryBean.setCategoryThreeId(id);
            					}
            					resultCount = this.productManager.queryProductCount(productQueryBean);
            					if (resultCount == 0) {
            						resultFlag = productCategoryManager.delete(productCategory);
            					}
            				}
            			}
            		}
            	}
            } else {
                LOG.warn("ProductCategoryServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.batchDelete")
    public boolean delete(ProductCategory[] productCategorys) {
        boolean resultFlag = false;
        try {
            if (null != productCategorys && productCategorys.length > 0) {
                resultFlag = productCategoryManager.delete(productCategorys);
            } else {
                LOG.warn("ProductCategoryServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ProductCategoryService.getProductCategoryById")
    public ProductCategory getProductCategoryById(Long id) {
        ProductCategory productCategory = null;
        try {
            if (null != id) {
                productCategory = productCategoryManager.getProductCategoryById(id);
            } else {
                LOG.warn("ProductCategoryServiceImpl#getProductCategoryById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ProductCategoryServiceImpl#getProductCategoryById has error.", e);
        }
        return productCategory;
    }
}

