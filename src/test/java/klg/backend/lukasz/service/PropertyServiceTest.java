package klg.backend.lukasz.service;

import jakarta.transaction.Transactional;
import klg.backend.lukasz.model.Reservation;
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
        List<Reservation> reservations = propertyService.getPropertyReservations("Dom nad jeziorem");
        assertThat(reservations.isEmpty()).isFalse();
    }

}
