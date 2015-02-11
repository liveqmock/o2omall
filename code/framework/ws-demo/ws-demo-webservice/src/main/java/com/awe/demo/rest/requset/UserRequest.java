package com.awe.demo.rest.requset;

import javax.ws.rs.QueryParam;

import com.hbird.common.ws.wap.request.HbirdFormRequest;

/**
 * @author ljz
 * @version 2015-2-9 下午12:45:35
 */
public class UserRequest extends HbirdFormRequest {
    
    @QueryParam("id")
    private Long id; 
    @QueryParam("name")
    private String name;
    @QueryParam("type")
    private Integer type;
    @QueryParam("age")
    private Double balance;
 
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
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
     * @param name the name to set
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
     * @param type the type to set
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
     * @param balance the balance to set
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    } 
    
    

}
