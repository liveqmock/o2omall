package com.awe.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.ProductBrandService;
import com.awe.mall.service.ProductCategoryService;

/**
 * @author zhc
 * @email  you know
 * @version 2015-1-2 下午07:22:59 
 */
@Controller
@RequestMapping("shopping")
public class ShoppingController extends BaseController {

	private static final String VIEW_WORKSPACE = "shopping/";
	private static final String VIEW_PRODUCT_INDEX_PAGE = "shopping";
	private static final String VIEW_PRODUCT_LIST_PAGE = "shopping_list";
	private static final String VIEW_PRODUCT_DETAIL_PAGE = "product_details";
	
	@Autowired
    private ProductBrandService productBrandService;
    
    @Autowired
    private ProductCategoryService productCategoryService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(Model model) {
		model.addAttribute("productCategorys", this.productCategoryService.queryProductCategoryList(null));
		model.addAttribute("productBrands", this.productBrandService.queryProductBrandList(null));
        return index(model);
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("go to index page");
        model.addAttribute("navFlag", VIEW_PRODUCT_INDEX_PAGE);
        return VIEW_WORKSPACE + VIEW_PRODUCT_INDEX_PAGE;
    }
    
    @RequestMapping(value = "shopping_list", method = RequestMethod.GET)
    public String list(Model model) {
    	logger.debug("go to list page");
    	model.addAttribute("navFlag", VIEW_PRODUCT_INDEX_PAGE);
    	
    	model.addAttribute("productCategorys", this.productCategoryService.queryProductCategoryList(null));
		model.addAttribute("productBrands", this.productBrandService.queryProductBrandList(null));
    	return VIEW_WORKSPACE + VIEW_PRODUCT_LIST_PAGE;
    }
    
    @RequestMapping(value = "product_details", method = RequestMethod.GET)
    public String detail(Model model) {
    	logger.debug("go to detail page");
    	model.addAttribute("navFlag", VIEW_PRODUCT_INDEX_PAGE);
    	
    	model.addAttribute("productCategorys", this.productCategoryService.queryProductCategoryList(null));
    	model.addAttribute("productBrands", this.productBrandService.queryProductBrandList(null));
    	return VIEW_WORKSPACE + VIEW_PRODUCT_DETAIL_PAGE;
    }
}
