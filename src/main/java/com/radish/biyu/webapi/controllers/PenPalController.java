package com.radish.biyu.webapi.controllers;

import com.radish.biyu.webapi.response.ResponseDataModel;
import com.radish.biyu.webapi.services.PenPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.DeclareRoles;
import java.util.Date;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author cean
 * @version com.radish.biyu.webapi.controllers, v 0.1
 * @date 16/9/27.
 */
@RestController
@RequestMapping("/penpal")
public class PenPalController extends BaseController {
    @Autowired
    PenPalService penPalService;

    @Deprecated
    @RequestMapping(value = "/add/{phone}/{penpalphone}", method = RequestMethod.GET)
    public ResponseDataModel addPenpal(@PathVariable String phone, @PathVariable String penpalphone) {
        return success(penPalService.addPenPal(phone, penpalphone));
    }

    @Deprecated
    @RequestMapping(value = "/del/{phone}/{penpalphone}", method = RequestMethod.GET)
    public ResponseDataModel delPenpal(@PathVariable String phone, @PathVariable String penpalphone){
        return success(penPalService.delPenPal(phone,penpalphone));
    }

    @Deprecated
    @RequestMapping(value = "/list/{lv}/{phone}", method = RequestMethod.GET)
    public ResponseDataModel getPenpalList(@PathVariable String phone,@PathVariable int lv){
        return success(penPalService.getMyPenPalList(phone,lv));
    }

    @Deprecated
    @RequestMapping(value = "/search/{phone}", method = RequestMethod.POST)
    public ResponseDataModel searchPenpal(@PathVariable("phone") String phone, int sex, Date minDate, Date maxDate, String zodiac, String status){
        return success(penPalService.searchPenpal(phone, sex, minDate, maxDate, zodiac, status));
    }

    @Deprecated
    @RequestMapping(value = "/ignore/{phone}/{userphone}", method = RequestMethod.GET)
    public ResponseDataModel ignoreUser(@PathVariable("phone") String phone,@PathVariable("userphone") String userPhone){
        return  success(penPalService.ignoreUser(phone,userPhone));
    }

    @Deprecated
    @RequestMapping(value = "/search/count/{phone}", method = RequestMethod.GET)
    public ResponseDataModel surplusSearchCount(@PathVariable("phone") String phone){
        return success(penPalService.surplusSearchCount(phone));
    }
}
