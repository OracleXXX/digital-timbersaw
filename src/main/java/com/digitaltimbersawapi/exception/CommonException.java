package com.digitaltimbersawapi.exception;


import com.digitaltimbersawapi.constant.CommonResponseStatus;

/**
 * @author meichaofan
 */
public class CommonException extends RuntimeException {

    private final int code;

    public CommonException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public CommonException(CommonResponseStatus status) {
        super(status.getMsg());
        this.code = status.getCode();
    }

    public int getCode() {
        return code;
    }

}
