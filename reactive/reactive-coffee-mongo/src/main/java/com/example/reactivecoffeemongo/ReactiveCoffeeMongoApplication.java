package com.example.reactivecoffeemongo;

import com.example.reactivecoffeemongo.entity.Product;
import com.example.reactivecoffeemongo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@Slf4j
public class ReactiveCoffeeMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveCoffeeMongoApplication.class, args);
	}

//	Initialize some data with MongoDB. Spring has 2 option CommandLineRunner and applicationRunner
//	which mean how argument is passwd to spring when application start up.
	@Bean
	public CommandLineRunner commandLineRunner (ProductRepository repository){
		return args -> {
			Flux<Product> productFlux = Flux.just(
					new Product(null, "CAPACINO", 20.3,"CP"),
					new Product(null, "FilterCofee" , 10.2, "CC")
			)
					.flatMap(repository::save);
			log.info("Default product Saved in mongo DB");
			productFlux
					.thenMany(repository.findAll())
					.subscribe(product -> log.info("Product info = "+product.toString()));
		};
	}

}
