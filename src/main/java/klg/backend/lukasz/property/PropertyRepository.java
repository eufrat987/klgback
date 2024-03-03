package klg.backend.lukasz.property;

import klg.backend.lukasz.property.report.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PropertyRepository extends ListCrudRepository<Property, Long> {

    @Query(value = "SELECT count(*) as Count, SUM( DATEDIFF(day, rent_start, rent_end) + 1 ) as Days FROM RESERVATION WHERE rent_start >= :start and rent_end <= :end", nativeQuery = true)
    Optional<Report> getReport(@Param("start") LocalDate start, @Param("end") LocalDate end);

}
