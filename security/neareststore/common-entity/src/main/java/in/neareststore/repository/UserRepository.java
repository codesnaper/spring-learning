package in.neareststore.repository;

import in.neareststore.entity.Template;
import in.neareststore.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User,String> {
}
