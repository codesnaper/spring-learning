package in.neareststore.repository;

import in.neareststore.entity.Subscription;
import in.neareststore.entity.Template;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TemplateRepository extends ReactiveMongoRepository<Template,String> {
}
