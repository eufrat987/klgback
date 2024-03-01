package klg.backend.lukasz.repository;

import klg.backend.lukasz.model.Landlord;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRepository extends ListCrudRepository<Landlord, Long> { //todo list
}
