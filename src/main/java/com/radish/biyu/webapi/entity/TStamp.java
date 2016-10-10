package com.radish.biyu.webapi.entity;

import java.util.Date;

public class TStamp extends BaseEntity{
    private Integer id;

    /**
     * 接收方会员手机
     */
    private String mobile;

    /**
     * 收发邮件ID
     */
    private Integer mailId;

    /**
     * 邮票URL
     */
    private String pic;

    /**
     * 生成时间
     */
    private Date created;

    /**
     * 主键标识
     * @return id 主键标识
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键标识
     * @param id 主键标识
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 接收方会员手机
     * @return mobile 接收方会员手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 接收方会员手机
     * @param mobile 接收方会员手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 收发邮件ID
     * @return mail_id 收发邮件ID
     */
    public Integer getMailId() {
        return mailId;
    }

    /**
     * 收发邮件ID
     * @param mailId 收发邮件ID
     */
    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    /**
     * 邮票URL
     * @return pic 邮票URL
     */
    public String getPic() {
        return pic;
    }

    /**
     * 邮票URL
     * @param pic 邮票URL
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 生成时间
     * @return created 生成时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 生成时间
     * @param created 生成时间
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
        sb.append(", mailId=").append(mailId);
        sb.append(", pic=").append(pic);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}