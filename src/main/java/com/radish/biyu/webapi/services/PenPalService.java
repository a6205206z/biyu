package com.radish.biyu.webapi.services;

import com.radish.biyu.webapi.dao.TPenPalDao;
import com.radish.biyu.webapi.entity.TUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
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

    /**
     * Add pen pal boolean.
     *
     * @param phone       the phone
     * @param penpalPhone the penpal phone
     * @return the boolean
     */
    public boolean addPenPal(String phone,String penpalPhone){
        boolean result = false;
        HashMap<String,Object> data = tPenPalDao.getPenPalByPhone(phone,penpalPhone);
        if(data.get("rowcount").equals(0L)){
            result = tPenPalDao.addPenPal(phone,penpalPhone) > 0;
        }
        return  result;
    }

    /**
     * Del pen pal boolean.
     *
     * @param phone       the phone
     * @param penpalPhone the penpal phone
     * @return the boolean
     */
    public boolean delPenPal(String phone,String penpalPhone){
        return tPenPalDao.delPenPal(phone,penpalPhone) > 0;
    }

    /**
     * Get my pen pal list list.
     *
     * @param phone the phone
     * @return the list
     */
    public List<TUserInfo> getMyPenPalList(String phone,int lv){
        return tPenPalDao.getMyPenpalList(phone,lv);
    }

    /**
     * Search penpal list.
     *
     * @param key the key
     * @return the list
     */
    public List<HashMap<String, Object>> searchPenpal(String phone,String key){
        return tPenPalDao.searchPenpal(phone,"%"+key+"%");
    }
}
