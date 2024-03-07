package klg.backend.lukasz.controller;

import klg.backend.lukasz.controller.request.PropertyRequest;
import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping
    ResponseEntity<List<Property>> getProperties() {
        return new ResponseEntity<>(propertyService.getProperties(), HttpStatus.OK);
    }

    @GetMapping("/{name}/reservations")
    ResponseEntity<List<Reservation>> getPropertyReservations(@PathVariable("name") String name) {
        return new ResponseEntity<>(propertyService.getPropertyReservations(name), HttpStatus.OK);

    }

    @PostMapping
    ResponseEntity<Property> createProperty(@RequestBody PropertyRequest property) {
        return new ResponseEntity<>(propertyService.createProperty(property.map()), HttpStatus.OK);
    }

}
