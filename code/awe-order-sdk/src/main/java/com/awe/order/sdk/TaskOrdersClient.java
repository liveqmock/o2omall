package com.awe.order.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.order.sdk.request.TaskOrdersRequest;
import com.awe.order.sdk.request.dto.TaskOrdersRequestDto;
import com.awe.order.sdk.response.TaskOrdersResponse;
import com.awe.order.sdk.response.dto.TaskOrdersResponseDto;

/**
 * 作业表服务的客户端
 * 
 * @author ljz
 * @version 2015-1-29 16:02:09
 * 
 */
public class TaskOrdersClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(TaskOrdersClient.class);

    /**
     * 作业表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return TaskOrdersResponseDto 接口返回的数据对象
     */
    public TaskOrdersResponseDto getTaskOrders(TaskOrdersRequestDto requestDto) {
        Assert.notNull(requestDto);

        TaskOrdersRequest request = new TaskOrdersRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getTaskOrders request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/taskOrders/getTaskOrders";
        TaskOrdersResponse response = super.getRestTemplate().postForObject(url, request, TaskOrdersResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getTaskOrders url: " + url);
            LOG.debug("getTaskOrders response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
