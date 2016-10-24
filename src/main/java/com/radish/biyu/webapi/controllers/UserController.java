package com.radish.biyu.webapi.controllers;

import com.radish.biyu.webapi.dto.RequestUserInfo;
import com.radish.biyu.webapi.entity.TUserInfo;
import com.radish.biyu.webapi.response.ApiStatusCode;
import com.radish.biyu.webapi.response.ResponseDataModel;
import com.radish.biyu.webapi.services.AccountService;
import com.radish.biyu.webapi.services.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    public ResponseDataModel login(@PathVariable String phone, @PathVariable String password) {
        return success(accountService.login(phone, password));
    }

    /**
     * 获取验证码
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/register/sms/{phone}", method = RequestMethod.GET)
    public ResponseDataModel getVerifiCode(@PathVariable String phone) {
        return success(accountService.getVerifiCode(phone));
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
        return success(accountService.checkVerifiCode2(phone, verifiCode));
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
     * @param id   the id
     * @param info the info
     * @return response data model
     */
    @RequestMapping(value = "/modify/avatar/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyAvatar(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info || StringUtils.isEmpty(info.getPic())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setAvatar(info.getPic())));
    }

    /**
     * 修改笔名
     *
     * @param id   the id
     * @param info the name
     * @return response data model
     */
    @RequestMapping(value = "/modify/nick/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyNickName(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info || StringUtils.isEmpty(info.getName())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setNickname(info.getName())));
    }

    /**
     * 修改个性签名
     *
     * @param id   the id
     * @param info the signature
     * @return response data model
     */
    @RequestMapping(value = "/modify/signature/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifySignature(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info || StringUtils.isEmpty(info.getSignature())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setSignature(info.getSignature())));
    }


    /**
     * 性别+生日+星座
     *
     * @param id   the id
     * @param info the info
     * @return response data model
     */
    @RequestMapping(value = "/modify/info/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyInfo(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info ||
                StringUtils.isEmpty(info.getSex()) || StringUtils.isEmpty(info.getBirthday()) || StringUtils.isEmpty(info.getSign())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        Date b = null;
        try {
            b = new SimpleDateFormat("yyyy-MM-dd").parse(info.getBirthday());
        } catch (ParseException e) {
            log.error("", e);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setSex(info.getSex()).setBirthday(info.getBirthday()).setZodiac(info.getSign())));
    }

    @RequestMapping(value = "/modify/info/sex{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyInfoSex(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info ||
                StringUtils.isEmpty(info.getSex())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setSex(info.getSex())));
    }

    @RequestMapping(value = "/modify/info/birthday/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyInfoBirthday(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info ||
                StringUtils.isEmpty(info.getBirthday())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        Date b = null;
        try {
            b = new SimpleDateFormat("yyyy-MM-dd").parse(info.getBirthday());
        } catch (ParseException e) {
            log.error("", e);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setBirthday(info.getBirthday())));
    }

    @RequestMapping(value = "/modify/info/sign/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyInfoSign(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info || StringUtils.isEmpty(info.getSign())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setZodiac(info.getSign())));
    }

    /**
     * 座标+状态+爱好
     *
     * @param id   the id
     * @param info the info
     * @return response data model
     */
    @RequestMapping(value = "/modify/otherinfo/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyOtherInfo(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info ||
                StringUtils.isEmpty(info.getLocation()) || StringUtils.isEmpty(info.getStatus()) || StringUtils.isEmpty(info.getFavorite())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setLocation(info.getLocation()).setStatus(info.getStatus()).setFavorite(info.getFavorite())));
    }

    @RequestMapping(value = "/modify/otherinfo/location/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyOtherInfoLocation(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info || StringUtils.isEmpty(info.getLocation())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setLocation(info.getLocation())));
    }

    @RequestMapping(value = "/modify/otherinfo/status/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyOtherInfoStatus(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info || StringUtils.isEmpty(info.getStatus())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setStatus(info.getStatus())));
    }

    @RequestMapping(value = "/modify/otherinfo/favorite/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyOtherInfoFavorite(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info || StringUtils.isEmpty(info.getFavorite())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setFavorite(info.getFavorite())));
    }

    /**
     * 修改需求
     *
     * @param id   the id
     * @param info the needs
     * @return response data model
     */
    @RequestMapping(value = "/modify/needs/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyNeeds(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info || StringUtils.isEmpty(info.getNeeds())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setNeeds(info.getNeeds())));
    }

    /**
     * 修改邮编
     *
     * @param id   the id
     * @param info the postcode
     * @return response data model
     */
    @RequestMapping(value = "/modify/postcode/{id}", method = RequestMethod.POST)
    public ResponseDataModel modifyPostCode(@PathVariable Integer id, @RequestBody RequestUserInfo info) {
        if (StringUtils.isEmpty(id) || null == info || StringUtils.isEmpty(info.getPostcode())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(userInfoService.modifyInfo(new TUserInfo().setId(id).setPostcode(info.getPostcode())));
    }


    /**
     * Find user by phone response data model.
     *
     * @param phone the phone
     * @return the response data model
     */
    @RequestMapping(value = "/find/{phone}", method = RequestMethod.POST)
    public ResponseDataModel findUserByPhone(@PathVariable String phone) {
        return this.success(userInfoService.selectUserInfoByPhone(phone));
    }
}
