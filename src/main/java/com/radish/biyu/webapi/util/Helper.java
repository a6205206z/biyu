package com.radish.biyu.webapi.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author cean
 * @version com.xmm.shoptools.stats, v 0.1
 * @date 16 /9/8.
 */
public class Helper {

    private static final Logger logger = LoggerFactory.getLogger(Helper.class);

    /**
     * Gets today as second.
     *
     * @return the today as second
     */
    public static String getTodayAsSecond() {
        return getTodayAsSecond(0);
    }

    /**
     * Gets today as second int.
     *
     * @param d the d
     * @return the today as second int
     */
    public static Integer getTodayAsSecondInt(int d) {
        return Integer.parseInt(getTodayAsSecond(d));
    }

    /**
     *
     * @return
     */
    public static String getTodayString() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    /**
     * Gets today as second.
     *
     * @param d the d
     * @return the today as second
     */
    public static String getTodayAsSecond(int d) {
        String result = "0";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.add(Calendar.DAY_OF_YEAR, d);
            Date date = df.parse(df.format(calendar.getTime()));
            calendar.setTime(date);
            result = Long.toString(calendar.getTimeInMillis() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int getInt(byte bytes[]) {
        return (bytes[0] & 0xff) << 24 | (bytes[1] & 0xff) << 16 | (bytes[2] & 0xff) << 8
                | bytes[1] & 0xff;
    }

    private static String hexFormat(int value, int dignum) {
        char chars[] = new char[dignum];
        for (int i = 1; i <= dignum; i++) {
            int curValue = value >> 4;
            int quotient = Math.abs(value - (curValue << 4));
            value = curValue;
            chars[i - 1] = Character.forDigit(quotient, 16);
        }

        return new String(chars);
    }

    /**
     * 获取36字符串
     *
     * @return guid
     */
    public static String getGuid() {
        StringBuffer tmpBuffer = new StringBuffer();
        SecureRandom seeder = new SecureRandom();
        try {
            InetAddress inet = InetAddress.getLocalHost();
            byte bytes[] = inet.getAddress();
            String hexInetAddress = hexFormat(getInt(bytes), 8);
            String thisHashCode = hexFormat(new Object().hashCode(), 8);
            tmpBuffer.append("-");
            tmpBuffer.append(hexInetAddress.substring(0, 4));
            tmpBuffer.append("-");
            tmpBuffer.append(hexInetAddress.substring(4));
            tmpBuffer.append("-");
            tmpBuffer.append(thisHashCode.substring(0, 4));
            tmpBuffer.append("-");
            tmpBuffer.append(thisHashCode.substring(4));
            String midValue = tmpBuffer.toString();
            long timeNow = System.currentTimeMillis();
            int timeLow = (int) timeNow & -1;
            int node = seeder.nextInt();
            return hexFormat(timeLow, 8) + midValue + hexFormat(node, 8);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 获取32UUID
     *
     * @return guid 32
     */
    public static String getGuid32() {
        StringBuffer tmpBuffer = new StringBuffer();
        SecureRandom seeder = new SecureRandom();
        try {
            InetAddress inet = InetAddress.getLocalHost();
            byte bytes[] = inet.getAddress();
            String hexInetAddress = hexFormat(getInt(bytes), 8);
            String thisHashCode = hexFormat(new Object().hashCode(), 8);
            tmpBuffer.append(hexInetAddress.substring(0, 4));
            tmpBuffer.append(hexInetAddress.substring(4));
            tmpBuffer.append(thisHashCode.substring(0, 4));
            tmpBuffer.append(thisHashCode.substring(4));
            String midValue = tmpBuffer.toString();
            long timeNow = System.currentTimeMillis();
            int timeLow = (int) timeNow & -1;
            int node = seeder.nextInt();
            return hexFormat(timeLow, 8) + midValue + hexFormat(node, 8);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * Encoder by md 5 string.
     *
     * @param str the str
     * @return the string
     * @throws NoSuchAlgorithmException     the no such algorithm exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}