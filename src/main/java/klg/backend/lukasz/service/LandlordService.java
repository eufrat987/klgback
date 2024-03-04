package klg.backend.lukasz.service;

import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.model.Reservation;

import java.util.List;

public interface LandlordService {
    public List<Landlord> getLandlords();
    public List<Reservation> getLandlordReservations(String name);
    public Landlord createLandlord(Landlord landlord);

}
