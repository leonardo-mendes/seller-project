package com.sellerphone.phoneservice.repository;

import com.sellerphone.phoneservice.model.PhoneEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends PagingAndSortingRepository<PhoneEntity, Long> {

    List<PhoneEntity> findByBrand(String brand);

}
