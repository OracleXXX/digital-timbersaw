package com.digitaltimbersawapi.dto.request;

import com.digitaltimbersawapi.constant.Setting;
import lombok.Data;

@Data
public class PageRequest {

    private Integer pageNumber = Setting.DEFAULT_PAGE_NUMBER;

    private Integer pageSize = Setting.DEFAULT_PAGE_SIZE;

    private Integer totalCount;

}
