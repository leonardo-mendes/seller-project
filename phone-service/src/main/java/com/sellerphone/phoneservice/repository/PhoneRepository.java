package com.sellerphone.phoneservice.repository;

import com.sellerphone.phoneservice.model.PhoneEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends PagingAndSortingRepository<PhoneEntity, Long> {

}
