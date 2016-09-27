package com.radish.biyu.webapi.dao;

import com.radish.biyu.webapi.entity.TComment;
import com.radish.biyu.webapi.entity.TFeed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.dao.TCommentDao, v 0.1
 * @date 2016/9/27.
 */
@Repository
public interface TCommentDao {

    @Insert("INSERT INTO `t_comment` (`fid`,`comments`,`uid`,`created`) VALUES (#{fid},#{comments},#{uid},#{created})")
    Long insert(TComment comment);

    /***
     * List<HashMap<String, Object>> list(@Param("fid")String fid, @Param("pageno")String pageno, @Param("pagesize") Integer pagesize);
     *
     * 或者不改传参，改sql：
     *
     * sql中的参数用 #{0}，#{1}代替即可
     *
     * @param fid
     * @param pageno
     * @param pagesize
     * @return
     */
    @Select("SELECT t1.`id` AS `id`, t1.`fid` AS `fid`, t1.`comments` AS `comments`, t1.`uid` AS `uid`, t1.`created` AS `created`, t3.`nickName` AS `nickName`, t3.`avatar` AS `avatar` FROM `t_comment` t1, (SELECT `id`,`uid` FROM `t_comment` WHERE fid = #{0} ORDER BY created DESC limit #{1},#{2}) t2 ,`t_user_info` t3 WHERE t1.id = t2.id AND t2.uid = t3.id")
    List<HashMap<String, Object>> list(Long fid, Integer pageno, Integer pagesize);

}
