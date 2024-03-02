package klg.backend.lukasz.controller;

import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.model.Tenant;
import klg.backend.lukasz.repository.LandlordRepository;
import klg.backend.lukasz.repository.ReservationRepository;
import klg.backend.lukasz.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    LandlordRepository landlordRepository;
    @Autowired
    TenantRepository tenantRepository;

    @GetMapping
    List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @PostMapping
    Reservation createReservation(@RequestBody Reservation reservation) {
        Optional<Landlord> byId = landlordRepository.findById(reservation.getLandlord().getId());
        Optional<Tenant> byId1 = tenantRepository.findById(reservation.getTenant().getId());
        reservation.setLandlord(byId.get());
        reservation.setTenant(byId1.get());
        return reservationRepository.save(reservation);
    }

}
