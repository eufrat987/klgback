package klg.backend.lukasz.landlord;

import klg.backend.lukasz.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandlordService {
    @Autowired
    LandlordRepository landlordRepository;

    public List<Landlord> getLandlords() {
        return landlordRepository.findAll();
    }

    public Optional<List<Reservation>> getLandlordReservations(long id) {
        return landlordRepository.findById(id).map(Landlord::getReservations);
    }

    public Landlord createLandlord(Landlord landlord) {
        return landlordRepository.save(landlord);
    }

}
