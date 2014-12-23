package com.hbird.portal.web.util;

import java.util.ArrayList;
import java.util.List;

import com.hbird.portal.domain.Resource;

/**
 * 
 * list to tree
 * 
 * @author ljz
 * @version 2014-12-12 上午9:56:31
 */
public class TreeList {
    static List<Resource> newList = new ArrayList<Resource>();

    /**
     * 获得子节点
     * 
     * @param treeNode
     * @param treeList
     * @return
     */
    public static List<Resource> getChild(Resource treeNode, List<Resource> treeList) {
        List<Resource> childList = new ArrayList<Resource>();
        for (int i = 0; i < treeList.size(); i++) {
            if (null != treeNode.getId() && treeNode.getId().equals(treeList.get(i).getParentId())) {
                childList.add((Resource) treeList.get(i));
            }
        }
        return childList;
    }

    /**
     * 获得根节点
     * 
     * @param treeList
     * @return
     */
    public static List<Resource> getRootNode(List<Resource> treeList) {
        List<Resource> rootList = new ArrayList<Resource>();
        for (int i = 0; i < treeList.size(); i++) {
            if (((Resource) treeList.get(i)).getParentId() == 0) {
                rootList.add((Resource) treeList.get(i));
            }
        }
        return rootList;
    }

    /**
     * 向新list中装入根节点并递归子节点
     * 
     * @param treeList
     * @return
     */
    public static List<Resource> setRootNode(List<Resource> treeList) {
        newList.clear();
        List<Resource> rootNode = getRootNode(treeList);
        for (int i = 0; i < rootNode.size(); i++) {
            newList.add(rootNode.get(i));
            sortNode(rootNode.get(i), treeList);
        }

        return newList;
    }

    /**
     * 递归子节点
     * 
     * @param rootNode
     * @param treeList
     * @return
     */
    public static List<Resource> sortNode(Resource rootNode, List<Resource> treeList) {
        List<Resource> childList = getChild(rootNode, treeList);
        if (childList != null) {
            for (int i = 0; i < childList.size(); i++) {
                newList.add(childList.get(i));
                sortNode(childList.get(i), treeList);
            }
        }
        return childList;
    }

}
