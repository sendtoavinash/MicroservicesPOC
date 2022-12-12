package com.avi.OrderService.Service;

import com.avi.OrderService.Model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
