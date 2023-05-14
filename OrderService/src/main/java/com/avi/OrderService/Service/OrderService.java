package com.avi.OrderService.Service;

import com.avi.OrderService.Model.OrderRequest;
import com.avi.OrderService.Model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}

