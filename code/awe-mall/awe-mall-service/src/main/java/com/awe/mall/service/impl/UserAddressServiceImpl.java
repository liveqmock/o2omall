package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.UserAddressService;
import com.awe.uc.sdk.UserAddressClient;
import com.awe.uc.sdk.request.dto.UserAddressRequestDto;
import com.awe.uc.sdk.response.dto.UserAddressResponseDto;
import com.hbird.common.utils.wrap.Wrapper;
/**
 * 送货地址
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-1
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

	private static final Log LOG = LogFactory.getLog(UserAddressServiceImpl.class);
	
	@Autowired
	private UserAddressClient userAddressClient;
	
	public Wrapper<?> insert(UserAddressRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = userAddressClient.insert(requestDto);
		} catch (Exception e) {
			LOG.error("#UserAddressServiceImpl.inset# Error:" + e);
		}
		return wrapper;
	}

	public Wrapper<?> update(UserAddressRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = userAddressClient.update(requestDto);
		} catch (Exception e) {
			LOG.error("#UserAddressServiceImpl.update# Error:" + e);
		}
		return wrapper;
	}

	public List<UserAddressResponseDto> queryUserAddressList(UserAddressRequestDto requestDto) {
		List<UserAddressResponseDto> ret = null;
		try {
			ret = userAddressClient.queryUserAddressList(requestDto);
		} catch (Exception e) {
			LOG.error("#UserAddressServiceImpl.queryUserAddressList# Error:" + e);
		}
		return ret;
	}

	public Wrapper<?> delete(UserAddressRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = userAddressClient.delete(requestDto);
		} catch (Exception e) {
			LOG.error("#UserAddressServiceImpl.delete# Error:" + e);
		}
		return wrapper;
	}

}
