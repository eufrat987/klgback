package klg.backend.lukasz.service;

import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.model.Reservation;

import java.util.List;

public interface PropertyService {
    public List<Property> getProperties();
    public List<Reservation> getPropertyReservations(long id);
    public Property createProperty(Property property);
}
