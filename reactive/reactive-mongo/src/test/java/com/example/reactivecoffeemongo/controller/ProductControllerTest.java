package com.example.reactivecoffeemongo.controller;

import com.example.reactivecoffeemongo.entity.Product;
import com.example.reactivecoffeemongo.modal.ProductBO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {

    private WebTestClient webTestClient;

    @Autowired
    private ProductController productController;

    @BeforeEach
    public void setUp(){
        this.webTestClient = WebTestClient.bindToController(productController)
                .configureClient()
                .baseUrl("/api/v1/product/")
                .build();
    }

    @Test
    void getAllProduct() {
        this.webTestClient.get()
                .uri("")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Product.class)
                .hasSize(3);
    }

    @Test
    void saveProduct(){
        ProductBO productBO = new ProductBO();
        productBO.setName("Product 1");
        productBO.setPrice(100.0);
        productBO.setCode("P1");
        this.webTestClient.post()
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(productBO),ProductBO.class)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(ProductBO.class)
                .value(productBO1 -> fetchProduct(productBO1.getId(), productBO1));
    }

    void fetchProduct(String id, ProductBO productBO){
        this.webTestClient.get()
                .uri("{id}",id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(ProductBO.class)
                .isEqualTo(productBO);
    }

    @Test
    void fetchProductNotFound(){
        this.webTestClient.get()
                .uri("{id}","1")
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void subscribe(){
        FluxExchangeResult<Object> objectFluxExchangeResult =
                this.webTestClient.get()
                .uri("subscribe")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Object.class);

        StepVerifier.create(objectFluxExchangeResult.getResponseBody())
                .expectNextCount(2)
                .thenCancel()
                .verify();

    }
}