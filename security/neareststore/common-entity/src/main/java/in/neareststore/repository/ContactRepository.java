package in.neareststore.repository;

import in.neareststore.entity.Contact;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ContactRepository extends ReactiveMongoRepository<Contact,String> {
}
