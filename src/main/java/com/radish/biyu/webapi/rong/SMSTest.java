package com.radish.biyu.webapi.rong;

/**
 * Created by hemingxie on 2016/10/24.
 */
public class SMSTest {
    public static void main(String[] args) {
        System.out.println("************************SMS********************");

        SMS sms = SMS.getInstance();
        try {
            // 获取图片验证码方法
//            SMSImageCodeReslut sMSGetImageCodeResult = sms.getImageCode("app-key");
//            System.out.println("getImageCode:  " + sMSGetImageCodeResult.toString());

            // 发送短信验证码方法。
            SMSSendCodeReslut sMSSendCodeResult = sms.sendCode("13500000000", "dsfdsfd", "86", "", "");
            System.out.println("sendCode:  " + sMSSendCodeResult.toString());

            // 验证码验证方法
            CodeSuccessReslut sMSVerifyCodeResult = sms.verifyCode("2312312", "2312312");
            System.out.println("verifyCode:  " + sMSVerifyCodeResult.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
