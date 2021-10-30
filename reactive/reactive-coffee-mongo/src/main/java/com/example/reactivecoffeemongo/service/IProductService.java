package com.example.reactivecoffeemongo.service;

import com.example.reactivecoffeemongo.modal.ProductBO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {

    public Flux<ProductBO> getAllProducts();

    public Mono<ProductBO> getProduct(String id);

    public Mono<ProductBO> saveProduct(ProductBO productBO);

    public Mono<Void> deleteProduct(ProductBO productBO);
}
