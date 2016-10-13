package com.radish.biyu.webapi.controllers;

import com.radish.biyu.webapi.response.ResponseDataModel;
import com.radish.biyu.webapi.services.PenPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/search/{phone}/{key}", method = RequestMethod.GET)
    public ResponseDataModel searchPenpal(@PathVariable("phone") String phone,@PathVariable String key){
        return success(penPalService.searchPenpal(phone,key));
    }
}
