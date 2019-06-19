package com.sellerphone.storeservice.client;

import com.sellerphone.storeservice.client.response.PhoneResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("phoneservice")
public interface PhoneServiceInterface {

    @GetMapping(value = "/phones/model/{model}")
    PhoneResponse findByModel(@PathVariable("model") String model);

}
