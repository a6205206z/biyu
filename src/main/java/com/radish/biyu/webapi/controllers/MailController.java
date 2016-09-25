package com.radish.biyu.webapi.controllers;

import com.radish.biyu.webapi.response.ResponseDataModel;
import com.radish.biyu.webapi.services.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @date 16/9/25.
 */
@RestController
@RequestMapping("/mail")
public class MailController extends BaseController {
    private Logger log = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private MailService mailService;

    @Deprecated
    @RequestMapping(value = "/get/fromlist/{phone}", method = RequestMethod.GET)
    public ResponseDataModel getMailFromMe(@PathVariable String phone){
        return success(mailService.getMailFromMe(phone));
    }

    @Deprecated
    @RequestMapping(value = "/get/tolist/{phone}", method = RequestMethod.GET)
    public ResponseDataModel getMailToMe(@PathVariable String phone){
        return success(mailService.getMailToMe(phone));
    }

    @Deprecated
    @RequestMapping(value = "/sendnow/{fromPhone}/{toPhone}", method = RequestMethod.POST)
    public ResponseDataModel sendMailNow(@PathVariable String fromPhone,@PathVariable String toPhone,String subject,String content){
        return success(mailService.sendMailNow(fromPhone,toPhone,subject,content));
    }

    @Deprecated
    @RequestMapping(value = "/sendplan/{fromPhone}/{toPhone}", method = RequestMethod.POST)
    public ResponseDataModel sendMailPlan(@PathVariable String fromPhone, @PathVariable String toPhone, String subject, String content, Date dateTime){
        return success(mailService.sendMailPlan(fromPhone,toPhone,subject,content,dateTime));
    }

    @Deprecated
    @RequestMapping(value = "/read/{id}/{phone}", method = RequestMethod.GET)
    public ResponseDataModel readMail(@PathVariable int id,@PathVariable String phone){
        return success(mailService.readMail(id,phone));
    }
}