package klg.backend.lukasz.property;

import klg.backend.lukasz.reservation.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getProperties() {
        log.info("PropertyService:getProperties started.");
        List<Property> properties = propertyRepository.findAll();
        log.info("PropertyService:getProperties ended.");
        return properties;
    }

    public Optional<List<Reservation>> getPropertyReservations(long id) {
        log.info("PropertyService:getPropertyReservations started.");
        Optional<List<Reservation>> reservations = propertyRepository.findById(id).map(Property::getReservations);
        log.info("PropertyService:getPropertyReservations ended.");
        return reservations;
    }

    public Property createProperty(Property property) {
        log.info("PropertyService:createProperty started.");
        Property savedProperty = propertyRepository.save(property);
        log.info("PropertyService:createProperty ended.");
        return savedProperty;
    }

}
