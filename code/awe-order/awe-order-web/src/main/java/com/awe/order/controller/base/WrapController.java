package com.awe.order.controller.base;

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * WrapController ,wrap simple result return.
 * 
 * @author lijianzhong
 * 
 */
public abstract class WrapController {

    protected Wrapper<?> ok() {
        return WrapMapper.ok();
    }

    protected Wrapper<?> error() {
        return WrapMapper.error();
    }

    protected Wrapper<?> illegalArgument() {
        return WrapMapper.illegalArgument();
    }
}
