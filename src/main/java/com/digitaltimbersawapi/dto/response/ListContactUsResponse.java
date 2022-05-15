package com.digitaltimbersawapi.dto.response;

import com.digitaltimbersawapi.dto.ContactUsDto;
import lombok.Data;

import java.util.List;

@Data
public class ListContactUsResponse {

    private List<ContactUsDto> contactUses;

    private Integer pageNumber;

    private Integer pageSize;

    private Long totalCount;

}
