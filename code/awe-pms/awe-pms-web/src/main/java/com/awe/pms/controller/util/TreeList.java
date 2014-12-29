package com.awe.pms.controller.util;

import java.util.ArrayList;
import java.util.List;

import com.awe.pms.domain.ProductCategory;

/**
 * 
 * list to tree
 * 
 * @author ljz
 * @version 2014-12-12 上午9:56:31
 */
public class TreeList {
    static List<ProductCategory> newList = new ArrayList<ProductCategory>();

    /**
     * 获得子节点
     * 
     * @param treeNode
     * @param treeList
     * @return
     */
    public static List<ProductCategory> getChild(ProductCategory treeNode, List<ProductCategory> treeList) {
        List<ProductCategory> childList = new ArrayList<ProductCategory>();
        for (int i = 0; i < treeList.size(); i++) {
            if (null != treeNode.getId() && treeNode.getId().equals(treeList.get(i).getFid())) {
                childList.add((ProductCategory) treeList.get(i));
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
    public static List<ProductCategory> getRootNode(List<ProductCategory> treeList) {
        List<ProductCategory> rootList = new ArrayList<ProductCategory>();
        for (int i = 0; i < treeList.size(); i++) {
            if (((ProductCategory) treeList.get(i)).getFid() == 0) {
                rootList.add((ProductCategory) treeList.get(i));
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
    public static List<ProductCategory> setRootNode(List<ProductCategory> treeList) {
        newList.clear();
        List<ProductCategory> rootNode = getRootNode(treeList);
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
    public static List<ProductCategory> sortNode(ProductCategory rootNode, List<ProductCategory> treeList) {
        List<ProductCategory> childList = getChild(rootNode, treeList);
        if (childList != null) {
            for (int i = 0; i < childList.size(); i++) {
                newList.add(childList.get(i));
                sortNode(childList.get(i), treeList);
            }
        }
        return childList;
    }

}
