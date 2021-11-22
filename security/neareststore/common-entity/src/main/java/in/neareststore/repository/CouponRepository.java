package in.neareststore.repository;

import in.neareststore.entity.Contact;
import in.neareststore.entity.Coupon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CouponRepository extends ReactiveMongoRepository<Coupon,String> {
}
