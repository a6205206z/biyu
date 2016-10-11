package com.radish.biyu.webapi.services;

import com.radish.biyu.webapi.dao.TAccountDao;
import com.radish.biyu.webapi.dao.TSmsLogDao;
import com.radish.biyu.webapi.dao.TUserInfoDao;
import com.radish.biyu.webapi.entity.TAccount;
import com.radish.biyu.webapi.entity.TUserInfo;
import com.radish.biyu.webapi.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author cean
 * @version com.radish.biyu.webapi.services, v 0.1
 * @date 16 /9/24.
 */
@Service
public class AccountService {
    private static Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private TAccountDao tAccountDao;

    @Autowired
    private TSmsLogDao tSmsLogDao;
    @Autowired
    private TUserInfoDao infodao;

    /**
     * Validate account boolean.
     *
     * @param phone    the phone
     * @param password the password
     * @return the boolean
     */
    public boolean validateAccount(String phone, String password) {
        boolean result = false;

        try {
            password = Helper.EncoderByMd5(password);
        } catch (Exception e) {
            log.error(e.toString());
        }

        HashMap<String, Object> data = tAccountDao.validateAccount(phone, password);
        if (data.get("rowcount").equals(1L)) {
            result = true;
        }
        return result;
    }

    /**
     * Login hash map.
     *
     * @param phone    the phone
     * @param password the password
     * @return the hash map
     */
    public TUserInfo login(String phone, String password){

        TUserInfo result = null;
        try {
            password = Helper.EncoderByMd5(password);
        } catch (Exception e) {
            log.error(e.toString());
        }

        HashMap<String, Object> data = tAccountDao.validateAccount(phone, password);
        if (data.get("rowcount").equals(1L)) {
            result = infodao.selectByPhone(phone);
        }
        return result;
    }

    /**
     * 注册验证短信，15分钟内有效
     *
     * @param phone      the phone
     * @param verifiCode the verifi code
     * @return boolean
     */
    public boolean checkVerifiCode(String phone, String verifiCode) {
        boolean result = false;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, -15);
        Long exists = this.tSmsLogDao.checkVerifiCode(phone, verifiCode, c.getTime());
        if (null != exists && exists > 0) {
            result = true;
        }
        return result;
    }

    /**
     * Add account boolean.
     *
     * @param phone    the phone
     * @param password the password
     * @return the boolean
     */
    public Integer addAccount(String phone, String password) {
        HashMap<String, Object> data = tAccountDao.getAccountByPhone(phone);
        if ((long) data.get("rowcount") == 0) {
            try {
                password = Helper.EncoderByMd5(password);
                TAccount account = new TAccount();
                account.setPhone(phone);
                account.setPassword(password);
                if (tAccountDao.addAccount(account) > 0) {
                    //TODO: 初始基础信息表记录
                    infodao.initUserInfo(account.getId(), phone);
                    return account.getId();
                }
            } catch (Exception e) {
                log.error(e.toString());
            }
        }
        return null;
    }

    /**
     * Change password boolean.
     *
     * @param phone       the phone
     * @param oldpassword the oldpassword
     * @param newpassword the newpassword
     * @return the boolean
     */
    public boolean changePassword(String phone, String oldpassword, String newpassword) {
        boolean result = false;
        try {
            oldpassword = Helper.EncoderByMd5(oldpassword);
            newpassword = Helper.EncoderByMd5(newpassword);

            int r = tAccountDao.updatePassword(phone, oldpassword, newpassword);
            result = (r > 0);
        } catch (Exception e) {
            log.error(e.toString());
        }

        return result;
    }


    /**
     * 添加短信验证码记录
     *
     * @param mobile     the mobile
     * @param verifiCode the verifi code
     * @return boolean
     */
    public boolean addSmsLog(String mobile, String verifiCode) {
        boolean result = false;
        try {
            int r = tSmsLogDao.addSmsLog(mobile, verifiCode, new Date());
            result = (r > 0);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }
}
