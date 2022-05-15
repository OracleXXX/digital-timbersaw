package com.digitaltimbersawapi.service.impl;

import com.digitaltimbersawapi.constant.CommonResponseStatus;
import com.digitaltimbersawapi.constant.DeleteTypeEnum;
import com.digitaltimbersawapi.domain.ContactUsEntity;
import com.digitaltimbersawapi.dto.ContactUsDto;
import com.digitaltimbersawapi.dto.request.ListContactUsRequest;
import com.digitaltimbersawapi.dto.request.SaveContactUsRequest;
import com.digitaltimbersawapi.dto.response.ListContactUsResponse;
import com.digitaltimbersawapi.dto.response.SuccessResponse;
import com.digitaltimbersawapi.exception.CommonException;
import com.digitaltimbersawapi.repository.ContactUsRepository;
import com.digitaltimbersawapi.service.ContactUsService;
import org.dom4j.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Resource
    private ContactUsRepository contactUsRepository;

    @Override
    public ListContactUsResponse ListContactUs(ListContactUsRequest listContactUsRequest) {
        ListContactUsResponse listContactUsResponse = new ListContactUsResponse();
        PageRequest pageRequest = PageRequest.of(listContactUsRequest.getPageNumber() - 1, listContactUsRequest.getPageSize(), Sort.by("created_at").descending());
        // init name
        String name =  "%" + listContactUsRequest.getName() + "%";
        // list contact us by page
        Page<ContactUsEntity> contactUsEntities = contactUsRepository.findByNameLikeAndIsDel(pageRequest, name, DeleteTypeEnum.NOT_DELETE.getCode());
        // set contact us dto
        listContactUsResponse.setContactUses(contactUsEntities.stream().map(x -> {
            ContactUsDto contactUsDto = new ContactUsDto();
            BeanUtils.copyProperties(x, contactUsDto);
            return contactUsDto;
        }).collect(Collectors.toList()));
        // page
        listContactUsResponse.setPageNumber(listContactUsRequest.getPageNumber());
        listContactUsResponse.setPageSize(listContactUsRequest.getPageSize());
        listContactUsResponse.setTotalCount(contactUsEntities.getTotalElements());
        return listContactUsResponse;
    }

    @Override
    public SuccessResponse saveContactUs(SaveContactUsRequest saveContactUsRequest) {
        SuccessResponse successResponse = new SuccessResponse();
        ContactUsEntity contactUsEntity = ContactUsEntity.builder()
                .name(saveContactUsRequest.getName())
                .email(saveContactUsRequest.getEmail())
                .organization(saveContactUsRequest.getOrganization())
                .content(saveContactUsRequest.getContent())
                .phone(saveContactUsRequest.getPhone())
                .build();
        try {
            contactUsRepository.save(contactUsEntity);
        } catch (Exception e) {
            throw new CommonException(CommonResponseStatus.CONTACT_US_SAVE_ERROR);
        }
        successResponse.setSuccess(true);
        return successResponse;
    }

    @Override
    public SuccessResponse deleteContactUs(Long id) {
        SuccessResponse successResponse = new SuccessResponse();
        try {
            contactUsRepository.logicDeleteById(id);
        } catch (Exception e) {
            throw new CommonException(CommonResponseStatus.CONTACT_US_DELETE_ERROR);
        }
        successResponse.setSuccess(true);
        return successResponse;
    }
}
