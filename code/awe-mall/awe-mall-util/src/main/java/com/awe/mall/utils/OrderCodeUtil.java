package com.awe.mall.utils;



public class  OrderCodeUtil {
	//生成订单号
	public static final String CodeUtil(Long userId,String Ip){
		String Id =String.valueOf(userId.hashCode());
		Ip =String.valueOf( Ip.hashCode());
		Ip = Ip.substring(Ip.length()-4, Ip.length());
		long tiem = System.currentTimeMillis();
		String orderNo = tiem+""+Ip+""+Id;
		return orderNo;
	}

}
