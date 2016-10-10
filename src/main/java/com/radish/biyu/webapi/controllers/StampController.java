package com.radish.biyu.webapi.controllers;

import com.radish.biyu.webapi.response.ApiStatusCode;
import com.radish.biyu.webapi.response.ResponseDataModel;
import com.radish.biyu.webapi.services.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * radish.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 *
 * @author tiaotiaohu
 * @version TStampDao, v 0.1
 * @date 2016/10/10 23:16
 */
@RestController
@RequestMapping("/stamp")
public class StampController extends BaseController {
    private Logger log = LoggerFactory.getLogger(StampController.class);

    @Autowired
    private MailService mailService;

    /**
     * 翻页查询邮票列表
     *
     * @param mobile
     * @param pageno
     * @param pagesize
     * @return
     */
    @RequestMapping(value = "/list/{mobile}/{pageno}/{pagesize}")
    public ResponseDataModel list(@PathVariable String mobile, @PathVariable Integer pageno, @PathVariable Integer pagesize) {
        if (pageno == null)
            pageno = 0;
        if (pagesize == null)
            pagesize = 20;
        if (null == mobile)
            return this.error(ApiStatusCode.PARAM_ERROR);
        return this.success(this.mailService.list(mobile, pageno, pagesize));
    }
}
