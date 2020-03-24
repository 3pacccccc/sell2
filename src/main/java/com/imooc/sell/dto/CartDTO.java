package com.imooc.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDTO {

    private String productId;

    private Integer productQuantity; // 商品数量

}
