package com.example.reactivecoffeemongo.service;

import com.example.reactivecoffeemongo.helper.ProductMapper;
import com.example.reactivecoffeemongo.modal.ProductBO;
import com.example.reactivecoffeemongo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<ProductBO> getAllProducts(){
        log.info("Fetching all the produts");
        return this.productRepository
                .findAll()
                .map(ProductMapper::productMapper);
    }

    @Override
    public Mono<ProductBO> getProduct(String id){
        return this.productRepository
                .findById(id)
                .map(ProductMapper::productMapper);
    }

    public Mono<ProductBO> saveProduct(ProductBO productBO){
        return this.productRepository.save(ProductMapper.getProductEntity(productBO))
                .map(ProductMapper::productMapper);
    }

    public Mono<Void> deleteProduct(ProductBO productBO){
        return this.productRepository.delete(ProductMapper.getProductEntity(productBO));
    }
}
