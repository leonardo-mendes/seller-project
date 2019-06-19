package com.sellerphone.storeservice.controller;

import com.sellerphone.storeservice.controller.request.OrderRequest;
import com.sellerphone.storeservice.controller.response.OrderResponse;
import com.sellerphone.storeservice.service.StoreContract;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stores")
@ApiOperation(value = "Document API - This API provides all services for the application.")
public class StoreController {

    @Autowired
    private StoreContract storeContract;

    @GetMapping
    @ApiOperation(value = "This endpoint will retrieve all orders on storage.")
    public List<OrderResponse> findAll() {
        return storeContract.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "This endpoint will retrieve a order on storage by id.")
    public OrderResponse findById(@PathVariable("id") Long id) {
        return storeContract.findOrderById(id);
    }

    @PostMapping
    @ApiOperation(value = "This endpoint will save a new order on storage.")
    public OrderResponse save(@RequestBody OrderRequest orderRequest) {
        return storeContract.save(orderRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "This endpoint will delete a order on storage.")
    public void delete(@PathVariable("id") Long id) {
        storeContract.deleteOrder(id);
    }


}
