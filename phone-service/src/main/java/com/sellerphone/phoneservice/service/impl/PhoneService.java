package com.sellerphone.phoneservice.service.impl;

import com.sellerphone.phoneservice.controller.request.PhoneRequest;
import com.sellerphone.phoneservice.controller.response.PhoneResponse;
import com.sellerphone.phoneservice.mapper.PhoneMapper;
import com.sellerphone.phoneservice.model.PhoneEntity;
import com.sellerphone.phoneservice.repository.PhoneRepository;
import com.sellerphone.phoneservice.service.PhoneContract;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PhoneService implements PhoneContract {

    PhoneRepository phoneRepository;

    PhoneMapper phoneMapper;

    @Override
    public PhoneResponse save(PhoneRequest phoneRequest) {
        return phoneMapper.phoneEntityToPhoneResponse(
                phoneRepository.save(
                        phoneMapper.phoneRequestToPhoneEntity(phoneRequest)
                )
        );
    }

    @Override
    public List<PhoneResponse> findAll() {
        return ((List<PhoneEntity>) phoneRepository.findAll()).stream()
                .map(phoneEntity -> phoneMapper.phoneEntityToPhoneResponse(phoneEntity)).collect(Collectors.toList());
    }

    @Override
    public PhoneResponse findPhoneById(Long id) {
        return phoneMapper.phoneEntityToPhoneResponse(phoneRepository.findById(id).get());
    }

    @Override
    public PhoneResponse findPhoneByModel(String model) {
        return phoneMapper.phoneEntityToPhoneResponse(phoneRepository.findByModel(model));
    }

    @Override
    public List<PhoneResponse> findPhonesByBrand(String brand) {
        return phoneRepository.findByBrand(brand).stream()
                .map(phoneEntity -> phoneMapper.phoneEntityToPhoneResponse(phoneEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePhone(Long id) {
        phoneRepository.delete(phoneRepository.findById(id).get());
    }
}
