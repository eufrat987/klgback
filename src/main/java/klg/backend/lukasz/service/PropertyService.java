package klg.backend.lukasz.service;

import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {
    public List<Property> getProperties();
    public List<Reservation> getPropertyReservations(String name);
    public Property createProperty(Property property);
}
