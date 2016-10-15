package com.radish.biyu.webapi.services;

import com.radish.biyu.webapi.dao.TMailDao;
import com.radish.biyu.webapi.dao.TStampDao;
import com.radish.biyu.webapi.dto.StampDTO;
import com.radish.biyu.webapi.entity.TStamp;
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
 * @author cean
 * @version com.radish.biyu.webapi.services, v 0.1
 * @date 16 /9/25.
 */
@Service
public class MailService {
    private static Logger log = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private TMailDao tMailDao;

    @Autowired
    private TStampDao tStampDao;


    /**
     * Get mail from me list.
     *
     * @param phone the phone
     * @return the list
     */
    public List<HashMap<String, Object>> getMailFromMe(String phone) {
        return tMailDao.getMailFormMe(phone);
    }

    /**
     * Get mail to me list.
     *
     * @param phone  the phone
     * @param status the status
     * @return the list
     */
    public List<HashMap<String, Object>> getMailToMe(String phone,int status) {
        return tMailDao.getMailToMe(phone,status);
    }

    /**
     * Send mail now boolean.
     *
     * @param fromPhone the from phone
     * @param toPhone   the to phone
     * @param subject   the subject
     * @param content   the content
     * @return the boolean
     */
    public boolean sendMailNow(String fromPhone, String toPhone, String subject, String content) {
        Date allowReciveDateTime = new Date();
        return sendMailPlan(fromPhone, toPhone, subject, content, allowReciveDateTime);
    }

    /**
     * Send mail plan boolean.
     *
     * @param fromPhone           the from phone
     * @param toPhone             the to phone
     * @param subject             the subject
     * @param content             the content
     * @param allowReciveDateTime the allow recive date time
     * @return the boolean
     */
    public boolean sendMailPlan(String fromPhone, String toPhone, String subject, String content, Date allowReciveDateTime) {
        Date sendDateTime = new Date();
        int status = 1;

        return tMailDao.addMail(subject, content, fromPhone, toPhone, status, sendDateTime, allowReciveDateTime) > 0;
    }

    /**
     * Read mail hash map.
     *
     * @param id    the id
     * @param phone the phone
     * @return the hash map
     */
    public HashMap<String, Object> readMail(int id, String phone) {
        tMailDao.updateMailStatus(2, id, phone);
        HashMap<String, Object> data = tMailDao.getMailByID(id, phone);

        return data;
    }

    /**
     * 添加邮票记录
     *
     * @param mobile 接收方手机号
     * @param mailId 信件标识
     * @param pic    图片URL
     * @return boolean
     */
    public boolean addStamp(String mobile, Integer mailId, String pic) {
        boolean result = false;
        try {
            TStamp stamp = new TStamp();
            stamp.setMailId(mailId);
            stamp.setPic(pic);
            stamp.setMobile(mobile);
            stamp.setCreated(new Date());
            int r = tStampDao.addStamp(stamp);
            result = (r > 0);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return result;
    }

    /**
     * 翻页查邮票
     *
     * @param mobile   the mobile
     * @param pageno   the pageno
     * @param pagesize the pagesize
     * @return stamp dto
     */
    public StampDTO list(String mobile, Integer pageno, Integer pagesize) {
        StampDTO dto = new StampDTO();
        Integer cnt = this.tStampDao.cnt(mobile);
        if (null != cnt && cnt > 0) {
            List<HashMap<String, Object>> list = this.tStampDao.list(mobile, pageno * pagesize, pagesize);
            dto.setTotal(cnt);
            dto.setList(list);
        }
        return dto;
    }
}
