package com.sellerphone.storeservice.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneResponse implements Serializable {

    private String id;
    private String model;
    private String brand;
    private Double cost;
}
