package com.hbird.portal.manager.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.dao.DepDao;
import com.hbird.portal.domain.Dep;
import com.hbird.portal.domain.query.DepQuery;
import com.hbird.portal.manager.DepManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
@Component
public class DepManagerImpl extends BaseManager implements DepManager {
    private final static Logger log = LogManager.getLogger(DepManagerImpl.class);
    @Autowired
    private DepDao depDao;

    public boolean insert(final List<Dep> beanList) {
        boolean resultFlag = true;
        if (null != beanList && beanList.size() > 0) {
            for (Dep bean : beanList) {
                resultFlag = depDao.insert(bean);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    public boolean insert(Dep bean) {
        return depDao.insert(bean);
    }

    public boolean update(final Dep bean) {
        boolean resultFlag = true;
        if (null != bean) {
            resultFlag = depDao.update(bean);
            if (!resultFlag) {
                throw new RuntimeException("单个表信息更新异常,ID:[" + bean.getId() + "]!");
            }
        } else {
            log.debug("DepManagerImpl!update(Dep bean) Error,参数为空!");
            throw new RuntimeException("单个表信息更新时，表信息对象为NULL!");
        }

        return resultFlag;
    }

    public List<Dep> queryDepList(DepQuery queryBean) {
        return depDao.queryDepList(queryBean);
    }

    public PaginatedArrayList<Dep> queryDepListWithPage(DepQuery queryBean, int pageIndex, int pageSize) {
        if (null == queryBean) {
            queryBean = new DepQuery();
        }
        queryBean.setPageIndex(pageIndex);
        queryBean.setPageSize(pageSize);
        // 查询总数
        int totalItem = queryDepCount(queryBean);
        // 创建翻页集合,根据第几页和每页大小
        PaginatedArrayList<Dep> deps = new PaginatedArrayList<Dep>(pageIndex, pageSize);
        // 设置总数,同时将会计算出开始行和结束行
        deps.setTotalItem(totalItem);

        // 设置开始行
        // queryBean.setStartRow(deps.getStartRow());
        // 设置最后行
        queryBean.setEndRow(deps.getPageSize());
        // 调用Dao翻页方法
        List<Dep> depList = depDao.queryDepListWithPage(queryBean);
        deps.addAll(depList);

        return deps;
    }

    public int queryDepCount(DepQuery queryBean) {
        return depDao.queryDepCount(queryBean);
    }

    public boolean delete(Long id) {
        return depDao.deleteDepById(id);
    }

    public Dep getDepById(Long id) {
        return depDao.getDepById(id);
    }

    public boolean delete(final String[] ids) {
        boolean resultFlag = true;
        if (null != ids && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                resultFlag = delete(Long.parseLong(ids[i]));
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        } else {
            log.error("ids param is null!");
        }

        return resultFlag;
    }

    public Dep getDepByCode(String code) {
        return this.depDao.getDepByCode(code);
    }

    public int syncDepDatas(List<Dep> deps) {
        int addCount = 0;
        int updateCount = 0;
        if (deps != null && deps.size() > 0) {
            for (Dep dep : deps) {
                Dep tempDep = this.getDepByCode(dep.getCode());
                if (tempDep == null) {
                    this.insert(dep);
                    addCount++;
                } else if (tempDep.getLastModifyTime().getTime() < dep.getLastModifyTime().getTime()) {
                    this.update(dep);
                    updateCount++;
                } else {
                    log.info("syncDepDatas 最后更新时间不大于当前最后更新时间判断为不更新数据！");
                }
            }
            log.info("总共记录：【" + deps.size() + "】条，新增：【" + addCount + "】条，更新：【" + updateCount + "】条。");
        }

        // 返回操作数据库条数
        return addCount + updateCount;
    }
}
