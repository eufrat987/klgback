package klg.backend.lukasz.reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReservationRepository extends ListCrudRepository<Reservation, Long> {

    @Query(value = "SELECT TOP 1 * FROM RESERVATION r WHERE r.rent_start <= :end and :start <= r.rent_end", nativeQuery = true)
    Optional<Reservation> findDateIntersection(@Param("start") LocalDate start, @Param("end") LocalDate end);

}
