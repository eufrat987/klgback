package klg.backend.lukasz.controller;

import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.repository.LandlordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/landlords")
public class LandlordController {

    @Autowired
    LandlordRepository landlordRepository;

    @GetMapping
    ResponseEntity<List<Landlord>> getLandlords() {
        return new ResponseEntity<>(landlordRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}/reservations")
    ResponseEntity<List<Reservation>> getLandlordReservations(@PathVariable("id") long id) {
        Optional<Landlord> landlordOptional = landlordRepository.findById(id);
        return landlordOptional
                .map(landlord -> new ResponseEntity<>(landlord.getReservations(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    ResponseEntity<Landlord> createLandlord(@RequestBody Landlord landlord) {
        return new ResponseEntity<>(landlordRepository.save(landlord), HttpStatus.OK);
    }

}
