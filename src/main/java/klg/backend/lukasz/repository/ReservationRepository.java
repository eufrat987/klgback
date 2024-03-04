package klg.backend.lukasz.repository;

import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.repository.report.Report;
import klg.backend.lukasz.repository.report.ReportTenant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
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
            SELECT t.name as TENANT, count(distinct r.PROPERTY_ID) AS PROPERTIES, sum(r.cost) AS PROFIT, sum(guests) as GUESTS from reservation r
            LEFT JOIN TENANT t on t.id = r.tenant_id
            WHERE rent_start >= :start and rent_end <= :end
            GROUP BY t.name
            """, nativeQuery = true)
    List<ReportTenant> getTenantReport(@Param("start") LocalDate start, @Param("end") LocalDate end);

}
