package com.sellerphone.phoneservice.controller;

import com.sellerphone.phoneservice.model.PhoneEntity;
import com.sellerphone.phoneservice.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/phones")
public class ProductController {

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping
    public Iterable<PhoneEntity> find() {
        return phoneRepository.findAll();
    }

}
