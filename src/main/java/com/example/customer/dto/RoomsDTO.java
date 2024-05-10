package com.example.customer.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class RoomsDTO {

    private Long roomId;


    private Long customerId;


    private BigDecimal rent;


    private String roomStatus;


    private String roomType;

}
