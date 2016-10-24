package com.radish.biyu.webapi.dto;

import com.alibaba.fastjson.JSON;
import com.radish.biyu.webapi.entity.BaseEntity;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;

public class RequestFeed {
    private Long uid = null;
    private String ftype = null;
    private String lng = "";
    private String lat = "";
    private String message = null;
//    private String[] pic = new String[]{};
    private String imgs ="";

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
        this.message = HtmlUtils.htmlEscape(message, "UTF-8");
    }

//    public String[] getPic() {
//        return pic;
//    }
//
//    public void setPic(String[] pic) {
//        this.pic = pic;
//    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public static void main(String[] args) {
        RequestFeed r = new RequestFeed();
        r.setUid(100L);
        r.setFtype("0");
        r.setMessage("测试文本内容~121298");
        r.setLat("30.67");
        r.setLng("104.06");
//        r.setPic(new String[]{
//                "http://b.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=277c06a0cc1349546a13e0363727f93d/3812b31bb051f819ffbbbd6bddb44aed2e73e771.jpg",
//                "http://b.hiphotos.baidu.com/baike/crop%3D0%2C2%2C560%2C370%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=44216f7132f33a878a225a5afb6c3c0a/b3b7d0a20cf431ad5af7af784336acaf2edd984e.jpg",
//                "http://a.hiphotos.baidu.com/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=88b3ac0bdc2a283457ab3e593adca28f/adaf2edda3cc7cd965fa88cf3101213fb90e91d5.jpg"
//        });

        System.out.println(JSON.toJSONString(r));
    }
}