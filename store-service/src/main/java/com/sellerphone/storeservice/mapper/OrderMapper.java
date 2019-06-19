package com.sellerphone.storeservice.mapper;

import com.sellerphone.storeservice.controller.request.OrderRequest;
import com.sellerphone.storeservice.controller.response.OrderResponse;
import com.sellerphone.storeservice.model.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "orderDate", dateFormat = "dd/MM/yyyy hh:mm:ss", target = "orderDate")
    OrderResponse orderEntityToOrderResponse(OrderEntity orderEntity);

    OrderEntity orderRequestToOrderEntity(OrderRequest orderRequest);

}
