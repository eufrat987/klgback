package klg.backend.lukasz.service;

import jakarta.persistence.EntityNotFoundException;
import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.repository.PropertyRepository;
import klg.backend.lukasz.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getProperties() {
        return propertyRepository.findAll();
    }

    public List<Reservation> getPropertyReservations(long id) {
        return propertyRepository.findById(id)
                .map(Property::getReservations)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

}
