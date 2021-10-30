package com.example.reactivecoffeemongo.repository;

import com.example.reactivecoffeemongo.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String > {

}
