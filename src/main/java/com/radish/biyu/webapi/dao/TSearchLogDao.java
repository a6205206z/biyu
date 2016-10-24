package com.radish.biyu.webapi.dao;

import com.radish.biyu.webapi.entity.TSearchLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by hemingxie on 2016/10/24.
 */
@Repository
public interface TSearchLogDao {
    @Insert("INSERT INTO `t_search_log` (`phone`, `search_time`, `condition`) VALUES(#{phone}, #{searchTime}, #{condition})")
    Integer insert(TSearchLog log);

    @Select("SELECT COUNT(0) AS cnt FROM `t_search_log` WHERE `phone` = #{0} AND`search_time` >=#{1}")
    Integer cnt(String phone, String date);
}
