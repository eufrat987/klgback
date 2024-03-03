package klg.backend.lukasz.reservation;

import klg.backend.lukasz.reservation.report.Report;
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

    @Query(value = "SELECT count(*) as Count, SUM( DATEDIFF(day, rent_start, rent_end) + 1 ) as Days FROM RESERVATION WHERE rent_start >= :start AND rent_end <= :end AND property_id = :id", nativeQuery = true)
    Optional<Report> getPropertyReport(@Param("start") LocalDate start, @Param("end") LocalDate end, @Param("id") long id);

}
