package com.radish.biyu.webapi.services;

import com.alibaba.fastjson.JSON;
import com.radish.biyu.webapi.dao.TUserInfoDao;
import com.radish.biyu.webapi.entity.TPointIo;
import com.radish.biyu.webapi.entity.TUserInfo;
import com.radish.biyu.webapi.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.services.UserInfoService, v 0.1
 * @date 2016/9/25.
 */
@Service
public class UserInfoService {

    private static Logger log = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private TUserInfoDao infodao;

    /**
     * 更新会员信息
     *
     * @param info
     * @return
     */
    public boolean modifyInfo(TUserInfo info) {
        boolean result = false;
        try {
            info.setUpdated(new Date());
            result = infodao.update(info);
        } catch (Exception e) {
            log.error("modifyInfo error:", e);
        }
        return result;
    }

    /**
     * 积分操作项
     *
     * @param uid   会员ID
     * @param flag  true:加 flase 减
     * @param point 积分
     * @param reson 原因
     * @return
     */
//    @Transactional(rollbackFor = Exception.class)
    public boolean addPoint(Integer uid, boolean flag, Long point, String reson) {
        boolean result = false;
        try {
            TUserInfo user = infodao.select(uid);
            if (null == user) {
                log.debug("not found uid: {}", uid);
                return false;
            }

            log.info("user:" + JSON.toJSONString(user));
            if (null == point || point <= 0) {
                log.debug("point param error");
                return false;
            }

            boolean back = infodao.updatePointSql(new TUserInfo().setId(user.getId()).setFlag(flag).setPoint(point).setUpdated(new Date()));

            //添加日志
            if (back) {
                TPointIo io = new TPointIo();
                io.setCurrentpoint(user.getPoint());
                if (flag) {
                    io.setChangepoint(point);
                } else {
                    io.setChangepoint(-point);
                }
                io.setAccountphone(user.getAccountphone());
                io.setChangedate(new Date());
                io.setReson(reson);

                infodao.addPointlog(io);

                log.info("opt point success! uid={}***flag={}***point={}", uid, flag, point);

                result = true;
            }
        } catch (Exception e) {
            log.error("addPoint error:", e);
//            throw e;
        }
        return result;
    }


}
