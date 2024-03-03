package klg.backend.lukasz.reservation;

import jakarta.persistence.EntityNotFoundException;
import klg.backend.lukasz.exception.ReservationRequestException;
import klg.backend.lukasz.landlord.LandlordRepository;
import klg.backend.lukasz.property.PropertyRepository;
import klg.backend.lukasz.reservation.report.Report;
import klg.backend.lukasz.tenant.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    LandlordRepository landlordRepository;
    @Autowired
    TenantRepository tenantRepository;
    @Autowired
    PropertyRepository propertyRepository;

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Reservation createReservation2(@RequestBody Reservation reservation) {
        var x = LocalDate.now();
        for (var i = 0; i < 500_000; i++) {
            System.out.println(i);
            var res = new Reservation();
            res.setRentStart(x);
            res.setRentEnd(x.plusDays(3));
            res.setCost(reservation.getCost());
            setForeignKeys(reservation, res);

            reservationRepository.save(res);
            x = x.plusDays(5);
        }

        return null;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE) // test false ro for deadlock
    public Reservation createReservation(@RequestBody Reservation reservation) {
        validate(reservation);
        setForeignKeys(reservation, reservation);
        return reservationRepository.save(reservation);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Reservation updateReservation(long id, Reservation reservation) {
        validate(reservation);
        Reservation reservationInDB = reservationRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        setForeignKeys(reservation, reservationInDB);
        reservationInDB.setCost(reservation.getCost());
        reservationInDB.setRentStart(reservation.getRentStart());
        reservationInDB.setRentEnd(reservation.getRentEnd());

        return reservationRepository.save(reservationInDB);
    }

    public Report getPropertyReport(LocalDate start, LocalDate end, long id) {
        return reservationRepository.getPropertyReport(start, end, id).orElseThrow(RuntimeException::new);
    }

    private void validate(Reservation reservation) {
        if (!reservation.getRentStart().isBefore(reservation.getRentEnd())) {
            throw new ReservationRequestException("rentStart after rentEnd");
        }

        var dateIntersection = reservationRepository
                .findDateIntersection(reservation.getRentStart(), reservation.getRentEnd());

        if (dateIntersection.isPresent()) {
            throw new ReservationRequestException("Property is rented already");
        }
    }

    private void setForeignKeys(Reservation newReservation, Reservation reservationInDB) {
        if (newReservation.getLandlord() != null) {
            var landlord = landlordRepository.findById(newReservation.getLandlord().getId())
                    .orElseThrow(EntityNotFoundException::new);
            reservationInDB.setLandlord(landlord);
        }
        if (newReservation.getTenant() != null) {
            var tenant = tenantRepository.findById(newReservation.getTenant().getId())
                    .orElseThrow(EntityNotFoundException::new);
            reservationInDB.setTenant(tenant);
        }
        if (newReservation.getProperty() != null) {
            var property = propertyRepository.findById(newReservation.getProperty().getId())
                    .orElseThrow(EntityNotFoundException::new);
            reservationInDB.setProperty(property);
        }
    }

}
