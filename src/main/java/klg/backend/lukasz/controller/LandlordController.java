package klg.backend.lukasz.controller;

import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/landlords")
public class LandlordController {

    @Autowired
    LandlordService landlordService;

    @GetMapping
    ResponseEntity<List<Landlord>> getLandlords() {
        return new ResponseEntity<>(landlordService.getLandlords(), HttpStatus.OK);
    }

    @GetMapping("/{id}/reservations")
    ResponseEntity<List<Reservation>> getLandlordReservations(@PathVariable("id") long id) {
        return landlordService.getLandlordReservations(id)
                .map(reservations -> new ResponseEntity<>(reservations, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    ResponseEntity<Landlord> createLandlord(@RequestBody Landlord landlord) {
        return new ResponseEntity<>(landlordService.createLandlord(landlord), HttpStatus.OK);
    }

}
