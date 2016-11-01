package com.radish.biyu.webapi.dao;

import com.radish.biyu.webapi.entity.TUserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
 * @date 16/9/27.
 */
@Repository
public interface TPenPalDao {
    @Insert("INSERT INTO t_penpal (phone,penpalPhone,createDate,lv)VALUES(#{phone},#{penpalPhone},now(),#{lv})")
    int addPenPal(@Param("phone") String phone,@Param("penpalPhone") String penpalPhone, @Param("lv") int lv);

    @Delete("DELETE FROM t_penpal WHERE phone=#{phone} AND penpalPhone=#{penpalPhone}")
    int delPenPal(@Param("phone") String phone,@Param("penpalPhone") String penpalPhone);

    @Select("SELECT count(0) as rowcount FROM t_penpal WHERE phone=#{phone} AND penpalPhone=#{penpalPhone}")
    HashMap<String,Object> getPenPalByPhone(@Param("phone") String phone,@Param("penpalPhone") String penpalPhone);

    @Select("SELECT * as rowcount FROM t_penpal WHERE phone=#{phone} AND penpalPhone=#{penpalPhone}")
    HashMap<String,Object> getPenPal(@Param("phone") String phone,@Param("penpalPhone") String penpalPhone);

    @Select("SELECT p.`lv`,u.`id`, `accountPhone` as accountphone, `avatar`, `postCode` as postcode, `nickName` as nickname, `sex`, `birthDay` as birthday, `zodiac`, `location`, `favorite`, `needs`, `status`, `signature`, `point`, `updated` FROM t_penpal as p LEFT JOIN t_user_info as u on p.`penpalPhone` = u.`accountPhone` WHERE p.phone = #{phone} and p.lv = #{lv}")
    List<TUserInfo> getMyPenpalList(@Param("phone") String phone,@Param("lv") int lv);

    @Select("SELECT u.`id`, `accountPhone` as accountphone, `avatar`, `postCode` as postcode, `nickName` as nickname, `sex`, `birthDay` as birthday, `zodiac`, `location`, `favorite`, `needs`, `status`, `signature`, `point`, (p.phone = #{phone}) as `ismypenpal` ,`updated` FROM t_user_info as u LEFT JOIN `t_penpal` as p on p.`penpalPhone` = u.`accountPhone` where (#{sex}= -1 or u.sex = #{sex}) and  (u.birthDay between #{minDate} and #{maxDate}) and (#{zodiac}='all' or u.zodiac = #{zodiac}) and (#{status}='all' or u.status = #{status})")
    List<HashMap<String, Object>> searchPenpal(@Param("phone") String phone,@Param("sex") int sex,@Param("minDate") Date minDate,@Param("maxDate") Date maxDate,@Param("zodiac") String zodiac,@Param("status") String status);
}
