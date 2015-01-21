package com.awe.pms.service;

import java.util.List;

import com.awe.pms.domain.ProductSelect;
import com.awe.pms.domain.ProductSku;
import com.awe.pms.domain.query.ProductSelectQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * ProductSelectService接口
 * 
 * @author ljz
 * @version 2015-1-21 10:47:32
 * 
 */
public interface ProductSelectService {

    /**
     * 批量增加对象信息
     * 
     * @param productSelectList
     * @return
     */
    public boolean insert(List<ProductSelect> productSelectList);

    /**
     * 单个增加对象信息
     * 
     * @param productSelect
     * @return
     */
    public boolean insert(ProductSelect productSelect);

    /**
     * 更新 对象信息
     * 
     * @param productSelect
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ProductSelect productSelect);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductSelect> queryProductSelectList(ProductSelectQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ProductSelect> queryProductSelectListWithPage(ProductSelectQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param productSelect
     *            　
     * @return
     */
    public boolean delete(ProductSelect productSelect);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ProductSelect getProductSelectById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param productSelects
     *            ProductSelect集合
     * @return
     */
    public boolean delete(ProductSelect[] productSelects);

	/**
	 * 新增或者删除商品
	 * @param productSku
	 * @return
	 */
	public boolean addOrDelete(ProductSku productSku);
}
