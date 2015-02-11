package com.awe.demo.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;
import org.springframework.stereotype.Component;

import com.awe.demo.rest.requset.UserRequest;
import com.awe.demo.rest.response.dto.UserDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.SimplePageWrapMapper;
import com.hbird.common.utils.wrap.SimplePageWrapper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
public class UserResource {

    private static HashMap<Long, UserDto> USER_MAP = new HashMap<Long, UserDto>();
    static {// 模拟数据
        for (long i = 0; i < 20; i++) {
            UserDto dto = new UserDto(i, "USER-" + i, 2, Double.valueOf(String.valueOf(i + 100)));
            USER_MAP.put(i, dto);
        }
    }

    /**
     * 新增
     * 
     * @param request
     * @return
     */
    @POST
    @Path("/user/add")
    public Wrapper<?> add(@Form UserRequest request) {
        try {
            UserDto dto = new UserDto(request.getId(), request.getName(), request.getType(), request.getBalance());
            USER_MAP.put(request.getId(), dto);
            return WrapMapper.ok();
        } catch (Exception e) {
            return WrapMapper.error();
        }
    }

    /**
     * 查询单个
     * 
     * @param request
     * @return
     */
    @GET
    @Path("/user/query")
    public Wrapper<?> query(@Form UserRequest request) {
        try {
            UserDto result = USER_MAP.get(request.getId());
            return WrapMapper.ok().result(result);
        } catch (Exception e) {
            return WrapMapper.error();
        }
    }

    /**
     * 分页查询
     * 
     * @param request
     * @return
     */
    @GET
    @Path("/user/queryList")
    public SimplePageWrapper<?> queryList(@Form UserRequest request) {
        try {
            List<UserDto> allDtos = new ArrayList<UserDto>(USER_MAP.values());
            List<UserDto> result = allDtos.subList(0, 15);
            PageUtil pageUtil = new PageUtil(0, 15);
            pageUtil.setTotalRow(allDtos.size());
            pageUtil.init();
            return SimplePageWrapMapper.ok().result(result).page(pageUtil.getTotalRow(), pageUtil.getTotalPage());
        } catch (Exception e) {
            return SimplePageWrapMapper.error();
        }
    }
}
