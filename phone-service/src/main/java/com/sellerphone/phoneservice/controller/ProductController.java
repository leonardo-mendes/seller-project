package com.sellerphone.phoneservice.controller;

import com.sellerphone.phoneservice.controller.request.PhoneRequest;
import com.sellerphone.phoneservice.controller.response.PhoneResponse;
import com.sellerphone.phoneservice.service.PhoneContract;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/phones")
@ApiOperation(value = "Document API - This API provides all services for the application.")
public class ProductController {

    @Autowired
    private PhoneContract phoneContract;

    @GetMapping
    @ApiOperation(value = "This endpoint will retrieve all phones on storage.")
    public List<PhoneResponse> findAll() {
        return phoneContract.findAll();
    }

    @ApiOperation(value = "This endpoint will retrieve a phone on storage by brand.")
    @GetMapping(value = "/brand/{brand}")
    public List<PhoneResponse> findAllByBrand(@PathVariable("brand") String brand) {
        return phoneContract.findPhonesByBrand(brand);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "This endpoint will retrieve a phone on storage by id.")
    public PhoneResponse findById(@PathVariable("id") Long id) {
        return phoneContract.findPhoneById(id);
    }

    @GetMapping(value = "model/{model}")
    @ApiOperation(value = "This endpoint will retrieve a phone on storage by model.")
    public PhoneResponse findByModel(@PathVariable("model") String model) {
        return phoneContract.findPhoneByModel(model);
    }

    @PostMapping
    @ApiOperation(value = "This endpoint will save a new phone on storage.")
    public PhoneResponse save(@RequestBody PhoneRequest phoneRequest) {
        return phoneContract.save(phoneRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "This endpoint will delete a phone on storage.")
    public void delete(@PathVariable("id") Long id) {
        phoneContract.deletePhone(id);
    }


}
