package klg.backend.lukasz.landlord;

import klg.backend.lukasz.landlord.Landlord;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRepository extends ListCrudRepository<Landlord, Long> { //todo list
}
