package com.awe.mall.service;

import com.awe.uc.sdk.request.dto.UserProfileRequestDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 个人基础资料
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-1
 */
public interface ProfileService {
	/**
	 * 编辑个人基本资料
	 * @param profile
	 * @return
	 */
	public Wrapper<?> edit(UserProfileRequestDto profile);
	/**
	 * 添加个人基本资料
	 * @param profile
	 * @return
	 */
	public Wrapper<?> add(UserProfileRequestDto profile);
}
