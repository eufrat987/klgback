package klg.backend.lukasz.controller;

import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping
    List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @PostMapping
    Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

}
