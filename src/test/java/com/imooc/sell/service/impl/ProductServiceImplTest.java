package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("1234568");
        Assert.assertEquals("1234568", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfos = productService.findUpAll();
        Assert.assertEquals(1, productInfos.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfos = productService.findAll(request);
        Assert.assertEquals(1, productInfos.getTotalElements());
    }

    @Test
    public void save() {

    }
}