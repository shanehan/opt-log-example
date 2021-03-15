package com.hanjie.opt.example.service;


/**
 * code 定义
 * 模块_错误编号
 *
 * @author han
 * @date 2019/8/29
 */
public class Response<D> {

    public static final String STATUS_SUCCESS = "0";
    public static final String STATUS_LOGIN = "10001";
    public static final String STATUS_NO_PERMISSION = "10002";
    public static final String STATUS_NOT_FOUND = "10404";
    public static final String STATUS_ERROR = "10500";
    public static final String STATUS_COMMON_BIZ = "10600";

    public static final String JOIN_CHAR = "_";

    public static <D> Response<D> success() {
        return new Response<>(STATUS_SUCCESS, null, null);
    }

    public static <D> Response<D> success(D data) {
        return new Response<>(STATUS_SUCCESS, null, data);
    }

    public static <D> Response<D> error(String msg, D data) {
        return new Response<>(STATUS_ERROR, msg, data);
    }

    public static <D> Response<D> commonBizError(String msg) {
        return new Response<>(STATUS_COMMON_BIZ, msg, null);
    }


    public static <D> Response<D> commonBizError(String msg, D data) {
        return new Response<>(STATUS_COMMON_BIZ, msg, data);
    }

    public static <D> Response<D> bizError(String code, String msg) {
        return new Response<>(code, msg, null);
    }


    public static <D> Response<D> bizError(String code, String msg, D data) {
        return new Response<>(code, msg, data);
    }

    public static boolean isSuccessStatus(String code) {
        return STATUS_SUCCESS.equals(code);
    }

    public static boolean isLoginStatus(String code) {
        return STATUS_LOGIN.equals(code);
    }

    public static boolean isErrorStatus(String code) {
        return STATUS_ERROR.equals(code);
    }

    public static boolean isNotFoundStatus(String code) {
        return STATUS_NOT_FOUND.equals(code);
    }

    public static boolean isCommonBizStatus(String code) {
        return STATUS_COMMON_BIZ.equals(code);
    }

    public static boolean isBizErrorStatus(String code) {
        if (code != null) {
            return isCommonBizStatus(code) || code.contains(JOIN_CHAR);
        }
        return false;
    }

    private String code;
    private String msg;
    private D data;

    public Response() {
    }

    public Response(String code, String msg, D data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }


    public boolean isSuccess() {
        return STATUS_SUCCESS.equals(code);
    }
}
