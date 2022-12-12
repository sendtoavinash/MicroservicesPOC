package com.avi.productService.service;

import com.avi.productService.model.ProductRequest;
import com.avi.productService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
