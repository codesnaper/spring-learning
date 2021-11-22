package in.neareststore.repository;

import in.neareststore.entity.Payment;
import in.neareststore.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
}
