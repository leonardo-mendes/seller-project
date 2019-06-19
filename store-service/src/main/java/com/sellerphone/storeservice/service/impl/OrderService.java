package com.sellerphone.storeservice.service.impl;

import com.sellerphone.storeservice.client.PhoneServiceInterface;
import com.sellerphone.storeservice.client.response.PhoneResponse;
import com.sellerphone.storeservice.controller.request.OrderRequest;
import com.sellerphone.storeservice.controller.response.OrderResponse;
import com.sellerphone.storeservice.mapper.OrderMapper;
import com.sellerphone.storeservice.model.OrderEntity;
import com.sellerphone.storeservice.repository.StoreRepository;
import com.sellerphone.storeservice.service.StoreContract;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OrderService implements StoreContract {

    private PhoneServiceInterface phoneServiceInterface;

    private OrderMapper orderMapper;

    private StoreRepository storeRepository;

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        PhoneResponse phoneResponse = phoneServiceInterface.findByModel(orderRequest.getCellphoneModel());
        return orderMapper.orderEntityToOrderResponse(
                storeRepository.save(
                        OrderEntity.builder()
                                .cellphoneModel(orderRequest.getCellphoneModel())
                                .cost(orderRequest.getQuantity()*phoneResponse.getCost())
                                .orderDate(new Date())
                                .build()
                )
        );
    }

    @Override
    public List<OrderResponse> findAll() {
        return null;
    }

    @Override
    public OrderResponse findOrderById(Long id) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }

}
