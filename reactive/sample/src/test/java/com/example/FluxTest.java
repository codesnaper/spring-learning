package com.example;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;

public class FluxTest {

    @Test
    public void testFlux(){
        Flux.just("1","2","3")
                .log()
                .subscribe();
    }

    @Test
    public void testFluxList(){
        Flux.just(Arrays.asList("1","2","3")) //It will pass list as one to subscribe
                .log()
                .subscribe();

        // if we want to pass the list element different
        Flux.fromIterable(Arrays.asList("1","2","3"))
                .log()
                .subscribe();
    }

    @Test
    void testFluxRange(){
        Flux.range(10,5)
                .log()
                .subscribe();
    }

    @Test
    void testFluxFromInterval() throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .log()
                .subscribe();

        Thread.sleep(5000);

        //It will never completed . So we make a limit using take(2) so after 2 it will cancel the subscription
    }

    @Test
    void FluxRequest(){
        Flux.range(0,10)
                .log()
                .subscribe(
                        new BaseSubscriber<Integer>() {
                            @Override
                            protected void hookOnSubscribe(Subscription subscription) {
                                subscription.request(5);
                            }
                        }
                );
    }
}
