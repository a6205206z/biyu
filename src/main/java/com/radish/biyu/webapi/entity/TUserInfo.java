package com.radish.biyu.webapi.entity;

import java.util.Date;

public class TUserInfo extends BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.id
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.accountPhone
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String accountphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.avatar
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String avatar;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.postCode
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String postcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.nickName
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.sex
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.birthDay
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.zodiac
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String zodiac;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.location
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String location;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.favorite
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String favorite;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.needs
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String needs;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.status
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.signature
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private String signature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.point
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private Long point;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_info.updated
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    private Date updated;

    //
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public TUserInfo setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.id
     *
     * @return the value of t_user_info.id
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.id
     *
     * @param id the value for t_user_info.id
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.accountPhone
     *
     * @return the value of t_user_info.accountPhone
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getAccountphone() {
        return accountphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.accountPhone
     *
     * @param accountphone the value for t_user_info.accountPhone
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setAccountphone(String accountphone) {
        this.accountphone = accountphone == null ? null : accountphone.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.avatar
     *
     * @return the value of t_user_info.avatar
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.avatar
     *
     * @param avatar the value for t_user_info.avatar
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.postCode
     *
     * @return the value of t_user_info.postCode
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.postCode
     *
     * @param postcode the value for t_user_info.postCode
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.nickName
     *
     * @return the value of t_user_info.nickName
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.nickName
     *
     * @param nickname the value for t_user_info.nickName
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.sex
     *
     * @return the value of t_user_info.sex
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.sex
     *
     * @param sex the value for t_user_info.sex
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.birthDay
     *
     * @return the value of t_user_info.birthDay
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.birthDay
     *
     * @param birthday the value for t_user_info.birthDay
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.zodiac
     *
     * @return the value of t_user_info.zodiac
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getZodiac() {
        return zodiac;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.zodiac
     *
     * @param zodiac the value for t_user_info.zodiac
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setZodiac(String zodiac) {
        this.zodiac = zodiac == null ? null : zodiac.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.location
     *
     * @return the value of t_user_info.location
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.location
     *
     * @param location the value for t_user_info.location
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setLocation(String location) {
        this.location = location == null ? null : location.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.favorite
     *
     * @return the value of t_user_info.favorite
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getFavorite() {
        return favorite;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.favorite
     *
     * @param favorite the value for t_user_info.favorite
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setFavorite(String favorite) {
        this.favorite = favorite == null ? null : favorite.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.needs
     *
     * @return the value of t_user_info.needs
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getNeeds() {
        return needs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.needs
     *
     * @param needs the value for t_user_info.needs
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setNeeds(String needs) {
        this.needs = needs == null ? null : needs.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.status
     *
     * @return the value of t_user_info.status
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.status
     *
     * @param status the value for t_user_info.status
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    public TUserInfo setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.signature
     *
     * @return the value of t_user_info.signature
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    public String getSignature() {
        return signature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.signature
     *
     * @param signature the value for t_user_info.signature
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    public TUserInfo setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.point
     *
     * @return the value of t_user_info.point
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    public Long getPoint() {
        return point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.point
     *
     * @param point the value for t_user_info.point
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    public TUserInfo setPoint(Long point) {
        this.point = point;
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_info.updated
     *
     * @return the value of t_user_info.updated
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_info.updated
     *
     * @param updated the value for t_user_info.updated
     *
     * @mbggenerated Sun Sep 25 15:12:37 CST 2016
     */
    public TUserInfo setUpdated(Date updated) {
        this.updated = updated;
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_info
     *
     * @mbggenerated Sun Sep 25 13:38:07 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountphone=").append(accountphone);
        sb.append(", avatar=").append(avatar);
        sb.append(", postcode=").append(postcode);
        sb.append(", nickname=").append(nickname);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", zodiac=").append(zodiac);
        sb.append(", location=").append(location);
        sb.append(", favorite=").append(favorite);
        sb.append(", needs=").append(needs);
        sb.append(", status=").append(status);
        sb.append(", signature=").append(signature);
        sb.append(", point=").append(point);
        sb.append(", updated=").append(updated);
        sb.append("]");
        return sb.toString();
    }
}