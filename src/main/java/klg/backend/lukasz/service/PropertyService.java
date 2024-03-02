package klg.backend.lukasz.service;

import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getProperties() {
        return propertyRepository.findAll();
    }

    public Optional<List<Reservation>> getPropertyReservations(long id) {
        return propertyRepository.findById(id).map(Property::getReservations);
    }

    public Property createProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }

}
