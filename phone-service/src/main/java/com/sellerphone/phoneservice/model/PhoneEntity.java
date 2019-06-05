package com.sellerphone.phoneservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Builder
@Data
@Entity
@Table(name = "phone")
@AllArgsConstructor
@NoArgsConstructor
public class PhoneEntity implements Serializable {

    @Id
    @Column(name = "phone_id")
    private String id;
    private String name;
    private Double cost;
}
