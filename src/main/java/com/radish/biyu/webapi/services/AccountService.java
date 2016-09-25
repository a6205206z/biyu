package com.radish.biyu.webapi.services;

import com.radish.biyu.webapi.dao.TAccountDao;
import com.radish.biyu.webapi.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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

    /**
     * Validate account boolean.
     *
     * @param phone    the phone
     * @param password the password
     * @return the boolean
     */
    public boolean validateAccount(String phone,String password){
        boolean result = false;

        try {
            password = Helper.EncoderByMd5(password);
        } catch (Exception e) {
            log.error(e.toString());
        }

        HashMap<String,Object> data = tAccountDao.validateAccount(phone,password);
        if(data.get("rowcount").equals(1L)){
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
    public boolean addAccount(String phone,String password){
        boolean result = false;

        HashMap<String,Object> data = tAccountDao.getAccountByPhone(phone);
        if((long)data.get("rowcount") == 0) {
            try {
                password = Helper.EncoderByMd5(password);
                int r = tAccountDao.addAccount(phone,password);
                result = (r>0);
            } catch (Exception e) {
                log.error(e.toString());
            }
        }

        return result;
    }

    /**
     * Change password boolean.
     *
     * @param phone       the phone
     * @param oldpassword the oldpassword
     * @param newpassword the newpassword
     * @return the boolean
     */
    public boolean changePassword(String phone,String oldpassword,String newpassword){
        boolean result = false;
        try {
            oldpassword = Helper.EncoderByMd5(oldpassword);
            newpassword = Helper.EncoderByMd5(newpassword);

            int r = tAccountDao.updatePassword(phone,oldpassword,newpassword);
            result = (r>0);
        } catch (Exception e) {
            log.error(e.toString());
        }

        return result;
    }
}
