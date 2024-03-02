package klg.backend.lukasz.controller;

import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/properties")
public class PropertyController {

    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping
    ResponseEntity<List<Property>> getProperties() {
        return new ResponseEntity<>(propertyRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Property> createProperty(@RequestBody Property property) {
        return new ResponseEntity<>(propertyRepository.save(property), HttpStatus.OK);
    }

}
