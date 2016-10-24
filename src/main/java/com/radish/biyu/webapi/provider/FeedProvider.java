package com.radish.biyu.webapi.provider;

import org.springframework.util.StringUtils;

import java.util.HashMap;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * 会员基础信息SQL生成器
 * <p>
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.provider.FeedProvider, v 0.1
 * @date 2016/9/25.
 */
public class FeedProvider {
    private static final String TABLE_NAME = "t_feed";

    /**
     * 翻页查询feed SQL
     *
     * @param param
     * @return
     */
    public String listSql(final HashMap<String, Object> param) {
        BEGIN();

        String ftype = (String) param.get("ftype");
        Integer pageno = (Integer) param.get("pageno");
        Integer pagesize = (Integer) param.get("pagesize");
        Long uid = (Long) param.get("uid");

        StringBuffer str = new StringBuffer();
        str.append("SELECT t3.`id` AS `id`,t3.`uid` AS `uid`, t3.`ftype` AS `ftype`, t3.`message` AS `message`, t3.`forwarded` AS `forwarded`, t3.`liked` AS `liked`, t3.`pic` AS `pic`, t3.`lng` AS `lng`, t3.`lat` AS `lat`, t3.`created` AS `created`,t4.`nickName` AS `nickName`, t4.`avatar` AS `avatar`, t4.`sex` AS `sex`,t4.`birthDay` AS `birthday`,(SELECT COUNT(0) FROM `t_comment` WHERE fid = t3.id) AS commentnum,");

        if (null == uid || uid.longValue() <= 0) {
            str.append(" 0 as islike ");
        } else {
            str.append("(SELECT '1'  FROM `t_liked` WHERE fid = t3.id AND `uid` = " + uid + " limit 1 ) AS islike ");
        }

        str.append("FROM (SELECT * FROM `t_feed` t1, (SELECT id AS tmpid FROM `t_feed`");
        if (!StringUtils.isEmpty(ftype) && !ftype.equals("0")) {
            str.append("WHERE ftype = ").append(ftype);
        }
        str.append(" ORDER BY created DESC LIMIT ").append(pageno * pagesize).append(",").append(pagesize).append(") t2 ");
        str.append("WHERE t1.id = t2.tmpid ");
        str.append(") t3 ");
        str.append("LEFT JOIN `t_user_info` t4 ON t3.uid = t4.`id`");

//        System.out.println(str.toString());

        return str.toString();
    }

    /**
     * @param param
     * @return
     */
    public String clickFav(final HashMap<String, Object> param) {
        BEGIN();
        UPDATE(TABLE_NAME);
        if (null == param.get("liked")) {
            SET("forwarded = forwarded + 1");
        } else {
            SET("liked = liked + 1");
        }
        WHERE("id = " + param.get("id"));
        return SQL();
    }
}