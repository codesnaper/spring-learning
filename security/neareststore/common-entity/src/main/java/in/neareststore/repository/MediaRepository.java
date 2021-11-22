package in.neareststore.repository;

import in.neareststore.entity.Coupon;
import in.neareststore.entity.Media;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MediaRepository extends ReactiveMongoRepository<Media,String> {
}
