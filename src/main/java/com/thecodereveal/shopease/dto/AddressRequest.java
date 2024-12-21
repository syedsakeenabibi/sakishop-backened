package com.thecodereveal.shopease.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {
private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
}
