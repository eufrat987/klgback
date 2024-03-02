package klg.backend.lukasz.controller;

import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/properties")
public class PropertyController {

    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping
    List<Property> getProperties() {
        return propertyRepository.findAll();
    }

    @PostMapping
    Property createProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }

}
