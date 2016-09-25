package com.radish.biyu.webapi.controllers;


import com.radish.biyu.webapi.response.ApiStatusCode;
import com.radish.biyu.webapi.response.ResponseDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * radish.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 *
 * @author tiaotiaohu
 * @version BaseController, v 0.1
 * @date 2016/9/14 12:50
 */
public class BaseController {
    private static final Logger log = LoggerFactory.getLogger(BaseController.class);
    
    /**
     * 返回错误提示
     *
     * @param code the code
     * @return the mapping jackson value
     */
    public ResponseDataModel error(ApiStatusCode code) {
        ResponseDataModel rdm = new ResponseDataModel();
        rdm.setCode(code.code());
        rdm.setMsg(code.msg());
        rdm.setData("");
        return rdm;
    }

    /**
     * 正确返回值
     *
     * @param obj the obj
     * @return the mapping jackson value
     */
    public ResponseDataModel success(Object obj) {
        ResponseDataModel rdm = new ResponseDataModel();
        rdm.setCode(ApiStatusCode.SUCCESS.code());
        rdm.setMsg(ApiStatusCode.SUCCESS.msg());
        rdm.setData(obj);
        return rdm;
    }
}
