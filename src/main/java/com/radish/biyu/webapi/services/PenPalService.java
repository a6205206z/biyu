package com.radish.biyu.webapi.services;

import com.radish.biyu.webapi.dao.TPenPalDao;
import com.radish.biyu.webapi.dao.TSearchLogDao;
import com.radish.biyu.webapi.entity.TSearchLog;
import com.radish.biyu.webapi.entity.TUserInfo;
import com.radish.biyu.webapi.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author cean
 * @version com.radish.biyu.webapi.services, v 0.1
 * @date 16 /9/27.
 */
@Service
public class PenPalService {
    private static Logger log = LoggerFactory.getLogger(PenPalService.class);
    /**
     * The T pen pal dao.
     */
    @Autowired
    TPenPalDao tPenPalDao;
    @Autowired
    TSearchLogDao tSearchLogDao;

    /**
     * Add pen pal boolean.
     *
     * @param phone       the phone
     * @param penpalPhone the penpal phone
     * @param lv          好友等级
     * @return the boolean
     */
    public boolean addPenPal(String phone, String penpalPhone, int lv) {
        boolean result = false;
        HashMap<String, Object> data = tPenPalDao.getPenPalByPhone(phone, penpalPhone);
        if (data.get("rowcount").equals(0L)) {
            result = tPenPalDao.addPenPal(phone, penpalPhone, lv) > 0;
        }
        return result;
    }

    /**
     * Get pen pal hash map.
     *
     * @param phone       the phone
     * @param penpalPhone the penpal phone
     * @return the HashMap
     */
    public HashMap<String,Object> getPenPalByPhone(String phone, String penpalPhone) {
        return tPenPalDao.getPenPal(phone,penpalPhone);
    }

    /**
     * Del pen pal boolean.
     *
     * @param phone       the phone
     * @param penpalPhone the penpal phone
     * @return the boolean
     */
    public boolean delPenPal(String phone, String penpalPhone) {
        return tPenPalDao.delPenPal(phone, penpalPhone) > 0;
    }

    /**
     * Get my pen pal list list.
     *
     * @param phone the phone
     * @param lv    the lv
     * @return the list
     */
    public List<TUserInfo> getMyPenPalList(String phone, int lv) {
        return tPenPalDao.getMyPenpalList(phone, lv);
    }

    /**
     * 添加搜索日志
     *
     * @param phone
     * @return
     */
    public boolean searchAddLog(String phone) {
        Integer t = 0;
        t = tSearchLogDao.cnt(phone, Helper.getTodayString());
        if (t == null || t < 10) {
            TSearchLog log = new TSearchLog();
            log.setPhone(phone);
            log.setCondition("");
            log.setSearchTime(new Date());
            tSearchLogDao.insert(log);
            return true;
        }
        return false;
    }

    /**
     * Search penpal list.
     *
     * @param phone   the phone
     * @param sex     the sex
     * @param minDate the min date
     * @param maxDate the max date
     * @param zodiac  the zodiac
     * @param status  the status
     * @return the list
     */
    public List<HashMap<String, Object>> searchPenpal(String phone, int sex, Date minDate, Date maxDate, String zodiac, String status) {
        return tPenPalDao.searchPenpal(phone, sex, minDate, maxDate, zodiac, status);
    }

    /**
     * Ignore user boolean.
     *
     * @param phone     the phone
     * @param userPhone the user phone
     * @return the boolean
     */
    public boolean ignoreUser(String phone, String userPhone) {
        return true;
    }

    /**
     * Surplus search count int.
     *
     * @param phone the phone
     * @return the int
     */
    public int surplusSearchCount(String phone) {
        return 1;
    }
}
