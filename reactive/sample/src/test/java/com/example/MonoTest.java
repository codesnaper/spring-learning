package com.example;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoTest {

    @Test
    public void monoPublisher(){
        Mono.just("A") //Publisher
                .log() // Logging
                .subscribe();
    }

    @Test
    public void monoSuccess() {
        Mono.just("A")
                .log()
                .doOnNext(val -> System.out.println("Passing value to subscriber "+val))
                .doOnCancel(() -> System.out.println("Calling cancle subscription"))
                .doOnSuccess(s -> System.out.println("All value transfer"))
                .doOnSubscribe(subscription -> {
                    subscription.request(1);
                    System.out.println("On Subscribe");
                })
                .subscribe();
    }

    @Test
    public void monoError(){
        Mono.error(new Exception("Error"))
                .log()
                .doOnError(throwable -> System.out.println("Error"))
                .subscribe();
    }
}
