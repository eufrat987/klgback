package klg.backend.lukasz.repository;

import klg.backend.lukasz.model.Landlord;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandlordRepository extends ListCrudRepository<Landlord, Long> {

    Optional<Landlord> findByName(String name);

}
