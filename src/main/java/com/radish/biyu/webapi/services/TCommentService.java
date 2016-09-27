package com.radish.biyu.webapi.services;

import com.radish.biyu.webapi.dao.TCommentDao;
import com.radish.biyu.webapi.dto.RequestComment;
import com.radish.biyu.webapi.entity.TComment;
import com.radish.biyu.webapi.util.BeanDTOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.services.TCommentService, v 0.1
 * @date 2016/9/27.
 */
@Service
public class TCommentService {
    private static Logger log = LoggerFactory.getLogger(TCommentService.class);

    @Autowired
    private TCommentDao commentDao;

    /**
     * @param c
     * @return
     */
    public boolean addComment(RequestComment c) {
        try {
            TComment obj = new TComment();
            BeanDTOUtil.copyObject(c, obj);

            obj.setCreated(new Date());
            Long id = this.commentDao.insert(obj);
            if (null != id) {
                return true;
            }
        } catch (Exception e) {
            log.error("post comment:", e);
        }
        return false;
    }

    /**
     * @param fid
     * @param pageno
     * @param pagesize
     * @return
     */
    public List<HashMap<String, Object>> list(Long fid, Integer pageno, Integer pagesize) {
        return this.commentDao.list(fid, pageno * pagesize, pagesize);
    }
}
