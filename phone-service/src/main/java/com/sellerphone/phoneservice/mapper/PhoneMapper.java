package com.sellerphone.phoneservice.mapper;

import com.sellerphone.phoneservice.controller.request.PhoneRequest;
import com.sellerphone.phoneservice.controller.response.PhoneResponse;
import com.sellerphone.phoneservice.model.PhoneEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    PhoneResponse phoneEntityToPhoneResponse(PhoneEntity phoneEntity);

    PhoneEntity phoneRequestToPhoneEntity(PhoneRequest phoneRequest);

}
