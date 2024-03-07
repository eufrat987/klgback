package klg.backend.lukasz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.repository.LandlordRepository;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordServiceImpl implements LandlordService {
    @Autowired
    LandlordRepository landlordRepository;

    public List<Landlord> getLandlords() {
        return landlordRepository.findAll();
    }

    public List<Reservation> getLandlordReservations(String name) {
        return landlordRepository.findById(name)
                .map(Landlord::getReservations)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Landlord createLandlord(Landlord landlord) {
        return landlordRepository.save(landlord);
    }

}
