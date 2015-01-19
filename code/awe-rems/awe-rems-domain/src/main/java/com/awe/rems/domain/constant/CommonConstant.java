package com.awe.rems.domain.constant;

public class CommonConstant {

	/** 退货编码前缀 */
    public final static String TUIHUO_CODE_PREFIX = "T";
    /** 换货编码前缀 */
    public final static String HUANHUO_CODE_PREFIX = "H";
    /** 维修编码前缀 */
    public final static String WEIXU_CODE_PREFIX = "X";
    /**
     * 售后单审核状态
     *
     */
    public static class ReturnExchangeStatus{
    	/**用户已提交*/
    	public final static int USER_SUBMIT_STATUS = 10;
    	/**客服或商家审核通过*/
    	public final static int AUDIT_SUCCESS_STATUS = 20;
    	/**退款已提交*/
    	public final static int REFUND_SUBMIT_STATUS = 30;
    	/**完成*/
    	public final static int COMPLETE_STATUS = 40;
    	/**审核不通过*/
    	public final static int AUDIT_FAIL_STATUS = 25;
    	
    }
    /**
     * 服务类型
     */
    public static class ServiceType{
    	/**退货*/
    	public final static int T = 1;
    	/**换货*/
    	public final static int H = 2;
    	/**维修*/
    	public final static int X = 3;
	
    }
}
