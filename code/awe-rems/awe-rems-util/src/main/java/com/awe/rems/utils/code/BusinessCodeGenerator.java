package com.awe.rems.utils.code;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 编号生成器
 * @version 1.0.0.0
 * @since 2015-1-19
 */
public class BusinessCodeGenerator {
	
	private static final Log LOG = LogFactory.getLog(BusinessCodeGenerator.class);
    
	/** 0占位符 */
    private final static String PLACEHOLDER = "0";
	
    
    public static String getCode(String prefixStr, Long id, int codeLen){
    	return generateCode(prefixStr, id, codeLen);
    }
	/**
     * 
     * @param prefixStr
     *            编号前缀
     * @param id
     *            序列号
     * @param codeLen
     *            除编号前缀外长度
     * @return
     */
    public static String generateCode(String prefixStr, Long id, int codeLen) {
        if (null == id) {
        	LOG.error("Param id is null!");
            throw new IllegalArgumentException("Param id is null!");
        }
        StringBuilder code = new StringBuilder(prefixStr);

        if (codeLen <= 0) {
        	LOG.error("Param codeLen must > 0!");
            throw new IllegalArgumentException("Param codeLen must > 0!");
        }

        String srcStr = String.valueOf(id);

        // srcStr长度大于设定长度，取全部；若小于设定长度前面补“0”占位符
        if (srcStr.length() < codeLen) {
            for (int i = codeLen; i > srcStr.length(); i--) {
                code.append(PLACEHOLDER);
            }
        }
        code.append(srcStr);

        return code.toString();
    }
}
