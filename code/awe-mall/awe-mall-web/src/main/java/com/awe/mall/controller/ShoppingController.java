package com.awe.mall.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.domain.enums.ProductDictEnum;
import com.awe.mall.service.ProductBrandService;
import com.awe.mall.service.ProductCategoryService;
import com.awe.mall.service.ProductDictService;
import com.awe.mall.service.ProductSelectService;
import com.awe.mall.service.ProductService;
import com.awe.pms.sdk.request.dto.ProductRequestDto;
import com.awe.pms.sdk.request.dto.ProductSelectRequestDto;
import com.awe.pms.sdk.response.dto.ProductDictResponseDto;
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
	private ProductSelectService productSelectService;
	
	@Autowired
    private ProductBrandService productBrandService;
    
    @Autowired
    private ProductCategoryService productCategoryService;
    
    @Autowired
    private ProductDictService productDictService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(Model model) {
		initNavFlag(model);
		
		model.addAttribute("productCategorys", this.productCategoryService.queryProductCategoryList(null));
		model.addAttribute("productBrands", this.productBrandService.queryProductBrandList(null));
        return index(model);
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("go to index page");
        initNavFlag(model);
        return VIEW_WORKSPACE + VIEW_PRODUCT_INDEX_PAGE;
    }
    
    @RequestMapping(value = "shopping_list", method = RequestMethod.GET)
    public String list(Model model, ProductSelectRequestDto requestDto) {
    	logger.debug("go to list page");
    	initNavFlag(model);
    	
//		model.addAttribute("products", this.productService.queryProducts(requestDto));
		model.addAttribute("productSelects", this.productSelectService.queryProductSelects(requestDto));
    	model.addAttribute("productCategorys", this.productCategoryService.queryProductCategoryList(null));
		model.addAttribute("productBrands", this.productBrandService.queryProductBrandList(null));
    	return VIEW_WORKSPACE + VIEW_PRODUCT_LIST_PAGE;
    }
    
    @RequestMapping(value = "product_details", method = RequestMethod.GET)
    public String detail(Model model, ProductRequestDto requestDto, String currentSkuNo) {
    	logger.debug("go to detail page");
    	initNavFlag(model);
    	initAllProductDict(model);
    	
		ProductResponseDto responseDto = this.productService.getProduct(requestDto);
    	for (ProductSkuResponseDto skuResponseDto : responseDto.getProductSkuResponseDtos()) {
    		if (skuResponseDto.getSkuNo().equals(currentSkuNo)) {
    			model.addAttribute("currentProductSku", skuResponseDto);
    		}
    	}
    	
		model.addAttribute("product", responseDto);
    	model.addAttribute("productCategorys", this.productCategoryService.queryProductCategoryList(null));
    	model.addAttribute("productBrands", this.productBrandService.queryProductBrandList(null));
    	return VIEW_WORKSPACE + VIEW_PRODUCT_DETAIL_PAGE;
    }
    
    private void initNavFlag(Model model) {
    	model.addAttribute("navFlag", VIEW_PRODUCT_INDEX_PAGE);
    }
    
    private void initAllProductDict(Model model) {
    	List<ProductDictResponseDto> responseDtos = this.productDictService.queryProductDictList(null);
    	
    	Map<String, List<ProductDictResponseDto>> tempMap = new HashMap<String, List<ProductDictResponseDto>>();
    	for (ProductDictResponseDto prd : responseDtos) {
    		String key = ProductDictEnum.getAttrByType(prd.getType());
    		if (tempMap.containsKey(key)) {
				tempMap.get(key).add(prd);
    		} else {
    			List<ProductDictResponseDto> tempList = new ArrayList<ProductDictResponseDto>();
    			tempList.add(prd);
    			tempMap.put(key, tempList);
    		}
    	}
    	
		for (Map.Entry<String, List<ProductDictResponseDto>> map : tempMap.entrySet()) {
			model.addAttribute(map.getKey(), map.getValue());
		}
    }
}
