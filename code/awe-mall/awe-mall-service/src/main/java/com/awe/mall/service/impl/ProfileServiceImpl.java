package com.awe.mall.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.ProfileService;
import com.awe.uc.sdk.UserProfileClient;
import com.awe.uc.sdk.request.dto.UserProfileRequestDto;
import com.hbird.common.utils.wrap.Wrapper;
/**
 * 
 * 个人基础资料
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-1
 */
@Service
public class ProfileServiceImpl implements ProfileService {
	
	private static final Log LOG = LogFactory.getLog(ProfileServiceImpl.class);
	@Autowired
	private UserProfileClient userProfileClient;
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> edit(UserProfileRequestDto profile) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = userProfileClient.edit(profile);
		} catch (Exception e) {
			LOG.error("#ProfileServiceImpl.edit# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> add(UserProfileRequestDto profile) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = userProfileClient.add(profile);
		} catch (Exception e) {
			LOG.error("#ProfileServiceImpl.add# Error:" + e);
		}
		return wrapper;
	}

}
