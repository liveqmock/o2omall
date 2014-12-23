package com.hbird.portal.rest.dto;

import java.util.List;

import com.hbird.common.utils.wrap.Wrapper;
import com.hbird.portal.sdk.api.response.dto.RoleDto;

public class RoleResponseObj extends Wrapper<List<RoleDto>> {

    private static final long serialVersionUID = 5838504398177955378L;

    /**
         * 
         */
    public RoleResponseObj() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param code
     * @param message
     * @param result
     */
    public RoleResponseObj(int code, String message, List<RoleDto> result) {
        super(code, message, result);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param code
     * @param message
     */
    public RoleResponseObj(int code, String message) {
        super(code, message);
        // TODO Auto-generated constructor stub
    }

}
