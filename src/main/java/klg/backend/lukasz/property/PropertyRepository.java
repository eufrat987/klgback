package klg.backend.lukasz.property;

import klg.backend.lukasz.property.Property;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends ListCrudRepository<Property, Long> {
}
