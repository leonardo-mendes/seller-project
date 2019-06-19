package com.sellerphone.storeservice.repository;

import com.sellerphone.storeservice.model.OrderEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends PagingAndSortingRepository<OrderEntity, Long> {

}
