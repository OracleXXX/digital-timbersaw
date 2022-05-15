package com.digitaltimbersawapi.service;

import com.digitaltimbersawapi.dto.request.ListContactUsRequest;
import com.digitaltimbersawapi.dto.request.SaveContactUsRequest;
import com.digitaltimbersawapi.dto.response.ListContactUsResponse;
import com.digitaltimbersawapi.dto.response.SuccessResponse;

public interface ContactUsService {

    ListContactUsResponse ListContactUs(ListContactUsRequest listContactUsRequest);

    SuccessResponse saveContactUs(SaveContactUsRequest saveContactUsRequest);

    SuccessResponse deleteContactUs(Long id);

}
