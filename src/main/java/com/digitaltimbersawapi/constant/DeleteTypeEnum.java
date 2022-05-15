package com.digitaltimbersawapi.constant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DeleteTypeEnum {

    NOT_DELETE(0, "not deleted"),
    IS_DELETE(1, "is deleted"),;

    private final Integer code;
    private final String name;

    DeleteTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
