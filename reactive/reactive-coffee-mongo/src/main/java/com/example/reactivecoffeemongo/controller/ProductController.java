package com.example.reactivecoffeemongo.controller;

import com.example.reactivecoffeemongo.modal.ProductBO;
import com.example.reactivecoffeemongo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/product/")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ProductBO> getAllProduct(){
        return this.productService.getAllProducts();
    }

    @GetMapping(value = "{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<ProductBO>> getProduct(@PathVariable String id){
        return this.productService
                .getProduct(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductBO> saveProduct(@RequestBody ProductBO productBO){
        return this.productService.saveProduct(productBO);
    }

    @DeleteMapping(value = "{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable String id){
        return this.productService
                .getProduct(id)
                .flatMap(productBO ->
                        productService.deleteProduct(productBO)
                                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "subscribe" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Object> subscribe(){
        return Flux.interval(Duration.ofSeconds(1))
                .map(val -> val);
    }

}
