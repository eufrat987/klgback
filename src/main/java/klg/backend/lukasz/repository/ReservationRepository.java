package klg.backend.lukasz.repository;

import klg.backend.lukasz.examples.Customer;
import klg.backend.lukasz.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
