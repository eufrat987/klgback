package klg.backend.lukasz.property;

import klg.backend.lukasz.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
