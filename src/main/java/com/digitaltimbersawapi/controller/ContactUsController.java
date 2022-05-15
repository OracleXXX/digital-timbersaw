package com.digitaltimbersawapi.controller;

import com.digitaltimbersawapi.dto.request.ListContactUsRequest;
import com.digitaltimbersawapi.dto.request.SaveContactUsRequest;
import com.digitaltimbersawapi.dto.response.CommonResponse;
import com.digitaltimbersawapi.dto.response.ListContactUsResponse;
import com.digitaltimbersawapi.dto.response.SuccessResponse;
import com.digitaltimbersawapi.service.ContactUsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping
public class ContactUsController {

    @Resource
    private ContactUsService contactUsService;

    @GetMapping("/admin/contactUs")
    public CommonResponse<ListContactUsResponse> listContactUs(ListContactUsRequest listContactUsRequest) {
        return CommonResponse.getSuccessResult(contactUsService.ListContactUs(listContactUsRequest));
    }

    @PostMapping("/contactUs")
    public CommonResponse<SuccessResponse> saveContactUs(@Valid @RequestBody SaveContactUsRequest saveContactUsRequest) {
        return CommonResponse.getSuccessResult(contactUsService.saveContactUs(saveContactUsRequest));
    }

    @DeleteMapping("/admin/contactUs/{id}")
    public CommonResponse<SuccessResponse> deleteContactUs(@PathVariable("id") Long id) {
        return CommonResponse.getSuccessResult(contactUsService.deleteContactUs(id));
    }


}
