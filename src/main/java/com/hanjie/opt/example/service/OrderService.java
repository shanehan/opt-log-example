package com.hanjie.opt.example.service;

import org.springframework.stereotype.Component;

/**
 * @author han
 * @date 2021/3/15
 */
@Component
public class OrderService implements IOrderService {

    @Override
    public boolean updateOrderDetail(Long orderId, String detail) {
        return true;
    }
}
