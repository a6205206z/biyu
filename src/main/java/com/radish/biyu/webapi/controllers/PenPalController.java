package com.radish.biyu.webapi.controllers;

import com.radish.biyu.webapi.response.ApiStatusCode;
import com.radish.biyu.webapi.response.ResponseDataModel;
import com.radish.biyu.webapi.services.PenPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author cean
 * @version com.radish.biyu.webapi.controllers, v 0.1
 * @date 16 /9/27.
 */
@RestController
@RequestMapping("/penpal")
public class PenPalController extends BaseController {
    /**
     * The Pen pal service.
     */
    @Autowired
    PenPalService penPalService;

    /**
     * Add penpal response data model.
     *
     * @param phone       the phone
     * @param penpalphone the penpalphone
     * @param lv          1关注 2熟悉 3笔友
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/add/{phone}/{penpalphone}/{lv}", method = RequestMethod.GET)
    public ResponseDataModel addPenpal(@PathVariable String phone, @PathVariable String penpalphone, @PathVariable int lv) {
        return success(penPalService.addPenPal(phone, penpalphone, lv));
    }

    /**
     * Del penpal response data model.
     *
     * @param phone       the phone
     * @param penpalphone the penpalphone
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/del/{phone}/{penpalphone}", method = RequestMethod.GET)
    public ResponseDataModel delPenpal(@PathVariable String phone, @PathVariable String penpalphone) {
        return success(penPalService.delPenPal(phone, penpalphone));
    }

    /**
     * Get penpal list response data model.
     *
     * @param phone the phone
     * @param lv    the lv
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/list/{lv}/{phone}", method = RequestMethod.GET)
    public ResponseDataModel getPenpalList(@PathVariable String phone, @PathVariable int lv) {
        return success(penPalService.getMyPenPalList(phone, lv));
    }

    /**
     * Search penpal response data model.
     *
     * @param phone   the phone
     * @param sex     the sex
     * @param minDate the min date
     * @param maxDate the max date
     * @param zodiac  the zodiac
     * @param status  the status
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/search/{phone}", method = RequestMethod.POST)
    public ResponseDataModel searchPenpal(@PathVariable("phone") String phone, int sex, Date minDate, Date maxDate, String zodiac, String status) {
        if (this.penPalService.searchAddLog(phone)) {
            return success(penPalService.searchPenpal(phone, sex, minDate, maxDate, zodiac, status));
        } else {
            return error(ApiStatusCode.SEARCH_LIMIE_CNT);
        }
    }

    /**
     * Ignore user response data model.
     *
     * @param phone     the phone
     * @param userPhone the user phone
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/ignore/{phone}/{userphone}", method = RequestMethod.GET)
    public ResponseDataModel ignoreUser(@PathVariable("phone") String phone, @PathVariable("userphone") String userPhone) {
        return success(penPalService.ignoreUser(phone, userPhone));
    }

    /**
     * Surplus search count response data model.
     *
     * @param phone the phone
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/search/count/{phone}", method = RequestMethod.GET)
    public ResponseDataModel surplusSearchCount(@PathVariable("phone") String phone) {
        return success(penPalService.surplusSearchCount(phone));
    }

    /**
     * getPenPalByPhone
     *
     * @param phone the phone
     * @param penpalPhone the penpal phone
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/get/{phone}/{penpalPhone}", method = RequestMethod.GET)
    public ResponseDataModel getPenPalByPhone(@PathVariable("phone") String phone,@PathVariable("penpalPhone") String penpalPhone) {
        return success(penPalService.getPenPalByPhone(phone,penpalPhone));
    }
}
