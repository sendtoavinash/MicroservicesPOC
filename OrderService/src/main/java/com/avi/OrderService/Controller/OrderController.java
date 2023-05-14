package com.avi.OrderService.Controller;

import com.avi.OrderService.Model.OrderRequest;
import com.avi.OrderService.Model.OrderResponse;
import com.avi.OrderService.Service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "text/html")
    public String welcome() {
        return "Hello! This is the default welcome page for a Spring Boot Service";
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
        long orderId = orderService.placeOrder(orderRequest);
        log.info("Order Id: {}", orderId);
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }

//    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable long orderId) {
        OrderResponse orderResponse
                = orderService.getOrderDetails(orderId);

        return new ResponseEntity<>(orderResponse,
                HttpStatus.OK);
    }
}
