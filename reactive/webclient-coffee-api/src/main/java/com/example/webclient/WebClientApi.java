package com.example.webclient;

import com.example.webclient.modal.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebClientApi {

    private final WebClient webClient;

    public WebClientApi() {
        this.webClient = WebClient.create("http://localhost:8080/api/v1/product/");
    }

    public Flux<Product> getAllProduct() {
        return this.webClient
                .get()
                .retrieve()
                .bodyToFlux(Product.class);
    }

    public Mono<ResponseEntity<Product>> addProduct(Product product) {
        return this.webClient
                .post()
                .body(Mono.just(product), Product.class)
                .exchangeToMono(clientResponse -> clientResponse.toEntity(Product.class));
    }
}
