package in.neareststore.repository;

import in.neareststore.entity.Product;
import in.neareststore.entity.Store;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StoreRepository extends ReactiveMongoRepository<Store,String> {
}
