/**
 * 
 */
package com.letv.ci.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.letv.ci.service.DataService;

/**
 * @author lijianzhong
 * 
 */
@Service
public class DataServiceImpl implements DataService {

    /*
     * (non-Javadoc)
     * 
     * @see com.letv.ci.service.DataService#isNotEmpty(java.lang.String)
     */
    public boolean isNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }

}
