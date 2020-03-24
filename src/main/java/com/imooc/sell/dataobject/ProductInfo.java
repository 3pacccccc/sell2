package com.imooc.sell.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductInfo {

    @Id
    private String productId;

    private String productName;  // 商品名称

    private BigDecimal productPrice; // 商品单价

    private Integer productStock; // 库存

    private String productDescription; // 商品描述

    private String productIcon; // 小图

    private Integer productStatus; // 状态 0正常1下架

    private Integer categoryType; // 类目编号

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

}
