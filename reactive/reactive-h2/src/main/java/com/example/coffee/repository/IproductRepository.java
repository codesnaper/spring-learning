package com.example.coffee.repository;

import com.example.coffee.modal.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IproductRepository extends ReactiveCrudRepository<Product, Integer> {
}
