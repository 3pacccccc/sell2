package com.imooc.sell.converter;


import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderMaster2OrderDTO {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
//        return orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList()); // 方法1
//        return orderMasterList.stream().map(OrderMaster2OrderDTO::convert).collect(Collectors.toList()); // 方法2
        List<OrderDTO> orderDTOList = new ArrayList<>(); // 方法3
        for (OrderMaster orderMaster : orderMasterList) {
            orderDTOList.add(convert(orderMaster));
        }
        return orderDTOList;
    }
}
