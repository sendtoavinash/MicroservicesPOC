package com.avi.PaymentService.Service;

import com.avi.PaymentService.Model.PaymentRequest;
import com.avi.PaymentService.Model.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
