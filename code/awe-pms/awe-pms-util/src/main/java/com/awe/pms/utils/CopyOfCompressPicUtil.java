package com.awe.pms.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import javax.imageio.ImageIO;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author zhc
 * @email  you know
 * @version 2015-1-21 下午09:58:03 
 */
public class CopyOfCompressPicUtil {
	
	public static String compressPic(InputStream inputStream, String outputDir, String outputFileName) {
		return compressPic(inputStream, outputDir, outputFileName, 1);
	}
	
	public static String compressPic(InputStream inputStream, String outputDir, String outputFileName, int type) {
		String result = null;
		if (type == 1) {
			result = compressPic(inputStream, outputDir, outputFileName, 200, 200, Boolean.TRUE);
		} else if (type == 2) {
			result = compressPic(inputStream, outputDir, outputFileName, 440, 450, Boolean.TRUE);
		} else if (type == 3) {
			result = compressPic(inputStream, outputDir, outputFileName, 800, 600, Boolean.TRUE);
		}
		return result;
	}

	
	// 图片处理
	public static String compressPic(InputStream inputStream, String outputDir, String outputFileName, int width, int height, boolean proportion) {
		try {
			// 获得源文件
			Image img = ImageIO.read(inputStream);
			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
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
				OutputStream out = new FileOutputStream(outputDir + "/" + outputFileName);
				// JPEGImageEncoder可适用于其他图片类型的转换
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag);
				out.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return "ok";
	}
	
	public static void sendFtp() {
		File imagefile = new File("D:/var/iosclient.jpg");
		String imagefileFileName = "苹果.jpg";
		// 创建ftp客户端
		FTPClient ftpClient = new FTPClient();
		ftpClient.setControlEncoding("GBK");
		String hostname = "192.168.xx.xx";
		int port = 21;
		String username = "root";
		String password = "rytongxxxxxxx";
		try {
			// 链接ftp服务器
			ftpClient.connect(hostname, port);
			// 登录ftp
			ftpClient.login(username, password);
			int reply = ftpClient.getReplyCode();
			System.out.println(reply);
			// 如果reply返回230就算成功了，如果返回530密码用户名错误或当前用户无权限下面有详细的解释。
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				return;
			}
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

			ftpClient.makeDirectory("path");// 在root目录下创建文件夹
			String remoteFileName = System.currentTimeMillis() + "_" + imagefileFileName;
			InputStream input = new FileInputStream(imagefile);
			ftpClient.storeFile(remoteFileName, input);// 文件你若是不指定就会上传到root目录下
			input.close();
			ftpClient.logout();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}
}
