package com.digitaltimbersawapi.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ListContactUsRequest extends PageRequest {

    private String name = "";

}
