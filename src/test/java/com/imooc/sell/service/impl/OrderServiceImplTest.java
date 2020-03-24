package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellExcetion;
import com.imooc.sell.repository.OrderMasterRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("caijing0");
        orderDetail1.setProductQuantity(100);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("caijing1");
        orderDetail2.setProductQuantity(6);

        List<OrderDetail> orderDetails = Arrays.asList(orderDetail1, orderDetail2);

        orderDTO.setOrderDetailList(orderDetails);
        orderDTO.setBuyerName("马哥先生");
        orderDTO.setBuyerPhone("17wsekjhr2232");
        orderDTO.setBuyerAddress("阿里巴巴");
        orderDTO.setBuyerOpenid("hqwiuerh2");

        OrderDTO result = orderService.create(orderDTO);
        System.out.println(result);

    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne("1584265174278343967");
        Assert.assertNotNull(orderDTO);
        System.out.println(orderDTO);
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(3, 6);
        Page<OrderDTO> orderDTOS = orderService.findList("333", request);
        Assert.assertNotNull(orderDTOS);
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1584265174278343967");
        orderDTO.setOrderStatus(OrderStatusEnum.NEW.getCode());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("caijing0");
        orderDetail1.setProductQuantity(5);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail1.setProductId("caijing1");
        orderDetail1.setProductQuantity(6);

        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }

    @Test
    public void findList1() {
    }
}