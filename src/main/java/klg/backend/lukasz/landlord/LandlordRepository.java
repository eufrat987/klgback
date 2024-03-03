package klg.backend.lukasz.landlord;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandlordRepository extends ListCrudRepository<Landlord, Long> {

    Optional<Landlord> findByName(String name);

}
