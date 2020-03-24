package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellExcetion;
import com.imooc.sell.repository.OrderMasterRepository;
import com.imooc.sell.service.BuyerService;
import com.imooc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            log.error("【查询订单】未查询到该订单, orderId={}", orderId);
            throw new SellExcetion(ResultEnum.ORDER_NOT_EXIST);
        }

        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("【查询订单】openId不匹配, orderId={}, openId={}", orderId, openid);
            throw new SellExcetion(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
