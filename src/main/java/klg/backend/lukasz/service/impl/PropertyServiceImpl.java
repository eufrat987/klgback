package klg.backend.lukasz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.repository.PropertyRepository;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getProperties() {
        return propertyRepository.findAll();
    }

    public List<Reservation> getPropertyReservations(String name) {
        return propertyRepository.findById(name)
                .map(Property::getReservations)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

}
