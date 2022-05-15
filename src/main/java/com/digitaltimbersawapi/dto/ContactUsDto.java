package com.digitaltimbersawapi.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ContactUsDto {

    private String name;

    private String organization;

    private String email;

    private String phone;

    private String content;

}
