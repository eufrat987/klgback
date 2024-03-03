package klg.backend.lukasz.reservation;

import klg.backend.lukasz.reservation.report.Report;
import klg.backend.lukasz.reservation.report.ReportTenant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface ReservationRepository extends ListCrudRepository<Reservation, Long> {

    @Query(value = """
            SELECT TOP 1 * FROM RESERVATION r
            WHERE r.rent_start <= :end 
            AND :start <= r.rent_end
            """, nativeQuery = true)
    Optional<Reservation> findDateIntersection(@Param("start") LocalDate start, @Param("end") LocalDate end);

    @Query(value = """
            SELECT count(*) as Count, SUM( DATEDIFF(day, rent_start, rent_end) + 1 ) as Days
            FROM RESERVATION 
            WHERE rent_start >= :start 
            AND rent_end <= :end 
            AND property_id = :id
            """, nativeQuery = true)
    Optional<Report> getPropertyReport(@Param("start") LocalDate start, @Param("end") LocalDate end, @Param("id") long id);

    @Query(value = """
            SELECT p.name as name, t.name as tenant, count(*) as count, sum(r.cost) as cost 
            FROM reservation r
            LEFT JOIN TENANT t on t.id = r.tenant_id
            LEFT JOIN property p on p.id = r.property_id
            WHERE rent_start >= :start 
            AND rent_end <= :end
            GROUP BY t.name, p.name
            """, nativeQuery = true)
    List<ReportTenant> getTenentReport(@Param("start") LocalDate start, @Param("end") LocalDate end);

}
