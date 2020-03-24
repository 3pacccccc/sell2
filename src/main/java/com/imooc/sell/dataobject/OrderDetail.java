package com.imooc.sell.dataobject;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail {
    // 订单详情
    @Id
    private String detailId;

    private String orderId; // 订单ID

    private String productId; // 商品Id

    private String productName; //商品名称

    private BigDecimal productPrice; // 商品单价

    private Integer productQuantity; // 商品数量

    private String productIcon; // 商品小图

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
