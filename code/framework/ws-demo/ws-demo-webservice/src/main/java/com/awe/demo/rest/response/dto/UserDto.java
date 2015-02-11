package com.awe.demo.rest.response.dto;


/**
 * @author ljz
 * @version 2015-2-10 下午3:30:16
 */
public class UserDto {
    private Long id;
    private String name;
    private Integer type;
    private Double balance;

    /**
     * 
     */
    public UserDto() {
    }

    /**
     * @param id
     * @param name
     * @param type
     * @param balance
     */
    public UserDto(Long id, String name, Integer type, Double balance) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
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
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return the balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * @param balance
     *            the balance to set
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
