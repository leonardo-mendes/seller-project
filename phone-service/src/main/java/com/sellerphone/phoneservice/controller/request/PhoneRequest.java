package com.sellerphone.phoneservice.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneRequest implements Serializable {

    private String id;
    private String model;
    private String brand;
    private Double cost;
}
