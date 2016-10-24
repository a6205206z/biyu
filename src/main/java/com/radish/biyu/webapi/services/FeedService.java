package com.radish.biyu.webapi.services;

import com.radish.biyu.webapi.dao.TCommentDao;
import com.radish.biyu.webapi.dao.TFeedDao;
import com.radish.biyu.webapi.dao.TLikedDao;
import com.radish.biyu.webapi.dto.RequestFeed;
import com.radish.biyu.webapi.dto.TFeedDTO;
import com.radish.biyu.webapi.entity.TFeed;
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
 * @version com.radish.biyu.webapi.services.FeedService, v 0.1
 * @date 2016/9/26.
 */
@Service
public class FeedService {
    private static Logger log = LoggerFactory.getLogger(FeedService.class);

    @Autowired
    private TFeedDao tFeedDao;

    @Autowired
    private TLikedDao tLikedDao;
    @Autowired
    private TCommentDao tCommentDao;

    /**
     * 发布动态
     *
     * @param feed
     * @return
     */
    public boolean addFeed(RequestFeed feed) {
        try {
            TFeed obj = new TFeed();
            BeanDTOUtil.copyObject(feed, obj);

            if (null != feed.getImgs()) {
                obj.setPic(feed.getImgs());
//                obj.setPic(JSON.toJSONString(feed.getPic()));
            }
            obj.setCreated(new Date());
            Long id = this.tFeedDao.insert(obj);
            if (null != id) {
                return true;
            }
        } catch (Exception e) {
            log.error("post feed:", e);
        }
        return false;
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public TFeedDTO get(Long id) {
        TFeedDTO dto = new TFeedDTO();
        try {
            TFeed obj = this.tFeedDao.getBaseInfo(id);
            if (null != obj) {
                BeanDTOUtil.copyObject(obj, dto);
//                if (!StringUtils.isEmpty(obj.getPic())) {
//                    dto.setPic(JSON.parseObject(obj.getPic(), String[].class));
//                }
                return dto;
            }
        } catch (Exception e) {
            log.error("get feed:", e);
        }
        return null;
    }

    /**
     * @param ftype
     * @param pageno
     * @param pagesize
     * @return
     */
    public List<HashMap<String, Object>> list(Long uid, String ftype, Integer pageno, Integer pagesize) {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("uid", uid);
        param.put("ftype", ftype);
        param.put("pageno", pageno);
        param.put("pagesize", pagesize);
        List<HashMap<String, Object>> list = this.tFeedDao.list(param);

//        if (null != list && !list.isEmpty()) {
//            for (HashMap<String, Object> map : list) {
//                //json转数组
//                if (!StringUtils.isEmpty(map.get("pic"))) {
//                    map.put("pic", JSON.parseObject((String) map.get("pic"), String[].class));
//                }
                //经纬度处理，等
//            }
//        }
        return list;
    }

    /**
     * 分享+1
     *
     * @param id
     * @return
     */
    public boolean addForward(Long id) {
        HashMap param = new HashMap<>();
        param.put("id", id);
        return this.tFeedDao.clickFav(param);
    }

    /**
     * 点赞+1
     *
     * @param id
     * @return
     */
    public boolean addLike(Long id, Long uid) {
        HashMap param = new HashMap<>();
        param.put("id", id);
        param.put("liked", "1");
        if (this.tFeedDao.clickFav(param)) {
            //TODO:添加喜欢记录
            try {
                tLikedDao.addLikeLog(id, uid, new Date());
            } finally {
            }
            return true;
        } else {
            return false;
        }
    }
}

