package klg.backend.lukasz.service;

import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.model.Tenant;
import klg.backend.lukasz.repository.LandlordRepository;
import klg.backend.lukasz.repository.PropertyRepository;
import klg.backend.lukasz.repository.ReservationRepository;
import klg.backend.lukasz.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

    public Reservation createReservation(@RequestBody Reservation reservation) {
        Optional<Landlord> landlordOptional = landlordRepository.findById(reservation.getLandlord().getId());
        Optional<Tenant> tenantOptional = tenantRepository.findById(reservation.getTenant().getId());
        Optional<Property> propertyOptional = propertyRepository.findById(reservation.getId());

        landlordOptional.ifPresent(reservation::setLandlord);
        tenantOptional.ifPresent(reservation::setTenant);
        propertyOptional.ifPresent(reservation::setProperty);

        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> updateReservation(long id, Reservation reservation) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        Optional<Landlord> landlordOptional = Optional.empty();
        Optional<Tenant> tenantOptional = Optional.empty();
        Optional<Property> propertyOptional = Optional.empty();

        if (reservationOptional.isEmpty()) {
            return Optional.empty();
        }
        if (reservation.getLandlord() != null) {
            landlordOptional = landlordRepository.findById(reservation.getLandlord().getId());
        }
        if (reservation.getLandlord() != null) {
            tenantOptional = tenantRepository.findById(reservation.getTenant().getId());
        }
        if (reservation.getLandlord() != null) {
            propertyOptional = propertyRepository.findById(reservation.getId());
        }

        Reservation reservationInDB = reservationOptional.get();
        landlordOptional.ifPresent(reservationInDB::setLandlord);
        tenantOptional.ifPresent(reservationInDB::setTenant);
        propertyOptional.ifPresent(reservationInDB::setProperty);
        reservationInDB.setCost(reservation.getCost());
        reservationInDB.setRentStart(reservation.getRentStart());
        reservationInDB.setRentEnd(reservation.getRentEnd());

        return Optional.of(reservationRepository.save(reservationInDB));
    }

}
