package com.awe.uc.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.uc.domain.Area;
import com.awe.uc.domain.query.AreaQuery;
import com.awe.uc.manager.AreaManager;
import com.awe.uc.service.AreaService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * AreaService接口的实现类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
@Service
public class AreaServiceImpl implements AreaService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(AreaServiceImpl.class);

    @Autowired
    private AreaManager areaManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "AreaService.batchInsert")
    public boolean insert(List<Area> areaList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(areaList)) {
                resultFlag = areaManager.insert(areaList);
            } else {
                LOG.warn("AreaServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("AreaServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "AreaService.insert")
    public boolean insert(Area area) {
        boolean resultFlag = false;
        try {
            if (null != area) {
                if (areaManager.exist(area)) {
                    throw new ExistedException();
                }
                resultFlag = areaManager.insert(area);
            } else {
                LOG.warn("AreaServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("AreaServiceImpl#insert failed, area has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("AreaServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "AreaService.update")
    public boolean update(Area area) {
        boolean resultFlag = false;
        try {
            if (null != area && null != area.getId()) {
                resultFlag = areaManager.update(area);
            } else {
                LOG.warn("AreaServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("AreaServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "AreaService.queryAreaList")
    public List<Area> queryAreaList(AreaQuery queryBean) {
        List<Area> areaList = null;
        try {
            areaList = areaManager.queryAreaList(queryBean);
        } catch (Exception e) {
            LOG.error("AreaServiceImpl#queryAreaList has error.", e);
        }
        return areaList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "AreaService.queryAreaListWithPage")
    public List<Area> queryAreaListWithPage(AreaQuery queryBean, PageUtil pageUtil) {
        List<Area> areaList = null;
        try {
            areaList = areaManager.queryAreaListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("AreaServiceImpl#queryAreaListWithPage has error.", e);
        }
        return areaList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "AreaService.delete")
    public boolean delete(Area area) {
        boolean resultFlag = false;
        try {
            if (null != area && null != area.getId()) {
                resultFlag = areaManager.delete(area);
            } else {
                LOG.warn("AreaServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("AreaServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "AreaService.batchDelete")
    public boolean delete(Area[] areas) {
        boolean resultFlag = false;
        try {
            if (null != areas && areas.length > 0) {
                resultFlag = areaManager.delete(areas);
            } else {
                LOG.warn("AreaServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("AreaServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "AreaService.getAreaById")
    public Area getAreaById(Long id) {
        Area area = null;
        try {
            if (null != id) {
                area = areaManager.getAreaById(id);
            } else {
                LOG.warn("AreaServiceImpl#getAreaById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("AreaServiceImpl#getAreaById has error.", e);
        }
        return area;
    }
}

