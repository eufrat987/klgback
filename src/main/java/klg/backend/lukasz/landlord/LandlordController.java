package klg.backend.lukasz.landlord;

import klg.backend.lukasz.reservation.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/landlords")
@Slf4j
public class LandlordController {

    @Autowired
    LandlordService landlordService;

    @GetMapping
    ResponseEntity<List<Landlord>> getLandlords() {
        return new ResponseEntity<>(landlordService.getLandlords(), HttpStatus.OK);
    }

    @GetMapping("/{name}/reservations")
    ResponseEntity<List<Reservation>> getLandlordReservations(@PathVariable("name") String name) {
        return new ResponseEntity<>(landlordService.getLandlordReservations(name), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Landlord> createLandlord(@RequestBody Landlord landlord) {
        return new ResponseEntity<>(landlordService.createLandlord(landlord), HttpStatus.OK);
    }

}
