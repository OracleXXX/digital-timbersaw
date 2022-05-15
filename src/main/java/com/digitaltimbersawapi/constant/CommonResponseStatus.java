package com.digitaltimbersawapi.constant;

/**
 * @author meichaofan
 */
public enum CommonResponseStatus {

    /**
     * 状态码
     **/
    SUCCESS(10000, "ok"),
    FAIL(10001, "server error"),
    PARAMS_ERROR(20000, "params error"),
    CONTACT_US_SAVE_ERROR(702, "contact us save error"),
    CONTACT_US_DELETE_ERROR(704, "contact us delete error"),
    ;


    private int code;

    private String msg;

    CommonResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
