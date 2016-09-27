package com.radish.biyu.webapi.controllers;

import com.radish.biyu.webapi.dto.RequestComment;
import com.radish.biyu.webapi.dto.RequestFeed;
import com.radish.biyu.webapi.response.ApiStatusCode;
import com.radish.biyu.webapi.response.ResponseDataModel;
import com.radish.biyu.webapi.services.FeedService;
import com.radish.biyu.webapi.services.TCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.controllers.CommentController, v 0.1
 * @date 2016/9/26.`
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {
    private Logger log = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private TCommentService commentService;

    /**
     * 发布评论
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseDataModel post(@RequestBody RequestComment comment) {
        //参数较验
        if (null == comment) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }

        if (null == comment.getUid() || StringUtils.isEmpty(comment.getComments()) || StringUtils.isEmpty(comment.getFid())) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }

        return this.success(commentService.addComment(comment));
    }

    /**
     * 翻页查询评论列表
     *
     * @param fid
     * @param pageno
     * @param pagesize
     * @return
     */
    @RequestMapping(value = "/list/{fid}/{pageno}/{pagesize}")
    public ResponseDataModel list(@PathVariable Long fid, @PathVariable Integer pageno, @PathVariable Integer pagesize) {
        if (null == fid) {
            return this.error(ApiStatusCode.PARAM_ERROR);
        }
        if (pageno == null) {
            pageno = 0;
        }
        if (pagesize == null) {
            pagesize = 20;
        }
        return this.success(this.commentService.list(fid, pageno, pagesize));
    }


}
