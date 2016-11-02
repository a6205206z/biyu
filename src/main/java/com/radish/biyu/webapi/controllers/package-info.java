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
POST http://localhost:8089/user/modify/avatar/1
{"pic":"aatest"}

//修改笔名
POST http://localhost:8089/user/modify/nick/1
{"name":"笔名"}

//修改个性签名
http://localhost:8089/user/modify/signature/1
{"signature":"个性签名~~~~"}

//0 女 1 男 2 其它
//生日格式= yyyy-MM-dd
//星座：中文，如，白羊座
http://localhost:8089/user/modify/info/1
{"sex":"1","birthday":"1999-09-23","sign":"白羊座"}

//座标 格式：四川省;成都市
//爱好 格式：游戏;电影;动漫
http://localhost:8089/user/modify/otherinfo/1
{"location":"四川成都","status":"自由职业","favorite":"动漫，运动"}

//修改需求 格式：安慰;鼓励;学习
http://localhost:8089/user/modify/needs/1
{"needs":"倾诉,安慰"}

//修改邮编
http://localhost:8089/user/modify/postcode/1
{"postcode":"123456"}

//======发布动态接口=====================================
参数说明

ftype:动态类型 0:全部 1:公开信 2:分享 3:征友
lat:纬度
lng:经度
message：文本内容
pic：图片路径
uid：发布者会员ID

POST http://localhost:8089/feed/post
Content-Type: application/json

//发布动态接口，无图时上传
{"ftype":"1","lat":"30.67","lng":"104.06","message":"测试文本内容~121298","imgs":"","uid":100}

//发布动态接口，有图时上传
{"ftype":"1","lat":"30.67","lng":"104.06","message":"测试文本内容~121298","imgs":"[{\"src\":\"imgs/cb3ed76b6fa45a51509d66c2573d7bc3.jpg\"},{\"src\":\"imgs/2cb6e703512fa6ec36ffd3a4a76a5732.jpg\"}]","uid":10}

//=======翻页查询feed列表==================================
GET http://localhost:8089/feed/list/0/0/10

/feed/list/{ftype}/{pageno}/{pagesize}

http://localhost:8089/feed/list/0/0/10?uid=6

uid 当前登录会员的ID

==下面这些参数为非必传uid, lng, lat====后续使用添加======

ftype=0 为全部，其它值为对象类型

{"code":"2000000","msg":"操作成功","data":[{"uid":1,"ftype":"1","lng":"1","islike":"1","created":1474951199000,"id":11,"pic":["1","2"],"message":"1","forwarded":0,"liked":0,"lat":"1","commentnum":1},{"uid":3,"ftype":"1","lng":"104.06","created":1474901374000,"id":10,"pic":[],"message":"测试文本内容~14444444444","forwarded":4,"liked":0,"lat":"30.67","commentnum":0},{"uid":3,"ftype":"2","lng":"104.06","created":1474901371000,"id":9,"pic":[],"message":"测试文本内容~123333333","forwarded":3,"liked":2,"lat":"30.67","commentnum":0},{"uid":2,"ftype":"2","lng":"104.06","created":1474901011000,"id":8,"pic":[],"message":"测试文本内容~1232222222222","forwarded":2,"liked":0,"lat":"30.67","commentnum":0},{"uid":1,"ftype":"1","lng":"104.06","created":1474900795000,"id":7,"pic":["http://b.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=277c06a0cc1349546a13e0363727f93d/3812b31bb051f819ffbbbd6bddb44aed2e73e771.jpg","http://b.hiphotos.baidu.com/baike/crop%3D0%2C2%2C560%2C370%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=44216f7132f33a878a225a5afb6c3c0a/b3b7d0a20cf431ad5af7af784336acaf2edd984e.jpg","http://a.hiphotos.baidu.com/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=88b3ac0bdc2a283457ab3e593adca28f/adaf2edda3cc7cd965fa88cf3101213fb90e91d5.jpg"],"message":"测试文wwwwwww本内容~1434345345","forwarded":0,"liked":3,"lat":"30.67","commentnum":0},{"uid":1,"ftype":"1","lng":"104.06","created":1474900707000,"id":6,"pic":["http://b.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=277c06a0cc1349546a13e0363727f93d/3812b31bb051f819ffbbbd6bddb44aed2e73e771.jpg","http://b.hiphotos.baidu.com/baike/crop%3D0%2C2%2C560%2C370%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=44216f7132f33a878a225a5afb6c3c0a/b3b7d0a20cf431ad5af7af784336acaf2edd984e.jpg","http://a.hiphotos.baidu.com/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=88b3ac0bdc2a283457ab3e593adca28f/adaf2edda3cc7cd965fa88cf3101213fb90e91d5.jpg"],"message":"测试文wwwwwww本内容~121298","forwarded":20,"liked":10,"lat":"30.67","commentnum":1},{"uid":1,"ftype":"1","lng":"104.06","islike":"1","created":1474900457000,"id":2,"pic":[],"message":"测试文本内容~121298","forwarded":2,"liked":7,"lat":"30.67","commentnum":2}]}

islike 为空或不等于1时，则当前用户没有喜欢这条动态

//======查看单条feed信息==================================
GET http://localhost:8089/feed/get/{fid}
{"code":"2000000","msg":"操作成功","data":{"id":28,"uid":10,"ftype":"1","lng":"104.06","lat":"30.67","message":"测试文本内容~121298","pic":"[{\"src\":\"imgs/cb3ed76b6fa45a51509d66c2573d7bc3.jpg\"},{\"src\":\"imgs/2cb6e703512fa6ec36ffd3a4a76a5732.jpg\"}]","forwarded":0,"liked":0,"commentnum":0,"avatar":"imgs/a046953445d4412ff6e63076d67b75b2.jpg","created":1477275105000}}

