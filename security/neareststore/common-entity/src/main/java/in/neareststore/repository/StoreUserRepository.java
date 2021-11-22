package in.neareststore.repository;

import in.neareststore.entity.Store;
import in.neareststore.entity.StoreUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StoreUserRepository extends ReactiveMongoRepository<StoreUser,String> {
}
