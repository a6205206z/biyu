package com.radish.biyu.webapi.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * radish.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 *
 * @author tiaotiaohu
 * @version TLikedDao, v 0.1
 * @date 2016/10/10 23:16
 */
public interface TLikedDao {

    @Insert("INSERT INTO `t_liked` (`fid`, `uid`, `created`) VALUES (#{fid}, #{uid}, #{created})")
    int addLikeLog(@Param("fid") Long fid, @Param("uid") Long uid, @Param("created") Date created);

}
