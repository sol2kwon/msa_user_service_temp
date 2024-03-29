package com.second_service.user.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseOrder {
    private String productID;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createAt;
    private String orderId;
}
