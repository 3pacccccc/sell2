package com.imooc.sell.repository;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dataobject.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("iuqroeh");
        orderMaster.setBuyerName("不差钱！");
        orderMaster.setBuyerPhone("wqer6873");
        orderMaster.setBuyerAddress("LA");
        orderMaster.setBuyerOpenid("pqoirnm,sxn");
        orderMaster.setOrderAmount(new BigDecimal(17.56));
        orderMaster.setOrderStatus(1);
        orderMaster.setPayStatus(2);

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest() {
        OrderMaster orderMaster = repository.findOne("iuqroeh");
        orderMaster.setPayStatus(0);
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenidTest() {
//        PageRequest request = new PageRequest(0, 2);
//        Page<ProductInfo> productInfos = productService.findAll(request);
        PageRequest request = new PageRequest(0, 10);
        Page<OrderMaster> orderMasters = repository.findByBuyerOpenid("333", request);
        Assert.assertEquals(orderMasters.getTotalElements(), 10);
        List<OrderMaster> orderMasterList = orderMasters.getContent();
        Assert.assertEquals(orderMasterList.size(), 10);
        for (OrderMaster orderMaster : orderMasterList) {
            Assert.assertEquals("333", orderMaster.getBuyerOpenid());
        }
    }

    @Test
    public void deleteTest() {
        OrderMaster orderMaster = repository.findOne("iuqroeh");
        Assert.assertNotNull(orderMaster);

        repository.delete("iuqroeh");
        OrderMaster orderMaster2 = repository.findOne("iuqroeh");
        Assert.assertNull(orderMaster2);
    }

    @Test
    public void logTest(){
        try {
            Integer a = 1 / 0;
        }catch (Exception e){
            log.error("【测试错误】:{}", e);
        }
    }
}