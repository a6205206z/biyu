package com.radish.biyu.webapi.dao;

import com.radish.biyu.webapi.entity.TPointIo;
import com.radish.biyu.webapi.entity.TUserInfo;
import com.radish.biyu.webapi.provider.UserInfoProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.dao.TUserInfoDao, v 0.1
 * @date 2016/9/25.`
 */
@Repository
public interface TUserInfoDao {

    @Insert("INSERT INTO t_user_info (`id`, `accountPhone`) VALUES (#{id},#{accountPhone})")
    int initUserInfo(@Param("id") Integer id, @Param("accountPhone") String accountPhone);

    /**
     * 基础信息操作
     *
     * @param info
     * @return
     */
    @UpdateProvider(type = UserInfoProvider.class, method = "updateSql")
    boolean update(TUserInfo info);

    /**
     * 查询会员基础信息
     *
     * @param id
     * @return
     */
    @Select("SELECT `id`, `accountPhone` as accountphone, `avatar`, `postCode` as postcode, `nickName` as nickname, `sex`, `birthDay` as birthday, `zodiac`, `location`, `favorite`, `needs`, `status`, `signature`, `point`, `updated` FROM t_user_info WHERE id = #{id}")
    TUserInfo select(Integer id);

    /**
     * 查询会员基础信息ByPhone
     *
     * @param phone
     * @return
     */
    @Select("SELECT `id`, `accountPhone` as accountphone, `avatar`, `postCode` as postcode, `nickName` as nickname, `sex`, `birthDay` as birthday, `zodiac`, `location`, `favorite`, `needs`, `status`, `signature`, `point`, `updated` FROM t_user_info WHERE accountPhone = #{phone}")
    TUserInfo selectByPhone(String phone);

    /**
     * 积分操作
     *
     * @param info
     * @return
     */
    @UpdateProvider(type = UserInfoProvider.class, method = "updatePointSql")
    boolean updatePointSql(TUserInfo info);

    /**
     * 积分日志记录
     *
     * @param pointIo
     * @return
     */
    @Insert("INSERT INTO t_point_io (`accountPhone`,`currentPoint`,`changePoint`,`changeDate`,`reson`) VALUES (#{accountphone},#{currentpoint},#{changepoint},#{changedate},#{reson})")
    int addPointlog(TPointIo pointIo);

}
