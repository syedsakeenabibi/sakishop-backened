package com.thecodereveal.shopease.auth.dto;

import com.thecodereveal.shopease.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class UserDetailsDto {

    private UUID id;
private String firstName;
private String lastName;
private String email;
private String phoneNumber;
private Object authorityList;
private List<Address> addressList;

}
