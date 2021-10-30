package com.example.coffee.controller;

import com.example.coffee.modal.Product;
import com.example.coffee.repository.IproductRepository;
import com.example.coffee.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/coffee")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping(value = "/" ,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> saveProduct(@RequestBody Product product) throws Exception{
        return productService.saveProduct(product);
    }
}
