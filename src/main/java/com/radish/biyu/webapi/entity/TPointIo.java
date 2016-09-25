package com.radish.biyu.webapi.entity;

import java.util.Date;

public class TPointIo extends BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_point_io.id
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_point_io.accountPhone
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    private String accountphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_point_io.currentPoint
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    private Long currentpoint;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_point_io.changePoint
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    private Long changepoint;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_point_io.changeDate
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    private Date changedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_point_io.reson
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    private String reson;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_point_io.id
     *
     * @return the value of t_point_io.id
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_point_io.id
     *
     * @param id the value for t_point_io.id
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_point_io.accountPhone
     *
     * @return the value of t_point_io.accountPhone
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public String getAccountphone() {
        return accountphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_point_io.accountPhone
     *
     * @param accountphone the value for t_point_io.accountPhone
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public void setAccountphone(String accountphone) {
        this.accountphone = accountphone == null ? null : accountphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_point_io.currentPoint
     *
     * @return the value of t_point_io.currentPoint
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public Long getCurrentpoint() {
        return currentpoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_point_io.currentPoint
     *
     * @param currentpoint the value for t_point_io.currentPoint
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public void setCurrentpoint(Long currentpoint) {
        this.currentpoint = currentpoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_point_io.changePoint
     *
     * @return the value of t_point_io.changePoint
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public Long getChangepoint() {
        return changepoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_point_io.changePoint
     *
     * @param changepoint the value for t_point_io.changePoint
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public void setChangepoint(Long changepoint) {
        this.changepoint = changepoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_point_io.changeDate
     *
     * @return the value of t_point_io.changeDate
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public Date getChangedate() {
        return changedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_point_io.changeDate
     *
     * @param changedate the value for t_point_io.changeDate
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_point_io.reson
     *
     * @return the value of t_point_io.reson
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public String getReson() {
        return reson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_point_io.reson
     *
     * @param reson the value for t_point_io.reson
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    public void setReson(String reson) {
        this.reson = reson == null ? null : reson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_io
     *
     * @mbggenerated Sun Sep 25 16:10:00 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountphone=").append(accountphone);
        sb.append(", currentpoint=").append(currentpoint);
        sb.append(", changepoint=").append(changepoint);
        sb.append(", changedate=").append(changedate);
        sb.append(", reson=").append(reson);
        sb.append("]");
        return sb.toString();
    }
}