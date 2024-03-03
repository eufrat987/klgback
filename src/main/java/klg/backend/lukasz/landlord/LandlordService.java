package klg.backend.lukasz.landlord;

import jakarta.persistence.EntityNotFoundException;
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

    public List<Reservation> getLandlordReservations(String name) {
        return landlordRepository.findByName(name)
                .map(Landlord::getReservations)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Landlord createLandlord(Landlord landlord) {
        return landlordRepository.save(landlord);
    }

}
