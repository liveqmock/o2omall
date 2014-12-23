package com.hbird.portal.dao;

import java.util.List;

import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.query.ResourceQuery;

/**
 * ResourceDao接口<br/>
 * 对'资源表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-3 18:22:25
 * 
 */
public interface ResourceDao {

    /**
     * 新增对象
     * 
     * @param resource
     * @return
     */
    public boolean insert(Resource resource);

    /**
     * 更新对象
     * 
     * @param resource
     * @return
     */
    public boolean update(Resource resource);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Resource> queryResourceList(ResourceQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryResourceCount(ResourceQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Resource> queryResourceListWithPage(ResourceQuery queryBean);

    /**
     * 删除记录
     * 
     * @param resource
     * @return
     */
    public boolean delete(Resource resource);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public Resource getResourceById(Long id);

    /**
     * 判断是否存在
     * 
     * @param resource
     * @return
     */
    public boolean exist(Resource resource);

    /**
     * 给角色分配资源时，依据角色ID查询资源信息
     * 
     * @param roleId
     *            资源ID
     * @return
     */
    public List<Resource> queryResourceTree(Long roleId);
}