//=======发表评论=========================================
POST http://localhost:8089/comment/post
Content-Type: application/json
{"comments":"在那里啊？出来<script src='http://baidu.com/x.js'></script>high","fid":2222,"uid":2221}
{"comments":"在那里啊？出来high","fid":2,"uid":100}

//=======翻页查询评论列表==================================
GET http://localhost:8089/comment/list/{fid}/{pageno}/{pagesize}
{"code":"2000000","msg":"操作成功","data":[{"fid":2,"uid":1,"comments":"在那里啊？出来high","created":1474941842000,"nickName":"b1","id":2},{"fid":2,"uid":1,"comments":"xzzzzzzzzzzzzzzzzzzzzzzzzzzzzz","created":1474940993000,"nickName":"b1","id":1}]}


//=======喜欢+1==================================
POST http://localhost:8089/feed/liked/{fid}/{uid}
POST http://localhost:8089/feed/liked/2/6
{"code":"2000000","msg":"操作成功","data":true}

//=======喜欢+1==================================
POST http://localhost:8089/feed/forward/{fid}


//v2016.10.10新增=====

添加短信log方法
AccountService.addSmsLog(String mobile, String verifiCode)
添加邮票
MailService.addStamp(String mobile, Integer mailId, String pic)

问题2：注册第一步，提交时验证SMS验证码是否有效
http://localhost:8089/user/register/{phone}/{verifiCode}],methods=[POST]
POST http://localhost:8089/user/register/15729728701/1234
{"code":"2000000","msg":"操作成功","data":true}  //有效验证码
{"code":"2000000","msg":"操作成功","data":false} //无效验证码

问题3：注册会员
GET http://localhost:8089/user/add/15729728701/1234
{"code":"2000000","msg":"操作成功","data":18}  成功，返回ID
{"code":"2000000","msg":"操作成功","data":null} 失败，帐号存在

问题4：: ftype:动态类型包括｛0:全部 1:公开信 2:分享 3:征友｝

问题8：{[/user/get/info/{id}],methods=[GET]}
GET http://localhost:8089/user/get/info/6
{"code":"2000000","msg":"操作成功","data":{"id":6,"accountphone":"chengcheng","avatar":"123","postcode":"321","nickname":"ee","sex":"e","birthday":"2016-10-10","zodiac":"123","location":"123","favorite":"123","needs":"123","status":"123","signature":"123","point":123,"updated":1476110967000,"flag":false}}

id 会员ID
accountPhone 对应t_account的手机号
avatar NULL头像
postCode NULL邮编
nickName 昵称
sexvar 性别,0 女 1 男 2 其它
birthDay 出生年月
zodiac 星座
location 出生地
favorite 爱好
needs 需求
status 目前状态
signature 个性签名
point 积分
updated 更新时间

问题9：
{[/stamp/list/{mobile}/{pageno}/{pagesize}]}

GET http://localhost:8089/stamp/list/15729728701/0/2
{"code":"2000000","msg":"操作成功","data":{"total":3,"list":[{"id":1,"pic":"http://fanyi.baidu.com/static/translation/img/header/logo_cbfea26.png"},{"id":2,"pic":"http://fanyi.baidu.com/static/translation/img/header/22222222.png"}]}}

total ：总数
list : pic 图片URL


----10.29

//修改资料拆分接口
{[/user/modify/info/sex/{id}],methods=[POST]}
POST http://localhost:8089/user/modify/info/sex/10
{"sex":"1"}


{[/user/modify/info/birthday/{id}],methods=[POST]}
POST http://localhost:8089/user/modify/info/birthday/10
{"birthday":"2016-09-09"}


{[/user/modify/info/sign/{id}],methods=[POST]}
POST http://localhost:8089/user/modify/info/sign/10
{"sign":"天秤座"}


{[/user/modify/otherinfo/location/{id}],methods=[POST]}
POST http://localhost:8089/user/modify/otherinfo/location/10
{"location":"四川成都"}

{[/user/modify/otherinfo/status/{id}],methods=[POST]}
POST http://localhost:8089/user/modify/otherinfo/status/10
{"status":"职业经理人"}

{[/user/modify/otherinfo/favorite/{id}],methods=[POST]}
POST http://localhost:8089/user/modify/otherinfo/favorite/10
{"favorite":"动漫，运动"}


//我的动态接口，返回值同 动态列表
{[/feed/my/{uid}/{pageno}/{pagesize}]}
GET http://localhost:8089/feed/my/10/0/10


//我收到的评论翻页查询
{[/comment/my/{uid}/{pageno}/{pagesize}]}
GET http://localhost:8089/comment/my/1/0/10
{"code":"2000000","msg":"操作成功","data":[{"fid":2,"uid":8,"comments":"在那里啊？出来eweeeeeeeeeeeeeeeeqewrdcasdfasdfsadfgregregrhigh","created":1474941934000,"nickName":"超人","id":4,"avatar":"http://baidu.com/logo.jpg"}]}


//11.02
//发送短信接口
{[/user/register/sms/{phone}],methods=[GET]}
GET http://localhost:8089/user/register/sms/15729728701
{"code":"2000000","msg":"操作成功","data":true}

//验证短信
{[/user/register/{phone}/{verifiCode}],methods=[POST]}
POST http://localhost:8089/user/register/15729728701/257820
{"code":"2000000","msg":"操作成功","data":true}

//常见的问题有:
1：一个手机号一天只能接收3条（注意频率）
2：一个验证码只能验证一次，重复验证会失败
3：平台返回的错误我都隐藏了，统一返回false.只有为true才成功;

*/