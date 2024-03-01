package klg.backend.lukasz.repository;

import klg.backend.lukasz.model.Reservation;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends ListCrudRepository<Reservation, Long> {
}
