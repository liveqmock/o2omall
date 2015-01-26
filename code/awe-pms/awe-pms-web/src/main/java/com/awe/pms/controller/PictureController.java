package com.awe.pms.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.awe.pms.controller.base.BaseController;
import com.awe.pms.utils.CompressPicUtil;
import com.hbird.common.utils.DateHelper;
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
	public Wrapper<?> upload(MultipartFile file, String filefolder, Integer type, HttpSession session, Model model) throws IOException {
		// 得到上传的文件
		// 得到上传服务器的路径
//		String path = session.getServletContext().getRealPath("/upload/");
		// 得到上传的文件的文件名
		String filename = DateHelper.getCurrentDateStr("yyyyMMddHHmmssSSS") + "_" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
		InputStream inputStream = file.getInputStream();
		
		CompressPicUtil.compressPic(inputStream, filefolder, filename, type);
		/*byte[] b = new byte[1048576];
		int length = inputStream.read(b);
		path += "\\" + filename;
		// 文件流写到服务器端
		FileOutputStream outputStream = new FileOutputStream(path);
		outputStream.write(b, 0, length);
		inputStream.close();
		outputStream.close();*/
		LOG.info(filefolder + filename);
		return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, filefolder + "/" + filename);
	}
}