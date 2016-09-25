package com.radish.biyu.webapi.dao;

import com.radish.biyu.webapi.entity.TPointIo;
import com.radish.biyu.webapi.entity.TUserInfo;
import com.radish.biyu.webapi.provider.UserInfoProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

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
