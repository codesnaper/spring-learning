package com.example.coffee.service;

import com.example.coffee.modal.Product;
import com.example.coffee.repository.IproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IProductService{

    private final IproductRepository repository;

    @Autowired
    public ProductService(IproductRepository repository) {
        this.repository = repository;
    }

    public Mono<Product> saveProduct(Product product) throws Exception{
        if(product.getName() == null || product.getQuantity() == 0){
            throw new IllegalArgumentException(String.format("Product name and quantity can't be null"));
        }
        return repository.save(product);
    }
}
