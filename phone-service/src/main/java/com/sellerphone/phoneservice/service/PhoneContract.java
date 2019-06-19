package com.sellerphone.phoneservice.service;

import com.sellerphone.phoneservice.controller.request.PhoneRequest;
import com.sellerphone.phoneservice.controller.response.PhoneResponse;

import java.util.List;

public interface PhoneContract {

    PhoneResponse save(PhoneRequest phoneRequest);

    List<PhoneResponse> findAll();

    PhoneResponse findPhoneById(Long id);

    PhoneResponse findPhoneByModel(String model);

    List<PhoneResponse> findPhonesByBrand(String brand);

    void deletePhone(Long id);
}
