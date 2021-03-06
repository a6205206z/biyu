package com.radish.biyu.webapi.dao;

import com.radish.biyu.webapi.entity.TComment;
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


    /**
     * 我收到的评论
     *
     * @param uid
     * @param pageno
     * @param pagesize
     * @return
     */
    @Select("SELECT b.`id` AS `id`, b.`fid` AS `fid`, b.`comments` AS `comments`, b.`uid` AS `uid`, b.`created` AS `created`, c.`nickName` AS `nickName`, c.`avatar` AS `avatar` FROM `t_feed` AS a, `t_comment` AS b ,`t_user_info` AS  c WHERE a.`id` = b.`fid` AND a.`uid` = #{0} AND b.uid = c.id ORDER BY b.`created` DESC LIMIT #{1},#{2}")
    List<HashMap<String, Object>> forMeComment(Long uid, Integer pageno, Integer pagesize);


    /**
     * 评论总数
     *
     * @param fid
     * @return
     */
    @Select("SELECT COUNT(0) AS commentnum FROM `t_comment` WHERE fid = #{fid}")
    Integer cntComment(Long fid);

}
