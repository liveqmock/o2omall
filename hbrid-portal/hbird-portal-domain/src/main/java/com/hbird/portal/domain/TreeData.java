package com.hbird.portal.domain;

/**
 * User: ljz Date: 14-4-15 Time: 下午2:32 To change this template use File | Settings | File Templates.
 */
public class TreeData {

    private Integer level; // 数据在哪一级
    private Boolean isLeaf; // 是否叶子节点
    private Long parent; // 父节点是哪个，如果自己为父节点，值为null
    private Boolean loaded; // 是否加载完成
    private Boolean expanded; // 是否展开

    // private Boolean icon;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getLeaf() {
        return isLeaf;
    }

    public void setLeaf(Boolean leaf) {
        isLeaf = leaf;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Boolean getLoaded() {
        return loaded;
    }

    public void setLoaded(Boolean loaded) {
        this.loaded = loaded;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    /*
     * public Boolean getIcon() { return icon; }
     * 
     * public void setIcon(Boolean icon) { this.icon = icon; }
     */
}
