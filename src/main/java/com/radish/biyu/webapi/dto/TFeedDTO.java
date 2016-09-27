package com.radish.biyu.webapi.dto;

import java.util.Date;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.dto.TFeedDTO, v 0.1
 * @date 2016/9/26.
 */
public class TFeedDTO extends BaseDTO {
    private Long id = null;
    private Long uid = null;
    private String ftype = null;
    private String lng = "";
    private String lat = "";
    private String message = "";
    private String[] pic = new String[]{};
    private Integer forwarded = 0;
    private Integer liked = 0;
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getPic() {
        return pic;
    }

    public void setPic(String[] pic) {
        this.pic = pic;
    }

    public Integer getForwarded() {
        return forwarded;
    }

    public void setForwarded(Integer forwarded) {
        this.forwarded = forwarded;
    }

    public Integer getLiked() {
        return liked;
    }

    public void setLiked(Integer liked) {
        this.liked = liked;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
