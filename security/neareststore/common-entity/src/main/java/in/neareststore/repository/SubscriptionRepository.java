package in.neareststore.repository;

import in.neareststore.entity.StoreUser;
import in.neareststore.entity.Subscription;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SubscriptionRepository extends ReactiveMongoRepository<Subscription,String> {
}
