package com.example.coffee.service;

import com.example.coffee.modal.Product;
import reactor.core.publisher.Mono;

public interface IProductService {

    public Mono<Product> saveProduct(Product product) throws Exception;
}
