package com.hbird.portal.manager.impl;

import java.util.List;

import com.hbird.common.core.util.codegenerate.BusinessCodeGenerator;
import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.portal.domain.System;
import com.hbird.portal.domain.query.SystemQuery;
import com.hbird.portal.dao.SystemDao;
import com.hbird.portal.manager.SystemManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SystemManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-3 18:22:25
 * 
 */
@Component
public class SystemManagerImpl extends BaseManager implements SystemManager {

    @Autowired
    private SystemDao systemDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<System> systemList) {
        boolean resultFlag = false;
        if (null != systemList && systemList.size() > 0) {
            for (System system : systemList) {
                resultFlag = insert(system);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(System system) {
        boolean resultFlag = systemDao.insert(system);
        if (resultFlag) {
            String code = BusinessCodeGenerator.getSystemCode(system.getId());
            system.setCode(code);
            resultFlag = systemDao.update(system);
        } else {
            throw new RuntimeException("生成业务系统编码异常！ID【" + system.getId() + "】");
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final System system) {
        return systemDao.update(system);
    }

    /**
     * {@inheritDoc}
     */
    public List<System> querySystemList(SystemQuery queryBean) {
        return systemDao.querySystemList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<System> querySystemListWithPage(SystemQuery queryBean, PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new SystemQuery();
        }

        // 查询总数
        int totalItem = querySystemCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();

        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return systemDao.querySystemListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int querySystemCount(SystemQuery queryBean) {
        return systemDao.querySystemCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(System system) {
        return systemDao.delete(system);
    }

    /**
     * {@inheritDoc}
     */
    public System getSystemById(Long id) {
        return systemDao.getSystemById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final System[] systems) {
        boolean resultFlag = false;
        if (null != systems && systems.length > 0) {
            for (int i = 0; i < systems.length; i++) {
                resultFlag = delete(systems[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(System system) {
        return systemDao.exist(system);
    }
}
