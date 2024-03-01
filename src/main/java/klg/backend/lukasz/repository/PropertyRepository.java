package klg.backend.lukasz.repository;

import klg.backend.lukasz.model.Property;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends ListCrudRepository<Property, Long> {
}
