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
import com.awe.mall.service.SkuImagesService;
import com.awe.pms.sdk.request.dto.ProductBrandRequestDto;
import com.awe.pms.sdk.request.dto.ProductRequestDto;
import com.awe.pms.sdk.request.dto.ProductSelectRequestDto;
import com.awe.pms.sdk.request.dto.SkuImagesRequestDto;
import com.awe.pms.sdk.response.dto.ProductBrandResponseDto;
import com.awe.pms.sdk.response.dto.ProductCategoryResponseDto;
import com.awe.pms.sdk.response.dto.ProductDictResponseDto;
import com.awe.pms.sdk.response.dto.ProductResponseDto;
import com.awe.pms.sdk.response.dto.ProductSelectResponseDto;
import com.awe.pms.sdk.response.dto.ProductSkuResponseDto;
import com.awe.pms.sdk.response.dto.SkuImagesResponseDto;
import com.hbird.common.utils.page.PageUtil;

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
    
    @Autowired
    private SkuImagesService skuImagesService;
	
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
    
    @RequestMapping(value = "shopping_list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Model model, ProductSelectRequestDto requestDto, PageUtil pageUtil) {
    	logger.debug("go to list page");
    	initNavFlag(model);
    	
    	model.addAttribute("pageUtil", pageUtil);
    	model.addAttribute("requestDto", requestDto);
    	// 商品列表
    	List<ProductSelectResponseDto> responseDtos = this.productSelectService.getProductSelectsWithPage(requestDto, pageUtil);
		model.addAttribute("productSelects", responseDtos);
		
		// tempQuery
		ProductSelectRequestDto tempDto = new ProductSelectRequestDto();
		// 每周热销排行
		tempDto.setOrderDesc("saleQuantityWeek");
		model.addAttribute("productSaleQuantityWeeks", this.productSelectService.getProductSelectsWithPage(tempDto, new PageUtil(1, 10)));
		
		// 热点排行
//		tempDto.setBrandCode(requestDto.getBrandCode());
		tempDto.setCategoryOneId(requestDto.getCategoryOneId());
		tempDto.setCategoryTwoId(requestDto.getCategoryTwoId());
		tempDto.setOrderDesc("hitCountTotal");
		PageUtil tempPageUtil = new PageUtil(1, 3);
		model.addAttribute("productHitCounts", this.productSelectService.getProductSelectsWithPage(tempDto, tempPageUtil));
    	model.addAttribute("tempPageUtil", tempPageUtil);
		
    	// 类别
    	List<ProductCategoryResponseDto> categoryResponseDtos = this.productCategoryService.queryProductCategoryList(null);
    	for (ProductCategoryResponseDto categoryResponseDto : categoryResponseDtos) {
    		if (categoryResponseDto.getId().equals(requestDto.getCategoryTwoId())) {
    			model.addAttribute("categoryTwo", categoryResponseDto.getName());
    			break;
    		}
    	}
    	model.addAttribute("productCategorys", categoryResponseDtos);
    	
    	// 品牌
    	ProductBrandRequestDto brandRequestDto = new ProductBrandRequestDto();
    	brandRequestDto.setCategoryOneId(requestDto.getCategoryOneId());
    	brandRequestDto.setCategoryTwoId(requestDto.getCategoryTwoId());
    	List<ProductBrandResponseDto> productBrands = this.productBrandService.queryProductBrandList(brandRequestDto);
    	
    	String brandName = null;
    	if (productBrands != null && productBrands.size() > 0) {
    		for (ProductBrandResponseDto responseDto : productBrands) {
				if (responseDto.getBrandCode().equals(requestDto.getBrandCode())) {
					brandName = responseDto.getBrandName();
					break;
				}
    		}
    	}
    	model.addAttribute("brandName", brandName);
		model.addAttribute("productBrands", productBrands);
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
    	
    	SkuImagesRequestDto skuImagesRequestDto = new SkuImagesRequestDto();
    	skuImagesRequestDto.setSkuNo(currentSkuNo);
    	List<SkuImagesResponseDto> skuImagesResponseDtos = this.skuImagesService.querySkuImageList(skuImagesRequestDto);
    	
    	if (skuImagesResponseDtos != null && skuImagesResponseDtos.size() > 0) {
    		model.addAttribute("primarySkuImage", skuImagesResponseDtos.get(0));
    		model.addAttribute("skuImageList", skuImagesResponseDtos);
    	}
    	
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
