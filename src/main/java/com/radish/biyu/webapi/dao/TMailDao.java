package com.radish.biyu.webapi.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author cean
 * @version com.radish.biyu.webapi.dao, v 0.1
 * @date 16/9/25.
 */
@Repository
public interface TMailDao {

    @Select("SELECT * FROM t_mail WHERE fromPhone = #{phone}")
    List<HashMap<String,Object>> getMailFormMe(@Param("phone") String phone);

    @Select("SELECT * FROM t_mail as m LEFT JOIN t_user_info as u on m.fromPhone = u.accountPhone WHERE m.toPhone = #{phone} AND (#{status}=-1 OR m.status = #{status}) AND  allowReciveDate < now()")
    List<HashMap<String,Object>> getMailToMe(@Param("phone") String phone,@Param("status") int status);

    @Insert("INSERT INTO `t_mail` (`subject`, `content`, `fromPhone`, `toPhone`, `status`, `sendDate`, `allowReciveDate`) VALUES (#{subject}, #{content}, #{fromPhone}, #{toPhone}, #{status}, #{sendDate}, #{allowReciveDate});\n")
    int addMail(@Param("subject") String subject, @Param("content") String content, @Param("fromPhone") String fromPhone,
                @Param("toPhone") String toPhone, @Param("status") int status, @Param("sendDate")Date sendDate,
                @Param("allowReciveDate") Date allowReciveDate);


    @Update("UPDATE t_mail SET status = #{status} WHERE id = #{id} AND toPhone = #{phone}")
    int updateMailStatus(@Param("status") int status,@Param("id") int id,@Param("phone") String phone);

    @Select("SELECT * FROM t_mail WHERE id = #{id} AND allowReciveDate < now() AND toPhone = #{phone}")
    HashMap<String,Object> getMailByID(@Param("id") int id,@Param("phone") String phone);
}
