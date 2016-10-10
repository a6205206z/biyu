package com.radish.biyu.webapi.entity;

import java.util.Date;

public class TSmsLog extends BaseEntity {
    /**
     *
     */
    private Integer id;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 验证码
     */
    private String verifiCode;

    /**
     * 发送时间
     */
    private Date created;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 手机号码
     *
     * @return mobile 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 验证码
     *
     * @return verifi_code 验证码
     */
    public String getVerifiCode() {
        return verifiCode;
    }

    /**
     * 验证码
     *
     * @param verifiCode 验证码
     */
    public void setVerifiCode(String verifiCode) {
        this.verifiCode = verifiCode == null ? null : verifiCode.trim();
    }

    /**
     * 发送时间
     *
     * @return created 发送时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 发送时间
     *
     * @param created 发送时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mobile=").append(mobile);
        sb.append(", verifiCode=").append(verifiCode);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}