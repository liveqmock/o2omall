package com.hbird.common.utils.file;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lz
 * @version 2014-12-13 下午5:10:07
 */
public class MyObject implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8172802871065357896L;
    private long id;
    private String name;
    private int age;
    private short degree;
    private double score;
    private boolean available;
    private Date createTime;

    /**
     * @param id
     * @param name
     * @param age
     * @param degree
     * @param score
     * @param available
     * @param createTime
     */
    public MyObject(long id, String name, int age, short degree, double score, boolean available, Date createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.score = score;
        this.available = available;
        this.createTime = createTime;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age
     *            the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the degree
     */
    public short getDegree() {
        return degree;
    }

    /**
     * @param degree
     *            the degree to set
     */
    public void setDegree(short degree) {
        this.degree = degree;
    }

    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score
     *            the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * @return the available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available
     *            the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
