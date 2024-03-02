package klg.backend.lukasz.landlord;

import klg.backend.lukasz.reservation.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LandlordService {
    @Autowired
    LandlordRepository landlordRepository;

    public List<Landlord> getLandlords() {
        log.info("LandlordService:getLandlords started.");
        List<Landlord> landlords = landlordRepository.findAll();
        log.info("LandlordService:getLandlords ended.");
        return landlords;
    }

    public Optional<List<Reservation>> getLandlordReservations(long id) {
        log.info("LandlordService:getLandlordReservations started.");
        Optional<List<Reservation>> reservations = landlordRepository.findById(id).map(Landlord::getReservations);
        log.info("LandlordService:getLandlordReservations ended.");
        return reservations;
    }

    public Landlord createLandlord(Landlord landlord) {
        log.info("LandlordService:createLandlord started.");
        Landlord savedLandlord = landlordRepository.save(landlord);
        log.info("LandlordService:createLandlord ended.");
        return savedLandlord;
    }

}
