package com.radish.biyu.webapi.dao;

import com.radish.biyu.webapi.entity.TStamp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * radish.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 *
 * @author tiaotiaohu
 * @version TStampDao, v 0.1
 * @date 2016/10/10 23:16
 */
public interface TStampDao {
    @Insert("INSERT INTO `t_stamp` (`mobile`, `mail_id`, `pic`, `created`) VALUES (#{mobile}, #{mailId}, #{pic}, #{created})")
    int addStamp(TStamp stamp);

    @Select("SELECT count(`id`) FROM `t_stamp` WHERE mobile =#{mobile}")
    Integer cnt(String mobile);

    @Select("SELECT `id`,`pic` FROM `t_stamp` WHERE mobile =#{0} ORDER BY created DESC LIMIT #{1},#{2}")
    List<HashMap<String, Object>> list(String mobile, Integer pageno, Integer pagesize);
}
