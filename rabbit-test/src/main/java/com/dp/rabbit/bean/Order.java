package com.dp.rabbit.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order implements Serializable {

    private String OrderSn;//订单号

    private Long SkuId;//购买的商品id

    private Integer num;//购买的个数

    private Integer memberId;//购买者的id

}
