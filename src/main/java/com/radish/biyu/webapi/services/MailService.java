package com.radish.biyu.webapi.services;

import com.radish.biyu.webapi.dao.TMailDao;
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
     * @param phone the phone
     * @return the list
     */
    public List<HashMap<String, Object>> getMailToMe(String phone) {
        return tMailDao.getMailToMe(phone);
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
}
