package com.thecodereveal.shopease.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id",nullable = false)
    @JsonIgnore
    private Order order;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date paymentDate;


    @Column(nullable = false)
private Double amount;

    @Column(nullable = false)
    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private  paymentStatus  paymentStatus;

}
