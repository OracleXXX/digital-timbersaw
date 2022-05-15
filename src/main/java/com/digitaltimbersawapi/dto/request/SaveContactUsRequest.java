package com.digitaltimbersawapi.dto.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class SaveContactUsRequest {

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "organization is required")
    private String organization;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "phone is required")
    private String phone;

    @NotBlank(message = "content is required")
    private String content;

}
