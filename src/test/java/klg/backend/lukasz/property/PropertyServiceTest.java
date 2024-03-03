package klg.backend.lukasz.property;

import jakarta.transaction.Transactional;
import klg.backend.lukasz.reservation.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PropertyServiceTest {

    @Autowired
    PropertyService propertyService;

    @Test
    @Transactional
    public void whenFindingAllReservationByLandlord_thenCorrect() {
        List<Reservation> reservations = propertyService.getPropertyReservations(1L);
        assertThat(reservations.isEmpty()).isFalse();
    }

}
