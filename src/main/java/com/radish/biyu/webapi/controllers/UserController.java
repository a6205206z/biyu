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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author cean
 * @version com.radish.biyu.webapi.controllers, v 0.1
 * @date 16 /9/12.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserInfoService userInfoService;


    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    @Deprecated
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseDataModel getUser(@PathVariable int id) {
        return success("user:" + id);
    }

    /**
     * Validate account response data model.
     *
     * @param phone    the phone
     * @param password the password
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/valid/{phone}/{password}", method = RequestMethod.GET)
    public ResponseDataModel validateAccount(@PathVariable String phone, @PathVariable String password) {
        return success(accountService.validateAccount(phone, password));
    }

    /**
     * Login response data model.
     *
     * @param phone    the phone
     * @param password the password
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/login/{phone}/{password}", method = RequestMethod.GET)
    public ResponseDataModel login(@PathVariable String phone, @PathVariable String password){
        return success(accountService.login(phone,password));
    }

    /**
     * 注册第一步较验
     *
     * @param phone      the phone
     * @param verifiCode the verifi code
     * @return response data model
     */
    @RequestMapping(value = "/register/{phone}/{verifiCode}", method = RequestMethod.POST)
    public ResponseDataModel checkVerifiCode(@PathVariable String phone, @PathVariable String verifiCode) {
        return success(accountService.checkVerifiCode(phone, verifiCode));
    }

    /**
     * Add account response data model.
     *
     * @param phone    the phone
     * @param password the password
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/add/{phone}/{password}", method = RequestMethod.GET)
    public ResponseDataModel addAccount(@PathVariable String phone, @PathVariable String password) {
        return success(accountService.addAccount(phone, password));
    }

    /**
     * Change password response data model.
     *
     * @param phone       the phone
     * @param oldPassword the old password
     * @param newPassword the new password
     * @return the response data model
     */
    @Deprecated
    @RequestMapping(value = "/password/change/{phone}", method = RequestMethod.POST)
    public ResponseDataModel changePassword(@PathVariable String phone, String oldPassword, String newPassword) {
        return success(accountService.changePassword(phone, oldPassword, newPassword));
    }

    /**
     * 查询会员基础信息接口
     *
     * @param id the id
     * @return response data model
     */
    @RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
    public ResponseDataModel selectUserInfo(@PathVariable Integer id) {
        if (StringUtils.isEmpty(id)) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.selectUserInfo(id));
    }

    /**
     * 修改头像
     *
     * @param id  the id
     * @param pic the pic
     * @return response data model
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
     * @param id   the id
     * @param name the name
     * @return response data model
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
     * @param id        the id
     * @param signature the signature
     * @return response data model
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
     * @param id       the id
     * @param sex      the sex
     * @param birthday the birthday
     * @param sign     the sign
     * @return response data model
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
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setSex(sex).setBirthday(birthday).setZodiac(sign)));
    }

    /**
     * 座标+状态+爱好
     *
     * @param id       the id
     * @param location the location
     * @param status   the status
     * @param favorite the favorite
     * @return response data model
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
     * @param id    the id
     * @param needs the needs
     * @return response data model
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
     * @param id       the id
     * @param postcode the postcode
     * @return response data model
     */
    @RequestMapping(value = "/modify/postcode/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyPostCode(@PathVariable Integer id, String postcode) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(postcode)) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setPostcode(postcode)));
    }

}
