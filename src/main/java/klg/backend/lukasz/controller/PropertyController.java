package klg.backend.lukasz.controller;

import com.fasterxml.jackson.annotation.JsonView;
import klg.backend.lukasz.controller.view.View;
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
    @JsonView(View.Internal.class)
    ResponseEntity<List<Property>> getProperties() {
        return new ResponseEntity<>(propertyService.getProperties(), HttpStatus.OK);
    }

    @GetMapping("/{id}/reservations")
    @JsonView(View.Internal.class)
    ResponseEntity<List<Reservation>> getPropertyReservations(@PathVariable("id") long id) {
        return new ResponseEntity<>(propertyService.getPropertyReservations(id), HttpStatus.OK);

    }

    @PostMapping
    @JsonView(View.Internal.class)
    ResponseEntity<Property> createProperty(@RequestBody Property property) {
        return new ResponseEntity<>(propertyService.createProperty(property), HttpStatus.OK);
    }

}
