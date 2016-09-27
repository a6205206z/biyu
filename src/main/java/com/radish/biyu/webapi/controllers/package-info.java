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


//======发布动态接口=====================================
参数说明

ftype:动态类型 1:公开信 2:分享 3:征友
lat:纬度
lng:经度
message：文本内容
pic：图片路径
uid：发布者会员ID

POST http://localhost:8089/feed/post
Content-Type: application/json

//发布动态接口，无图时上传
{"ftype":"1","lat":"30.67","lng":"104.06","message":"测试文本内容~121298","pic":[],"uid":100}

//发布动态接口，有图时上传
{"ftype":"1","lat":"30.67","lng":"104.06","message":"测试文本内容~121298","pic":["http://b.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=277c06a0cc1349546a13e0363727f93d/3812b31bb051f819ffbbbd6bddb44aed2e73e771.jpg","http://b.hiphotos.baidu.com/baike/crop%3D0%2C2%2C560%2C370%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=44216f7132f33a878a225a5afb6c3c0a/b3b7d0a20cf431ad5af7af784336acaf2edd984e.jpg","http://a.hiphotos.baidu.com/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=88b3ac0bdc2a283457ab3e593adca28f/adaf2edda3cc7cd965fa88cf3101213fb90e91d5.jpg"],"uid":100}

//=======翻页查询feed列表==================================
GET http://localhost:8089/feed/list/0/0/10

/feed/list/{ftype}/{pageno}/{pagesize}

==下面这些参数为非必传uid, lng, lat====后续使用添加======

ftype=0 为全部，其它值为对象类型

{"code":"2000000","msg":"操作成功","data":[{"birthday":"2016-09-27","lng":"104.06","created":1474901374000,"nickName":"b4","sex":"0","pic":[],"avatar":"http://baidu.com/logo.jpg","message":"测试文本内容~14444444444","forwarded":4,"liked":0,"uid":3,"ftype":"1","id":10,"lat":"30.67","commentnum":0},{"birthday":"2016-09-27","lng":"104.06","created":1474900795000,"nickName":"b1","sex":"0","pic":["http://b.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=277c06a0cc1349546a13e0363727f93d/3812b31bb051f819ffbbbd6bddb44aed2e73e771.jpg","http://b.hiphotos.baidu.com/baike/crop%3D0%2C2%2C560%2C370%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=44216f7132f33a878a225a5afb6c3c0a/b3b7d0a20cf431ad5af7af784336acaf2edd984e.jpg","http://a.hiphotos.baidu.com/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=88b3ac0bdc2a283457ab3e593adca28f/adaf2edda3cc7cd965fa88cf3101213fb90e91d5.jpg"],"avatar":"http://baidu.com/logo.jpg","message":"测试文wwwwwww本内容~1434345345","forwarded":0,"liked":3,"uid":1,"ftype":"1","id":7,"lat":"30.67","commentnum":0},{"birthday":"2016-09-27","lng":"104.06","created":1474900707000,"nickName":"b1","sex":"0","pic":["http://b.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=277c06a0cc1349546a13e0363727f93d/3812b31bb051f819ffbbbd6bddb44aed2e73e771.jpg","http://b.hiphotos.baidu.com/baike/crop%3D0%2C2%2C560%2C370%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=44216f7132f33a878a225a5afb6c3c0a/b3b7d0a20cf431ad5af7af784336acaf2edd984e.jpg","http://a.hiphotos.baidu.com/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=88b3ac0bdc2a283457ab3e593adca28f/adaf2edda3cc7cd965fa88cf3101213fb90e91d5.jpg"],"avatar":"http://baidu.com/logo.jpg","message":"测试文wwwwwww本内容~121298","forwarded":20,"liked":10,"uid":1,"ftype":"1","id":6,"lat":"30.67","commentnum":0},{"birthday":"2016-09-27","lng":"104.06","created":1474900457000,"nickName":"b1","sex":"0","pic":[],"avatar":"http://baidu.com/logo.jpg","message":"测试文本内容~121298","forwarded":1,"liked":0,"uid":1,"ftype":"1","id":2,"lat":"30.67","commentnum":2}]}


//======查看单条feed信息==================================
GET http://localhost:8089/feed/get/{fid}
{"code":"2000000","msg":"操作成功","data":{"id":2,"uid":1,"ftype":"1","lng":"104.06","lat":"30.67","message":"测试文本内容~121298","pic":[],"forwarded":1,"liked":0,"created":1474900457000}}

//=======发表评论=========================================
POST http://localhost:8089/comment/post
Content-Type: application/json
{"comments":"在那里啊？出来<script src='http://baidu.com/x.js'></script>high","fid":2222,"uid":2221}
{"comments":"在那里啊？出来high","fid":2,"uid":100}

//=======翻页查询评论列表==================================
GET http://localhost:8089/comment/list/{fid}/{pageno}/{pagesize}
{"code":"2000000","msg":"操作成功","data":[{"fid":2,"uid":1,"comments":"在那里啊？出来high","created":1474941842000,"nickName":"b1","id":2},{"fid":2,"uid":1,"comments":"xzzzzzzzzzzzzzzzzzzzzzzzzzzzzz","created":1474940993000,"nickName":"b1","id":1}]}


//=======喜欢+1==================================
POST http://localhost:8089/feed/liked/{fid}

//=======喜欢+1==================================
POST http://localhost:8089/feed/forward/{fid}

*/