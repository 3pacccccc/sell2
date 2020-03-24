package com.imooc.sell.dataobject;

import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class OrderMaster {

    @Id
    private String orderId; // 订单ID

    private String buyerName; // 买家名字

    private String buyerPhone; // 买家手机号

    private String buyerAddress; //买家地址

    private String buyerOpenid; // 买家微信openid

    private BigDecimal orderAmount; // 订单总金额

    private Integer orderStatus = OrderStatusEnum.NEW.getCode(); //订单状态 默认为新下单

    private Integer payStatus = PayStatusEnum.WAIT.getCode(); // 支付状态，默认为0未支付

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
