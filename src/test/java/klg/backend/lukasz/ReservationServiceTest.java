package klg.backend.lukasz;

import klg.backend.lukasz.exception.ReservationRequestException;
import klg.backend.lukasz.reservation.Reservation;
import klg.backend.lukasz.reservation.ReservationRepository;
import klg.backend.lukasz.reservation.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @InjectMocks
    ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Test
    public void whenCreatingReservationStartAfterEnd_thenError() {
        var reservation = new Reservation(
                LocalDate.of(2000, 1, 4),
                LocalDate.of(2000, 1, 2),
                20.0
        );

        assertThatThrownBy(() -> reservationService.createReservation(reservation))
                .isInstanceOf(ReservationRequestException.class);

    }

    @Test
    public void whenCreatingReservationNoConflict_thenCorrect() {
        var reservation = new Reservation(
                LocalDate.of(2000, 1, 3),
                LocalDate.of(2000, 1, 6),
                20.0
        );
        given(reservationRepository.findDateIntersection(any(), any())).willReturn(Optional.empty());
        given(reservationRepository.save(any())).willReturn(reservation);

        assertThat(reservationService.createReservation(reservation)).isNotNull();
    }

    @Test
    public void whenCreatingReservationNoConflict2_thenCorrect() {
        var reservation = new Reservation(
                LocalDate.of(2000, 1, 3),
                LocalDate.of(2000, 1, 6),
                20.0
        );
        var reservation2 = new Reservation(
                LocalDate.of(2000, 1, 2),
                LocalDate.of(2000, 1, 3),
                20.0
        );

        given(reservationRepository.findDateIntersection(any(), any())).willReturn(Optional.of(reservation2));
        given(reservationRepository.save(any())).willReturn(reservation);

        assertThat(reservationService.createReservation(reservation)).isNotNull();
    }

    @Test()
    public void whenCreatingReservationConflict_thenFailure() {
        var reservation = new Reservation(
                LocalDate.of(2000, 1, 3),
                LocalDate.of(2000, 1, 6),
                20.0
        );
        var reservation2 = new Reservation(
                LocalDate.of(2000, 1, 2),
                LocalDate.of(2000, 1, 4),
                20.0
        );

        given(reservationRepository.findDateIntersection(any(), any())).willReturn(Optional.of(reservation2));

        assertThatThrownBy(() -> reservationService.createReservation(reservation))
                .isInstanceOf(ReservationRequestException.class);
    }

    @Test()
    public void whenCreatingReservationConflict2_thenFailure() {
        var reservation = new Reservation(
                LocalDate.of(2000, 1, 3),
                LocalDate.of(2000, 1, 6),
                20.0
        );
        var reservation2 = new Reservation(
                LocalDate.of(2000, 1, 2),
                LocalDate.of(2000, 1, 7),
                20.0
        );

        given(reservationRepository.findDateIntersection(any(), any())).willReturn(Optional.of(reservation2));

        assertThatThrownBy(() -> reservationService.createReservation(reservation))
                .isInstanceOf(ReservationRequestException.class);
    }

    @Test()
    public void whenCreatingReservationConflict3_thenFailure() {
        var reservation = new Reservation(
                LocalDate.of(2000, 1, 3),
                LocalDate.of(2000, 1, 6),
                20.0
        );
        var reservation2 = new Reservation(
                LocalDate.of(2000, 1, 2),
                LocalDate.of(2000, 1, 4),
                20.0
        );

        given(reservationRepository.findDateIntersection(any(), any())).willReturn(Optional.of(reservation2));

        assertThatThrownBy(() -> reservationService.createReservation(reservation))
                .isInstanceOf(ReservationRequestException.class);
    }

    @Test()
    public void whenCreatingReservationConflict4_thenFailure() {
        var reservation = new Reservation(
                LocalDate.of(2000, 1, 3),
                LocalDate.of(2000, 1, 6),
                20.0
        );
        var reservation2 = new Reservation(
                LocalDate.of(2000, 1, 4),
                LocalDate.of(2000, 1, 7),
                20.0
        );

        given(reservationRepository.findDateIntersection(any(), any())).willReturn(Optional.of(reservation2));

        assertThatThrownBy(() -> reservationService.createReservation(reservation))
                .isInstanceOf(ReservationRequestException.class);
    }

}
