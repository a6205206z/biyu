package com.radish.biyu.webapi.dto;

import com.alibaba.fastjson.JSON;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.dto.RequestComment, v 0.1
 * @date 2016/9/27.
 */
public class RequestComment {
    private Long fid;
    private Integer uid;
    private String comments;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = HtmlUtils.htmlEscape(comments, "UTF-8");
    }

    public static void main(String[] args) {
        RequestComment r = new RequestComment();
        r.setUid(100);
        r.setComments("在那里啊？出来<script src='sdd'></script>high");
        r.setFid(2L);
        System.out.println(JSON.toJSONString(r));
    }
}
