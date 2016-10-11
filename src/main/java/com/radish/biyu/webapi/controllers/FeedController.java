package com.radish.biyu.webapi.controllers;

import com.alibaba.fastjson.JSON;
import com.radish.biyu.webapi.dto.RequestFeed;
import com.radish.biyu.webapi.entity.TFeed;
import com.radish.biyu.webapi.response.ApiStatusCode;
import com.radish.biyu.webapi.response.ResponseDataModel;
import com.radish.biyu.webapi.services.FeedService;
import com.radish.biyu.webapi.util.BeanDTOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.controllers.FeedController, v 0.1
 * @date 2016/9/26.`
 */
@RestController
@RequestMapping("/feed")
public class FeedController extends BaseController {
    private Logger log = LoggerFactory.getLogger(FeedController.class);

    @Autowired
    private FeedService feedService;

    @RequestMapping(value = "/get/{id}")
    public ResponseDataModel get(@PathVariable Long id) {
        if (null == id) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(feedService.get(id));
    }

    /**
     * 发布动态
     *
     * @param feed
     * @return
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseDataModel post(@RequestBody RequestFeed feed) {
        //参数较验
        if (null == feed) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }

        if (null == feed.getUid() || StringUtils.isEmpty(feed.getFtype()) || StringUtils.isEmpty(feed.getMessage())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }

        return this.success(feedService.addFeed(feed));
    }

    /**
     * 翻页查询动态列表
     *
     * @param ftype
     * @param pageno
     * @param pagesize
     * @param uid
     * @param lng
     * @param lat
     * @return
     */
    @RequestMapping(value = "/list/{ftype}/{pageno}/{pagesize}")
    public ResponseDataModel list(@PathVariable String ftype, @PathVariable Integer pageno, @PathVariable Integer pagesize,
                                  @RequestParam(required = false) Long uid,
                                  @RequestParam(required = false) String lng,
                                  @RequestParam(required = false) String lat) {
        if (pageno == null) {
            pageno = 0;
        }
        if (pagesize == null) {
            pagesize = 20;
        }
        if (null == ftype) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(this.feedService.list(uid, ftype, pageno, pagesize));
    }

    /**
     * 转发分享+1
     *
     * @param fid
     * @return
     */
    @RequestMapping(value = "/forward/{fid}", method = RequestMethod.POST)
    public ResponseDataModel addShare(@PathVariable Long fid) {
        if (null == fid) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(feedService.addForward(fid));
    }

    /**
     * 喜欢+1
     *
     * @param fid
     * @return
     */
    @RequestMapping(value = "/liked/{fid}/{uid}", method = RequestMethod.POST)
    public ResponseDataModel addLike(@PathVariable Long fid,@PathVariable Long uid) {
        if (null == fid || null == uid) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        return this.success(feedService.addLike(fid,uid));
    }

}
