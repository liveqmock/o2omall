package com.awe.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.ProductBrandService;
import com.awe.mall.service.ProductCategoryService;
import com.awe.mall.service.ProductService;
import com.awe.pms.sdk.request.dto.ProductRequestDto;
import com.awe.pms.sdk.response.dto.ProductResponseDto;
import com.awe.pms.sdk.response.dto.ProductSkuResponseDto;

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
	private ProductService productService;
	
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
    public String list(Model model, ProductRequestDto requestDto) {
    	logger.debug("go to list page");
    	model.addAttribute("navFlag", VIEW_PRODUCT_INDEX_PAGE);
    	
		model.addAttribute("products", this.productService.queryProducts(requestDto));
    	model.addAttribute("productCategorys", this.productCategoryService.queryProductCategoryList(null));
		model.addAttribute("productBrands", this.productBrandService.queryProductBrandList(null));
    	return VIEW_WORKSPACE + VIEW_PRODUCT_LIST_PAGE;
    }
    
    @RequestMapping(value = "product_details", method = RequestMethod.GET)
    public String detail(Model model, ProductRequestDto requestDto, String currentSkuNo) {
    	logger.debug("go to detail page");
    	model.addAttribute("navFlag", VIEW_PRODUCT_INDEX_PAGE);
    	
    	ProductResponseDto responseDto = this.productService.getProduct(requestDto);
    	for (ProductSkuResponseDto skuResponseDto : responseDto.getProductSkuResponseDtos()) {
    		if (skuResponseDto.getSkuNo().equals(currentSkuNo)) {
    			model.addAttribute("currentProductSku", skuResponseDto);
    		}
    	}
    	
		model.addAttribute("product", this.productService.getProduct(requestDto));
    	model.addAttribute("productCategorys", this.productCategoryService.queryProductCategoryList(null));
    	model.addAttribute("productBrands", this.productBrandService.queryProductBrandList(null));
    	return VIEW_WORKSPACE + VIEW_PRODUCT_DETAIL_PAGE;
    }
}
