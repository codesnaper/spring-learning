package in.neareststore.repository;

import in.neareststore.entity.CategoryMapping;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMappingRepository extends ReactiveMongoRepository<CategoryMapping, String> {
}
