package com.thecodereveal.shopease.dto;


import com.thecodereveal.shopease.entities.Address;
import com.thecodereveal.shopease.entities.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetails {

    private UUID id;
    private Date orderDate;
    private Address address;
    private OrderStatus orderStatus;
    private Double totalAmount;
    private  String shipmentNumber;
    private Date expectedDeliveryDate;
    private List<OrderItemDetail> orderItemList;
}
