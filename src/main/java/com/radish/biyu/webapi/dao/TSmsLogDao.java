package com.radish.biyu.webapi.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/**
 * radish.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 *
 * @author tiaotiaohu
 * @version TSmsLogDao, v 0.1
 * @date 2016/10/10 21:11
 */
public interface TSmsLogDao {

    @Insert("INSERT INTO `t_sms_log` (`mobile`, `verifi_code`, `created`)  VALUES (#{mobile},#{verifiCode},#{created})")
    int addSmsLog(@Param("mobile") String mobile, @Param("verifiCode") String verifiCode, @Param("created") Date created);

    @Deprecated
    @Select("SELECT id FROM `t_sms_log` WHERE mobile= #{0} AND `verifi_code` =#{1} AND `created` >=#{2} ORDER BY created DESC LIMIT 1")
    Long checkVerifiCode(String mobile, String verifiCode, Date date);

    @Select("SELECT verifi_code FROM `t_sms_log` WHERE mobile= #{0} AND `created` >=#{1} ORDER BY created DESC LIMIT 1")
    String checkVerifiCode(String mobile, Date date);
}
