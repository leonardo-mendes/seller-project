package com.sellerphone.storeservice.service;

import com.sellerphone.storeservice.controller.request.OrderRequest;
import com.sellerphone.storeservice.controller.response.OrderResponse;

import java.util.List;

public interface StoreContract {

    OrderResponse save(OrderRequest orderRequest);

    List<OrderResponse> findAll();

    OrderResponse findOrderById(Long id);

    void deleteOrder(Long id);
}
