package com.awe.order.sdk.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.order.sdk.request.dto.TaskOrdersRequestDto;

/**
 * TaskOrdersRequest：作业表请求参数
 * 
 * @author ljz
 * @version 2015-1-29 16:02:09
 * 
 */
public class TaskOrdersRequest extends HbirdSecureRequest<TaskOrdersRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public TaskOrdersRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public TaskOrdersRequest(String key, TaskOrdersRequestDto content) {
        super(key, content);
    }
}
