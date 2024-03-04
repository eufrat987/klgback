package klg.backend.lukasz.service;

import jakarta.persistence.EntityNotFoundException;
import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.repository.LandlordRepository;
import klg.backend.lukasz.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
