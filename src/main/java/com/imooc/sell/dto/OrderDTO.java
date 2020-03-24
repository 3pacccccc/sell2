package com.imooc.sell.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId; // 订单ID

    private String buyerName; // 买家名字

    private String buyerPhone; // 买家手机号

    private String buyerAddress; //买家地址

    private String buyerOpenid; // 买家微信openid

    private BigDecimal orderAmount; // 订单总金额

    private Integer orderStatus; //订单状态 默认为新下单

    private Integer payStatus; // 支付状态，默认为0未支付

//    @JsonSerialize(using = Date2LongSerializer.class) //todo 验证作用
    private Date createTime;  // 创建时间

//    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime; // 更新时间


    List<OrderDetail> orderDetailList;
}
