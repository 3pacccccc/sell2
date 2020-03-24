package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId); // 查找指定的单个商品

    List<ProductInfo> findUpAll(); // 查询所有上架商品

    Page<ProductInfo> findAll(Pageable pageable); // 查询所有上架商品

    ProductInfo save(ProductInfo productInfo);

    void increaseStock(List<CartDTO> cartDTOList);

    void decreaseStock(List<CartDTO> cartDTOList);

}
