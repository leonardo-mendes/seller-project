package com.sellerphone.storeservice.controller.request;

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
public class OrderRequest implements Serializable {

    private String cellphoneModel;
    private Integer quantity;
    private Date orderDate;

}
