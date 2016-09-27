package com.radish.biyu.webapi.dao;

import com.radish.biyu.webapi.entity.TFeed;
import com.radish.biyu.webapi.entity.TUserInfo;
import com.radish.biyu.webapi.provider.FeedProvider;
import com.radish.biyu.webapi.provider.UserInfoProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.dao.TFeedDao, v 0.1
 * @date 2016/9/26.
 */
@Repository
public interface TFeedDao {

    @Insert("INSERT INTO `t_feed` (`uid`,`ftype`,`message`,`forwarded`,`liked`, `pic`, `lng`, `lat`, `created`) VALUES(#{uid},#{ftype},#{message},#{forwarded},#{liked},#{pic},#{lng},#{lat},#{created})")
    Long insert(TFeed feed);

    @Select("SELECT `id`,`uid`,`ftype`,`message`,`forwarded`,`liked`,`pic`,`lng`,`lat`,`created` FROM `t_feed` WHERE id =#{id}")
    TFeed get(Long id);

    @SelectProvider(type = FeedProvider.class, method = "listSql")
    List<HashMap<String, Object>> list(HashMap<String, Object> param);

    @UpdateProvider(type = FeedProvider.class, method = "clickFav")
    boolean clickFav(HashMap<String, Object> param);

}
