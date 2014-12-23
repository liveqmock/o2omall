package com.hbird.portal.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.hbird.portal.dao.DepDao;
import com.hbird.portal.domain.Dep;
import com.hbird.portal.domain.query.DepQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
@Repository
public class DepDaoImpl extends BaseDao implements DepDao {

    public List<Dep> queryDepList(DepQuery queryBean) {
        return (List<Dep>) queryForList("Dep.queryDepList", queryBean);
    }

    public boolean insert(Dep bean) {
        return insert("Dep.insert", bean);
    }

    public boolean update(Dep bean) {
        return update("Dep.update", bean);
    }

    public int queryDepCount(DepQuery queryBean) {
        return (Integer) queryForObject("Dep.queryDepCount", queryBean);
    }

    public List<Dep> queryDepListWithPage(DepQuery queryBean) {
        return (List<Dep>) queryForList("Dep.queryDepListWithPage", queryBean);
    }

    public boolean deleteDepById(Long id) {
        return delete("Dep.deleteDepById", id);
    }

    public Dep getDepById(Long id) {
        return (Dep) queryForObject("Dep.getDepById", id);
    }

    public Dep getDepByCode(String code) {
        List<Dep> deps = (List<Dep>) queryForList("Dep.getDepByCode", code);
        if (deps != null && deps.size() > 0) {
            return deps.get(0);
        }
        return null;
    }
}
