package in.neareststore.repository;

import in.neareststore.entity.Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ReactiveMongoRepository<Address, String> {
}
