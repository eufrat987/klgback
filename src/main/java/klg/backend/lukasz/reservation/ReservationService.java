package klg.backend.lukasz.reservation;

import jakarta.persistence.EntityNotFoundException;
import klg.backend.lukasz.exception.ReservationRequestException;
import klg.backend.lukasz.landlord.LandlordRepository;
import klg.backend.lukasz.property.PropertyRepository;
import klg.backend.lukasz.tenant.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
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

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Reservation createReservation(@RequestBody Reservation reservation) {
        validate(reservation);

//        try {
//            Thread.sleep(10000);
//            System.out.println("1rdone");
//        } catch (Exception e) {}

        setForeignKeys(reservation, reservation);
        System.out.println("sss " + reservationRepository.findAll().size());
        Reservation saved = reservationRepository.save(reservation);

//        try {
//            Thread.sleep(10000);
//            System.out.println("rdone");
//        } catch (Exception e) {}

        return saved;
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

    @Transactional(propagation = Propagation.NEVER)
    private void validate(Reservation reservation) {
        if (!reservation.getRentStart().isBefore(reservation.getRentEnd())) {
            throw new ReservationRequestException("rentStart after rentEnd");
        }

        long start = System.currentTimeMillis();

        var dateIntersection = reservationRepository
                .findDateIntersection(reservation.getRentStart(), reservation.getRentEnd());
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        System.out.println("time: " + timeElapsed);
        if (!dateIntersection.isEmpty()) {
//            throw new ReservationRequestException("Property is rented already");
        }
    }

    @Transactional(propagation = Propagation.NEVER)
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
