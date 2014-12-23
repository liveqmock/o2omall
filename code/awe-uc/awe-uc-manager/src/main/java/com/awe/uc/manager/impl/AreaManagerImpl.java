package com.awe.uc.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.uc.domain.Area;
import com.awe.uc.domain.query.AreaQuery;
import com.awe.uc.dao.AreaDao;
import com.awe.uc.manager.AreaManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * AreaManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
@Component
public class AreaManagerImpl extends BaseManager implements AreaManager {
	
    @Autowired
    private AreaDao areaDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<Area> areaList) {
        boolean resultFlag = false;
        if (null != areaList && areaList.size() > 0) {
            for (Area area : areaList) {
                resultFlag = areaDao.insert(area);
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
    public boolean insert(Area area) {
        return areaDao.insert(area);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final Area area) {
        return areaDao.update(area);
    }

    /**
     * {@inheritDoc}
     */
    public List<Area> queryAreaList(AreaQuery queryBean) {
        return areaDao.queryAreaList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Area> queryAreaListWithPage(AreaQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new AreaQuery();
        }

        // 查询总数
        int totalItem = queryAreaCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return areaDao.queryAreaListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryAreaCount(AreaQuery queryBean) {
        return areaDao.queryAreaCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Area area) {
        return areaDao.delete(area);
    }

    /**
     * {@inheritDoc}
     */
    public Area getAreaById(Long id) {
        return areaDao.getAreaById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final Area[] areas) {
        boolean resultFlag = false;
        if (null != areas && areas.length > 0) {
            for (int i = 0; i < areas.length; i++) {
                resultFlag = delete(areas[i]);
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
    public boolean exist(Area area) {
        return areaDao.exist(area);
    }
}
