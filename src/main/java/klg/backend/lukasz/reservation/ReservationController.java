package klg.backend.lukasz.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    ResponseEntity<List<Reservation>> getReservations() {
        return new ResponseEntity<>(reservationService.getReservations(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.createReservation(reservation), HttpStatus.OK);
    }

    @PostMapping("/l")
    ResponseEntity<Reservation> createReservation2(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.createReservation2(reservation), HttpStatus.OK);
    }

    @PutMapping("/{id}")
        //todo page?
    ResponseEntity<Reservation> updateReservation(@PathVariable("id") long id, @RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.updateReservation(id, reservation), HttpStatus.OK);
    }

}
