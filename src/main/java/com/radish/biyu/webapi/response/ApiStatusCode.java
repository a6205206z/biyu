package com.radish.biyu.webapi.response;

/**
 * @author tiaotiaohu
 * @corporation radish.com Inc.
 * @date 2016年7月6日 下午6:32:23
 * @description API接口返回状态码
 */
public enum ApiStatusCode {
    /**
     * 说明
     * 总共长度为 七位
     * 第一位（代表错误级别（1：系统错误，2：普通异常））
     * 第二位，第三位（星密码服务代码  如 ：01代表公共服务  02 代表 笔遇APP）
     * 第四位，第五位（服务内模块代码）
     * 第六位，第七位（具体状态信息）
     */
    SERVER_ERROR("2010000", "服务器内部错误"),
    INTERFACE_CALLS_OUT_LIMIT("2010001", "接口调用次数超上限"),
    DB_EXCEPTION("2010002", "数据库异常"),
    CACHE_EXCEPTION("2010003", "缓存读写异常"),
    CACHE_ERROR("2010004", "缓存类错误"),
    NULL_CACHE_DATA_ERROR("2010005", "没有缓存数据错误"),
    SERVER_HARDWARE_ERROR("2010006", "服务器硬件故障"),
    DB_UPDATE_ERROR("2010007", "数据库更新失败"),
    DB_INSERT_ERROR("2010008", "数据库插入失败"),
    DB_QUERY_ERROR("2010009", "数据库查询失败"),
    DB_DELETE_ERROR("2010010", "数据库删除失败"),

    FAILD("2010011", "操作失败"),
    SEARCH_LIMIE_CNT("2010012", "匹配次数用完"),

    PARAM_ERROR("2020001", "参数错误！"),

    /**
     * 成功状态码
     */
    SUCCESS("2000000", "操作成功");


    private final String code;
    private final String msg;

    ApiStatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}