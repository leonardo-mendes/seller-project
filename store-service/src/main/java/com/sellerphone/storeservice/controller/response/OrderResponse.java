package com.sellerphone.storeservice.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse implements Serializable {

    private String id;
    private String cellphoneModel;
    private Double cost;
    private Date orderDate;
}
