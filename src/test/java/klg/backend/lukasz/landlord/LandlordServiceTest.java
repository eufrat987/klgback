package klg.backend.lukasz.landlord;

import jakarta.transaction.Transactional;
import klg.backend.lukasz.reservation.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LandlordServiceTest {

    @Autowired
    LandlordService landlordService;

    @Test
    @Transactional
    public void whenFindingAllReservationByLandlord_thenCorrect() {
        List<Reservation> reservations = landlordService.getLandlordReservations(1L);
        assertThat(reservations.isEmpty()).isFalse();
    }

}
