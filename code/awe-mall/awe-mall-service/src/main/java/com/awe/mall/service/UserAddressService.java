package com.awe.mall.service;

import java.util.List;

import com.awe.uc.sdk.request.dto.UserAddressRequestDto;
import com.awe.uc.sdk.response.dto.UserAddressResponseDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 送货地址
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-1
 */
public interface UserAddressService {

	/**
     * 单个增加对象信息
     * 
     * @param requestDto
     * @return
     */
    public Wrapper<?> insert(UserAddressRequestDto requestDto);
    /**
     * 更新 对象信息
     * 
     * @param requestDto
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public Wrapper<?> update(UserAddressRequestDto requestDto);
    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param requestDto
     * @return
     */
    public List<UserAddressResponseDto> queryUserAddressList(UserAddressRequestDto requestDto);
    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param requestDto
     *            　
     * @return
     */
    public Wrapper<?> delete(UserAddressRequestDto requestDto);
}
