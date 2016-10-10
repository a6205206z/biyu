package com.radish.biyu.webapi.dao;

import com.radish.biyu.webapi.entity.TAccount;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author cean
 * @version com.radish.biyu.webapi.dao, v 0.1
 * @date 16/9/24.
 */
@Repository
public interface TAccountDao {
    @Select("SELECT count(0) as rowcount FROM t_account WHERE phone = #{phone} AND password = #{password}")
    HashMap<String, Object> validateAccount(@Param("phone") String phone, @Param("password") String password);

    @Select("SELECT count(0) as rowcount FROM t_account WHERE phone = #{phone}")
    HashMap<String, Object> getAccountByPhone(@Param("phone") String phone);

    @Update("UPDATE t_account SET password = #{newpassword} WHERE phone = #{phone} AND password = #{oldpassword}")
    int updatePassword(@Param("phone") String phone, @Param("oldpassword") String oldpassword, @Param("newpassword") String newpassword);

    @Insert("INSERT INTO t_account (phone,password) VALUES (#{phone},#{password})")
    @Options(useGeneratedKeys = true)
    int addAccount(TAccount account);
}
