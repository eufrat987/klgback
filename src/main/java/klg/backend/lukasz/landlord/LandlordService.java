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
        try {
            Thread.sleep(10000);
            System.out.println("1ldone");
        } catch (Exception e) {}
        List<Landlord> all = landlordRepository.findAll();
        try {
            Thread.sleep(10000);
            System.out.println("ldone");
        } catch (Exception e) {}
        return all;
    }

    public List<Reservation> getLandlordReservations(long id) {
        return landlordRepository.findById(id)
                .map(Landlord::getReservations)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Landlord createLandlord(Landlord landlord) {
        return landlordRepository.save(landlord);
    }

}
