package klg.backend.lukasz.repository;

import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.repository.queryresult.ReportPropertyQueryResult;
import klg.backend.lukasz.repository.queryresult.ReportTenantQueryResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReservationRepository extends ListCrudRepository<Reservation, Long> {

    @Query(value = """
            SELECT TOP 1 * FROM RESERVATION r
            WHERE r.rent_start <= :end 
            AND :start <= r.rent_end
            AND id != :id
            """, nativeQuery = true)
    Optional<Reservation> findDateIntersection(@Param("start") LocalDate start, @Param("end") LocalDate end, @Param("id") long id);

    @Query(value = """
            SELECT count(*) as NumOfReservations, SUM( DATEDIFF(day, rent_start, rent_end) + 1 ) as BusyDays
            FROM RESERVATION
            WHERE rent_start >= :start 
            AND rent_end <= :end 
            AND property = :property_name
            """, nativeQuery = true)
    Optional<ReportPropertyQueryResult> getPropertyReport(@Param("start") LocalDate start, @Param("end") LocalDate end, @Param("property_name") String name);

    @Query(value = """
            SELECT t.name as TENANT, p.name as Property, sum(r.cost) AS PROFIT, sum(guests) as GUESTS
            FROM reservation r
            LEFT JOIN TENANT t on t.name = r.tenant
            LEFT JOIN PROPERTY p on p.name = r.property
            WHERE rent_start >= :start and rent_end <= :end
            GROUP BY t.name, p.name	ORDER BY p.name
            """, nativeQuery = true)
    Slice<ReportTenantQueryResult> getTenantReport2(@Param("start") LocalDate start, @Param("end") LocalDate end, Pageable pageable);

}
