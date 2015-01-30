package com.awe.order.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.awe.order.domain.TaskOrders;
import com.awe.order.sdk.api.request.TaskOrdersRequest;
import com.awe.order.sdk.api.request.dto.TaskOrdersRequestDto;
import com.awe.order.sdk.api.response.dto.TaskOrdersResponseDto;
import com.awe.order.service.TaskOrdersService;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 作业表REST服务：提供有关作业表的接口
 * 
 * @author ljz
 * @version 2015-1-29 16:02:08
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class TaskOrdersResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private TaskOrdersService taskOrdersService; 

    /**
     * 查询作业表信息
     * 
     * @param request
     *            作业表请求参数
     * @return 作业表返回对象
     * 
     */
    @POST
    @Path("/taskOrders/getTaskOrders")
    public Wrapper<?> getTaskOrders(TaskOrdersRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getTaskOrders 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        TaskOrdersRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getTaskOrders 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            TaskOrders taskOrders = taskOrdersService.getTaskOrdersById(requestDto.getId());
            TaskOrdersResponseDto responseDto = convert(taskOrders);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询作业表数据异常", e);
            return WrapMapper.error();
        }
    } 

    /**
     * 添加task信息
     * Date:2015年1月29日下午4:25:04
     * user:js
     * @param request
     * @return
     */
    @POST
	@Path("/taskOrders/insertBatch")
	public Wrapper<?> insertBatch(TaskOrdersRequest request) {
		if (null == request || !request.checkSign()) {
			this.logger.error("deleteOrders 拒绝访问");
			return WrapMapper.forbidden();
		}
		TaskOrdersRequestDto requestDto = request.getContent();
		if (null == requestDto || null == requestDto.getListOrders()
				|| requestDto.getBusinessno() == null || requestDto.getBusinesstype() == null) {
			this.logger.error("insert 传入参数有误");
			return WrapMapper.illegalArgument();
		}
		try {
			TaskOrders taskOrders = new TaskOrders();
			BeanUtils.copyProperties(requestDto, taskOrders);
			boolean falg = taskOrdersService.insert(taskOrders);
			if (falg) {
				return WrapMapper.ok();
			} else {
				return WrapMapper.error();
			}
		} catch (Exception e) {
			this.logger.error("新增作业失败", e);
			return WrapMapper.error();
		}
	}
    
    
    
    // 数据转换
    private TaskOrdersResponseDto convert(TaskOrders taskOrders) {
        if (null == taskOrders) {
            return null;
        }

        TaskOrdersResponseDto taskOrdersResponseDto = new TaskOrdersResponseDto();
        BeanUtils.copyProperties(taskOrders, taskOrdersResponseDto);
        return taskOrdersResponseDto;
    }

    // 数据转换
    private List<TaskOrdersResponseDto> convertList(List<TaskOrders> taskOrderss) {
        if (CollectionUtils.isEmpty(taskOrderss)) {
            return null;
        }

        List<TaskOrdersResponseDto> list = new ArrayList<TaskOrdersResponseDto>(taskOrderss.size());
        for (TaskOrders taskOrders : taskOrderss) {
            list.add(convert(taskOrders));
        }
        return list;
    } 

}
