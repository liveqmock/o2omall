package com.awe.pms.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.awe.pms.controller.base.BaseController;
import com.awe.pms.utils.CompressPicUtil;
import com.hbird.common.utils.DateHelper;
import com.hbird.common.utils.config.PropertiesHelper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ImgController ：图片控制器
 * 
 * @author ljz
 * @version 2014-12-25 14:47:32
 */
@Controller
@RequestMapping("picture")
public class PictureController extends BaseController {

	private static final Log LOG = LogFactory.getLog(PictureController.class);
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public Wrapper<?> upload(MultipartFile file, String keyFolder, String fileFolder, Integer type) throws IOException {
		
		String imgPath = this.uploadImgFile(file, keyFolder, fileFolder, type);
		return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, imgPath);
	}
	
	@RequestMapping(value = "uploadProduct", method = RequestMethod.POST)
	@ResponseBody
	public String uploadProduct(MultipartFile upload, String keyFolder, String fileFolder, Integer type, String CKEditorFuncNum) throws IOException {
		
		String imgPath = this.uploadImgFile(upload, keyFolder, fileFolder, type);
		StringBuffer result = new StringBuffer();
		result.append("<script type=\"text/javascript\">")
				.append("window.parent.CKEDITOR.tools.callFunction("+ CKEditorFuncNum + ",'" + imgPath + "','')") 
				.append("</script>");
		
		return result.toString();
	}
	
	private String uploadImgFile(MultipartFile file, String keyFolder, String fileFolder, Integer type) throws IOException {
		if (file == null) {
			LOG.error("PictureController#uploadImgFile file is null");
			return null;
		}
		if (StringUtils.isNotBlank(keyFolder)) {
			fileFolder = keyFolder + "/" + fileFolder + "/";
		}
		
		InputStream inputStream = file.getInputStream();
		String originalFilename = file.getOriginalFilename();
		fileFolder += originalFilename.substring(0, originalFilename.lastIndexOf(".")) + "/";
		String filename = DateHelper.getCurrentDateStr("yyyyMMddHHmmssSSS") + "_" + originalFilename;
		CompressPicUtil.newInstance().compressPic(inputStream, fileFolder, filename);
		String pictureUrl = PropertiesHelper.newInstance().getValue("picture.url");
		String imgPath = pictureUrl + fileFolder + type + "/" + filename;
		LOG.info(imgPath);
		return imgPath;
	}
}
