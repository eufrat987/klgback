package klg.backend.lukasz.repository;

import klg.backend.lukasz.reservation.Reservation;
import klg.backend.lukasz.reservation.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void whenFindingCustomerById_thenCorrect() {
        reservationRepository.save(
                new Reservation(6, 12)
        );
        assertThat(reservationRepository.findById(1L)).isInstanceOf(Optional.class);
    }

    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        reservationRepository.save(
                new Reservation(6, 12)
        );
        reservationRepository.save(
                new Reservation(6, 12)
        );
        assertThat(reservationRepository.findAll()).isInstanceOf(List.class);
    }

}
