package com.hbird.portal.manager;

import java.util.List;

import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.query.ResourceQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * ResourceManager接口
 * 
 * @author ljz
 * @version 2014-12-3 18:22:25
 * 
 */
public interface ResourceManager {

    /**
     * 批量增加对象信息
     * 
     * @param resourceList
     * @return
     */
    public boolean insert(List<Resource> resourceList);

    /**
     * 单个增加对象信息
     * 
     * @param resource
     * @return
     */
    public boolean insert(Resource resource);

    /**
     * 更新 对象信息
     * 
     * @param resource
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(Resource resource);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Resource> queryResourceList(ResourceQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<Resource> queryResourceListWithPage(ResourceQuery queryBean, PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryResourceCount(ResourceQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param resource
     *            　
     * @return
     */
    public boolean delete(Resource resource);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public Resource getResourceById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param resources
     *            Resource集合
     * @return
     */
    public boolean delete(Resource[] resources);

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
