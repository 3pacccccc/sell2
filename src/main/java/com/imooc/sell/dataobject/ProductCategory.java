package com.imooc.sell.dataobject;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class ProductCategory {

    @Id
    @GeneratedValue
    //用于标注主键的生成策略，通过strategy 属性指定。默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略：SqlServer对应identity，MySQL 对应 auto increment。
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    @CreatedDate
//    @Column(updatable = false, nullable = false)
    private Date createTime;

    @LastModifiedDate
//    @Column(nullable = false)
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
