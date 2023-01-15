package com.avi.OrderService.Service;

import com.avi.OrderService.Entity.Order;
import com.avi.OrderService.Model.OrderRequest;
import com.avi.OrderService.Repository.OrderRepository;
import com.avi.OrderService.external.client.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Override
    public long placeOrder(OrderRequest orderRequest) {

        log.info("Placing Order Request: {}", orderRequest);

        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        log.info("Creating Order with Status CREATED");
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        order = orderRepository.save(order);

//        log.info("Calling Payment Service to complete the payment");
//        PaymentRequest paymentRequest
//                = PaymentRequest.builder()
//                .orderId(order.getId())
//                .paymentMode(orderRequest.getPaymentMode())
//                .amount(orderRequest.getTotalAmount())
//                .build();
//
//        String orderStatus = null;
//        try {
//            paymentService.doPayment(paymentRequest);
//            log.info("Payment done Successfully. Changing the Oder status to PLACED");
//            orderStatus = "PLACED";
//        } catch (Exception e) {
//            log.error("Error occurred in payment. Changing order status to PAYMENT_FAILED");
//            orderStatus = "PAYMENT_FAILED";
//        }
//
//        order.setOrderStatus(orderStatus);
//        orderRepository.save(order);

        log.info("Order Places successfully with Order Id: {}", order.getId());
        return order.getId();
    }

}
