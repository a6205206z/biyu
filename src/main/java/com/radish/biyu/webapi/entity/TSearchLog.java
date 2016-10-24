package com.radish.biyu.webapi.entity;

import java.util.Date;

public class TSearchLog {
    private Integer id;

    /**
     * 会员ID
     */
    private String phone;

    /**
     * 搜索时间
     */
    private Date searchTime;

    /**
     * 搜索条件
     */
    private String condition;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 搜索时间
     * @return search_time 搜索时间
     */
    public Date getSearchTime() {
        return searchTime;
    }

    /**
     * 搜索时间
     * @param searchTime 搜索时间
     */
    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    /**
     * 搜索条件
     * @return condition 搜索条件
     */
    public String getCondition() {
        return condition;
    }

    /**
     * 搜索条件
     * @param condition 搜索条件
     */
    public void setCondition(String condition) {
        this.condition = condition == null ? null : condition.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", phone=").append(phone);
        sb.append(", searchTime=").append(searchTime);
        sb.append(", condition=").append(condition);
        sb.append("]");
        return sb.toString();
    }
}