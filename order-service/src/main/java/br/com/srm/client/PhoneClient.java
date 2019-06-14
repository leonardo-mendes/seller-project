package br.com.srm.client;

import br.com.srm.client.dto.Phone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("phoneservice")
public interface PhoneClient {

    @GetMapping(value = "/phones/{phoneId}")
    Phone findById(@PathVariable("phoneId") Long departmentId);
}
