package in.neareststore.repository;

import in.neareststore.entity.Media;
import in.neareststore.entity.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PaymentRepository extends ReactiveMongoRepository<Payment,String> {
}
