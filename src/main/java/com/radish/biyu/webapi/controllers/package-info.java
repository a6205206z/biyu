/**
 * radish.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 *
 * @author jems
 * @version com.radish.biyu.webapi.controllers.package-info, v 0.1
 * @date 2016/9/25.
 */
package com.radish.biyu.webapi.controllers;
/*
新加字段：signature、updated


API参数错误返回
{"code":"2020001","msg":"参数错误！","data":""}

API请求成功
{"code":"2000000","msg":"操作成功","data":true}

API请求发生内部错误，请反馈问题，
{"code":"2000000","msg":"操作成功","data":fales}

//修改头像
http://localhost:8089/user/modify/avatar/1?pic=http%3A%2F%2Flocalhost%3A8089%2Fuser%2Fmodify%2Favatar%2F1
//修改笔名
http://localhost:8089/user/modify/nick/1?name=%E6%B5%8B%E8%AF%95%E7%AC%94%E5%90%8D
//修改个性签名
http://localhost:8089/user/modify/signature/1?signature=%E4%BB%8A%E5%A4%A9%E7%9A%84%E5%BF%83%E6%83%85

//0 女 1 男 2 其它
//生日格式= yyyy-MM-dd
//星座：中文，如，白羊座
http://localhost:8089/user/modify/info/1?sex=1&birthday=1999-09-23&sign=%E7%99%BD%E5%85%BB%E5%BA%A7

//座标 格式：四川省;成都市
//爱好 格式：游戏;电影;动漫
http://localhost:8089/user/modify/otherinfo/1?location=%E5%9B%9B%E5%B7%9D%E7%9C%81%3B%E6%88%90%E9%83%BD%E5%B8%82&status=%E5%AD%A6%E7%94%9F&favorite=%E6%B8%B8%E6%88%8F%3B%E7%94%B5%E5%BD%B1%3B%E5%8A%A8%E6%BC%AB

//修改需求 格式：安慰;鼓励;学习
http://localhost:8089/user/modify/needs/1?needs=%E5%AE%89%E6%85%B0%3B%E9%BC%93%E5%8A%B1%3B%E5%AD%A6%E4%B9%A0

//修改邮编
http://localhost:8089/user/modify/postcode/1?postcode=123456










*/