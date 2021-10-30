package com.example.webclient;

import com.example.webclient.modal.Product;
import org.springframework.web.reactive.function.client.WebClient;

public class Application {

    public static void main (String[] args){
        WebClientApi webClientApi = new WebClientApi();
        webClientApi.getAllProduct()
                .subscribe(System.out::println);
        webClientApi.addProduct(new Product(null,"Product1",10.0,"P1"))
                .doOnNext(productResponseEntity -> System.out.println("Product >> "+ productResponseEntity.toString()))
                .subscribe(System.out::println);
    }
}
