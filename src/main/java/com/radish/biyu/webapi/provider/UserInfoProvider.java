package com.radish.biyu.webapi.provider;

import com.radish.biyu.webapi.entity.TUserInfo;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * 会员基础信息SQL生成器
 * <p>
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.provider.UserInfoProvider, v 0.1
 * @date 2016/9/25.
 */
public class UserInfoProvider {
    private static final String TABLE_NAME = "t_user_info";

    /**
     * 更新会员资料接口
     *
     * @param info
     * @return
     */
    public String updateSql(final TUserInfo info) {
        BEGIN();
        UPDATE(TABLE_NAME);
        //头像
        if (!StringUtils.isEmpty(info.getAvatar())) {
            SET("avatar = #{avatar}");
        }
        //笔名
        if (!StringUtils.isEmpty(info.getNickname())) {
            SET("nickName = #{nickname}");
        }
        //个性签名
        if (!StringUtils.isEmpty(info.getSignature())) {
            SET("signature = #{signature}");
        }

        //性别+生日+星座
        if (!StringUtils.isEmpty(info.getSex())) {
            SET("sex = #{sex}");
        }
        if (!StringUtils.isEmpty(info.getBirthday())) {
            SET("birthday = #{birthday}");
        }
        if (!StringUtils.isEmpty(info.getZodiac())) {
            SET("zodiac = #{zodiac}");
        }

        //坐标、状态、爱好 === {JSON}
        if (!StringUtils.isEmpty(info.getLocation())) {
            SET("location = #{location}");
        }
        if (!StringUtils.isEmpty(info.getStatus())) {
            SET("status = #{status}");
        }
        if (!StringUtils.isEmpty(info.getFavorite())) {
            SET("favorite = #{favorite}");
        }

        //需求
        if (!StringUtils.isEmpty(info.getNeeds())) {
            SET("needs = #{needs}");
        }

        //邮编
        if (!StringUtils.isEmpty(info.getPostcode())) {
            SET("postCode = #{postcode}");
        }
        //最后更新时间
        SET("updated = #{updated}");

        WHERE("id = #{id}");
        return SQL();
    }

    /**
     * 积分操作项
     *
     * @param info
     * @return
     */
    public String updatePointSql(final TUserInfo info) {
        BEGIN();
        UPDATE(TABLE_NAME);
        if (info.isFlag()) {
            SET("point = point + #{point}");
        } else {
            SET("point = point - #{point}");
        }
        //最后更新时间
        SET("updated = #{updated}");

        WHERE("id = #{id}");
        return SQL();
    }

}