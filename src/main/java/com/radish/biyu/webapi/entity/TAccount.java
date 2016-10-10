package com.radish.biyu.webapi.entity;

public class TAccount extends BaseEntity {
    /**
     *
     */
    private Integer id;

    /**
     * 用户手机号，也是唯一身份验证
     */
    private String phone;

    /**
     * 密码，md5加密
     */
    private String password;

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
     * 用户手机号，也是唯一身份验证
     *
     * @return phone 用户手机号，也是唯一身份验证
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 用户手机号，也是唯一身份验证
     *
     * @param phone 用户手机号，也是唯一身份验证
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 密码，md5加密
     *
     * @return password 密码，md5加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码，md5加密
     *
     * @param password 密码，md5加密
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }
}