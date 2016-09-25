package com.radish.biyu.webapi.controllers;

import com.radish.biyu.webapi.entity.TUserInfo;
import com.radish.biyu.webapi.response.ApiStatusCode;
import com.radish.biyu.webapi.response.ResponseDataModel;
import com.radish.biyu.webapi.services.AccountService;
import com.radish.biyu.webapi.services.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.*;
import java.util.Date;

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

    @Autowired
    private UserInfoService userInfoService;

    @Deprecated
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseDataModel getUser(@PathVariable int id) {
        return success("user:" + id);
    }

    @Deprecated
    @RequestMapping(value = "/valid/{phone}/{password}", method = RequestMethod.GET)
    public ResponseDataModel validateAccount(@PathVariable String phone, @PathVariable String password) {
        return success(accountService.validateAccount(phone, password));
    }

    @Deprecated
    @RequestMapping(value = "/add/{phone}/{password}", method = RequestMethod.GET)
    public ResponseDataModel addAccount(@PathVariable String phone, @PathVariable String password) {
        return success(accountService.addAccount(phone, password));
    }

    @Deprecated
    @RequestMapping(value = "/password/change/{phone}", method = RequestMethod.POST)
    public ResponseDataModel changePassword(@PathVariable String phone, String oldPassword, String newPassword) {
        return success(accountService.changePassword(phone, oldPassword, newPassword));
    }

    /**
     * 修改头像
     *
     * @param id
     * @param pic
     * @return
     */
    @RequestMapping(value = "/modify/avatar/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyAvatar(@PathVariable Integer id, String pic) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(pic)) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setAvatar(pic)));
    }

    /**
     * 修改笔名
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "/modify/nick/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyNickName(@PathVariable Integer id, String name) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(name)) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setNickname(name)));
    }

    /**
     * 修改个性签名
     *
     * @param id
     * @param signature
     * @return
     */
    @RequestMapping(value = "/modify/signature/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifySignature(@PathVariable Integer id, String signature) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(signature)) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setSignature(signature)));
    }

    /**
     * 性别+生日+星座
     *
     * @param id
     * @param sex
     * @param birthday
     * @param sign
     * @return
     */
    @RequestMapping(value = "/modify/info/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyInfo(@PathVariable Integer id, String sex, String birthday, String sign) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(sex) || StringUtils.isEmpty(birthday) || StringUtils.isEmpty(sign)) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        Date b = null;
        try {
            b = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        } catch (ParseException e) {
            log.error("", e);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setSex(sex).setBirthday(b).setZodiac(sign)));
    }

    /**
     * 座标+状态+爱好
     *
     * @param id
     * @param location
     * @param status
     * @param favorite
     * @return
     */
    @RequestMapping(value = "/modify/otherinfo/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyOtherInfo(@PathVariable Integer id, String location, String status, String favorite) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(location) || StringUtils.isEmpty(status) || StringUtils.isEmpty(favorite)) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setLocation(location).setStatus(status).setFavorite(favorite)));
    }


    /**
     * 修改需求
     *
     * @param id
     * @param needs
     * @return
     */
    @RequestMapping(value = "/modify/needs/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyNeeds(@PathVariable Integer id, String needs) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(needs)) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setNeeds(needs)));
    }

    /**
     * 修改邮编
     *
     * @param id
     * @param postcode
     * @return
     */
    @RequestMapping(value = "/modify/postcode/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyPostCode(@PathVariable Integer id, String postcode) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(postcode)) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setPostcode(postcode)));
    }


    @RequestMapping(value = "/test/point/{id}", method = RequestMethod.POST)
    public ResponseDataModel testAddPoint(@PathVariable Integer id) {
        return this.success(userInfoService.addPoint(id, false, 10L, "y"));
    }

}
