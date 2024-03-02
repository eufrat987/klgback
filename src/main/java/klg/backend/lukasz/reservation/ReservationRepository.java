package klg.backend.lukasz.reservation;

import klg.backend.lukasz.reservation.Reservation;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends ListCrudRepository<Reservation, Long> {
}
