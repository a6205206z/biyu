package com.radish.biyu.webapi.controllers;

import com.radish.biyu.webapi.response.ResponseDataModel;
import com.radish.biyu.webapi.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @date 16/9/12.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AccountService accountService;

    @Deprecated
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseDataModel getUser(@PathVariable int id) {
        return success("user:"+id);
    }

    @Deprecated
    @RequestMapping(value = "/valid/{phone}/{password}", method = RequestMethod.GET)
    public ResponseDataModel validateAccount(@PathVariable String phone, @PathVariable String password) {
        return success(accountService.validateAccount(phone, password));
    }

    @Deprecated
    @RequestMapping(value = "/add/{phone}/{password}", method = RequestMethod.GET)
    public ResponseDataModel addAccount(@PathVariable String phone, @PathVariable String password){
        return  success(accountService.addAccount(phone,password));
    }

    @Deprecated
    @RequestMapping(value = "/password/change/{phone}", method = RequestMethod.POST)
    public ResponseDataModel changePassword(@PathVariable String phone, String oldPassword, String newPassword){
        return success(accountService.changePassword(phone,oldPassword,newPassword));
    }
}
