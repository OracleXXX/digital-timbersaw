package com.digitaltimbersawapi.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class ContactUsDto {

    private Long id;

    private String name;

    private String organization;

    private String email;

    private String phone;

    private String content;

    private Date createdAt;

}
