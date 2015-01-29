package com.awe.pms.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author zhc
 * @email you know
 * @version 2015-1-21 下午09:58:03
 */
public class CompressPicUtil {
	
	private static final Log LOG = LogFactory.getLog(CompressPicUtil.class);
	
	private List<Integer> compressTypeList = new ArrayList<Integer>();
	
	private static CompressPicUtil compressPicUtil;
	
	private CompressPicUtil() {
		compressTypeList.add(200);
		compressTypeList.add(750);
		compressTypeList.add(800);
	}
	
	public static CompressPicUtil newInstance() {
		if (null == CompressPicUtil.compressPicUtil) {
			CompressPicUtil.compressPicUtil = new CompressPicUtil();
		}
		
		return CompressPicUtil.compressPicUtil;
	}

	public boolean compressPic(InputStream inputStream, String outputDir, String outputFileName) {
		// 生成三种形式
		ByteArrayOutputStream tempOut = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		int tempByte = 0;
		try {
			while ((tempByte = inputStream.read(buff, 0, 1024)) > 0) {  
				tempOut.write(buff, 0, tempByte);  
			}
			for (Integer type : compressTypeList) {
				ByteArrayInputStream in = new ByteArrayInputStream(tempOut.toByteArray());
				BufferedInputStream inStream = new BufferedInputStream(in);
				compressPic(inStream, outputDir + type + "/", outputFileName, type,
						type, Boolean.TRUE);
			}
		} catch (IOException e) {
			e.printStackTrace();
			LOG.error("compressPic boolean ERROR:", e);
		} finally {
			if (tempOut != null) {
				try {
					tempOut.close();
				} catch (IOException e) {
					LOG.error("compressPic tempOut.close ERROR:", e);
				}
			}
		}
		
		return Boolean.TRUE;
	}

	public String compressPic(InputStream inputStream, String outputDir, String outputFileName, int type) {
		String result = null;
		if (type != 0) {
			result = compressPic(inputStream, outputDir, outputFileName, type, type, Boolean.TRUE);
		}
		return result;
	}

	// 图片处理
	public String compressPic(InputStream inputStream, String outputDir, String outputFileName, int width,
			int height, boolean proportion) {
		try {
			// 获得源文件
			Image img = ImageIO.read(inputStream);
			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
				LOG.info(" can't read,retry!" + "<BR>");
				System.out.println(" can't read,retry!" + "<BR>");
				return "no";
			} else {
				int newWidth;
				int newHeight;
				// 判断是否是等比缩放
				if (proportion) {
					// 为等比缩放计算输出的图片宽度及高度
					double rate1 = ((double) img.getWidth(null)) / (double) width + 0.1;
					double rate2 = ((double) img.getHeight(null)) / (double) height + 0.1;
					// 根据缩放比率大的进行缩放控制
					double rate = rate1 > rate2 ? rate1 : rate2;
					newWidth = (int) (((double) img.getWidth(null)) / rate);
					newHeight = (int) (((double) img.getHeight(null)) / rate);
				} else {
					newWidth = width; // 输出的图片宽度
					newHeight = height; // 输出的图片高度
				}
				BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);

				/*
				 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
				 */
				tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);

				ByteArrayOutputStream out = new ByteArrayOutputStream();
				// JPEGImageEncoder可适用于其他图片类型的转换
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag);

				ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
				BufferedInputStream inStream = new BufferedInputStream(in);
				
				sendFtp(inStream, outputDir, outputFileName);

				out.close();
			}
		} catch (IOException ex) {
			LOG.error("compressPic ERROR:", ex);
		}
		return "ok";
	}

	public void sendFtp(InputStream inputStream, String outputDir, String outputFileName) {
		// 创建ftp客户端
		FTPClient ftpClient = new FTPClient();
		ftpClient.setControlEncoding("UTF-8");
		String hostname = "123.56.112.254";
		int port = 21;
		String username = "picture";
		String password = "1qaz2wsx!";
		try {
			// 链接ftp服务器
			ftpClient.connect(hostname, port);
			// 登录ftp
			ftpClient.login(username, password);
			int reply = ftpClient.getReplyCode();
			LOG.info(" ftpClient.login reply 【" + reply + "】");
			// 如果reply返回230就算成功了，如果返回530密码用户名错误或当前用户无权限下面有详细的解释。
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				return;
			}
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();

			// 在root目录下创建文件夹
			String outputPath = "/hbird/deployment/picture/";
			if (StringUtils.isNotBlank(outputDir)) {
				String[] outputDirs = outputDir.split("/");
				for (String output : outputDirs) {
					outputPath += output + "/";
					ftpClient.makeDirectory(outputPath);
				}
			}
			
			// set timeout to 5 minutes
			ftpClient.setControlKeepAliveTimeout(300);

			String remoteFileName = "./" + outputDir + outputFileName;
			// 文件你若是不指定就会上传到root目录下
			boolean result = ftpClient.storeFile(remoteFileName, inputStream);
//			boolean result = ftpClient.storeFile(new String(remoteFileName.getBytes("UTF-8"),"ISO-8859-1"), inputStream);
			
			LOG.info("ftpClient.storeFile result:" + result);
			
			inputStream.close();
			ftpClient.logout();

		} catch (SocketException e) {
			e.printStackTrace();
			LOG.error("ftpClient.connect ERROR:", e);
		} catch (IOException e) {
			e.printStackTrace();
			LOG.error("ftpClient.connect ERROR:", e);
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
					LOG.error("ftpClient.disConnect ERROR:", ioe);
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("E:/test/r10.jpg");
		InputStream inputStream = new FileInputStream(file);
		
		String outputDir = "product";
		CompressPicUtil.newInstance().sendFtp(inputStream, outputDir, file.getName());
	}

}
