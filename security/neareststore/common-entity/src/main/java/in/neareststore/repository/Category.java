package in.neareststore.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Category extends ReactiveMongoRepository<Category, String> {
}
