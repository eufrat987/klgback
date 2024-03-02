package klg.backend.lukasz;

import klg.backend.lukasz.reservation.Reservation;
import klg.backend.lukasz.reservation.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ReservationServiceTest {

    @Autowired
    ReservationService reservationService;

    @Test
    public void test2() {
        List<Reservation> reservations = reservationService.getReservations();
        assertThat(reservations.size()).isEqualTo(1);
    }

}
