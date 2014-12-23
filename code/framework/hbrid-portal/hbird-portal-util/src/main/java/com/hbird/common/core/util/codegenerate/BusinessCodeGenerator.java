package com.hbird.common.core.util.codegenerate;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 业务编码生成类
 * <p/>
 * 目前生成业务系统、角色、资源编码
 * <p/>
 * User: ljz Date: 2014-6-6 Time: 上午10:08:28 Version: 1.0
 */
public class BusinessCodeGenerator {
    private static Logger log = LogManager.getLogger(BusinessCodeGenerator.class);

    /** 业务系统编码前缀 */
    private final static String SYSTEM_CODE_PREFIX = "S";
    /** 角色编码前缀 */
    private final static String ROLE_CODE_PREFIX = "RO";
    /** 资源编码前缀 */
    private final static String RESOURCE_CODE_PREFIX = "RE";
    /** 0占位符 */
    private final static String PLACEHOLDER = "0";

    /**
     * 生成业务系统编码<br/>
     * 业务系统编码系统生成，规则S+XXX（三位序列） (例S001，XXX为自增序列，取ID值，若不超过三位数，前面用0补齐 否则规则为S+ID，比如1000 ，编码为S1000)
     * 
     * @param id
     *            业务系统ID
     * @return
     */
    public static String getSystemCode(Long id) {
        return generateCode(SYSTEM_CODE_PREFIX, id, 3);
    }

    /**
     * 生成角色编码<br/>
     * 角色编码，编码系统生成，规则ROXXXX (例RO0001，XXXX为自增序列，取ID值，若ID不超过四位数，前面用0补齐； 否则规则为S+ID，比如10000 ，编码为RO10000)
     * 
     * @param id
     *            业务系统ID
     * @return
     */
    public static String getRoleCode(Long id) {
        return generateCode(ROLE_CODE_PREFIX, id, 4);
    }

    /**
     * 生成资源编码<br/>
     * 资源编码系统生成，规则REXXXXX（五位序列） (例RE00001，XXXXX为自增序列，取ID值，若不超过五位数，前面用0补齐 否则规则为RE+ID，比如1000000 ，编码为RE1000000)
     * 
     * @param id
     *            资源ID
     * @return
     */
    public static String getResourceCode(Long id) {
        return generateCode(RESOURCE_CODE_PREFIX, id, 5);
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
            log.error("Param id is null!");
            throw new IllegalArgumentException("Param id is null!");
        }
        StringBuilder code = new StringBuilder(prefixStr);

        if (codeLen <= 0) {
            log.error("Param codeLen must > 0!");
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
