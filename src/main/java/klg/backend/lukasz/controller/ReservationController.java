package klg.backend.lukasz.controller;

import klg.backend.lukasz.controller.request.ReservationRequest;
import klg.backend.lukasz.controller.response.ReportResponse;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.repository.queryresult.ReportPropertyQueryResult;
import klg.backend.lukasz.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    ResponseEntity<List<Reservation>> getReservations() {
        return new ResponseEntity<>(reservationService.getReservations(), HttpStatus.OK);
    }

    @GetMapping("/propertyReport/{name}")
    ResponseEntity<ReportPropertyQueryResult> getPropertyReport(@PathVariable("name") String name,
                                                                @RequestParam("start")
                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                @RequestParam("end")
                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new ResponseEntity<>(
                reservationService.getPropertyReport(startDate, endDate, name),
                HttpStatus.OK
        );
    }

    @GetMapping("/tenantsReport")
    ResponseEntity<ReportResponse> getTenantsReport(@RequestParam("start")
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                    @RequestParam("end")
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new ResponseEntity<>(
                reservationService.getTenantsReport(startDate, endDate),
                HttpStatus.OK
        );
    }

    @PostMapping
    ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest reservation) {
        return new ResponseEntity<>(reservationService.createReservation(reservation.map()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Reservation> updateReservation(@PathVariable("id") long id, @RequestBody ReservationRequest reservation) {
        return new ResponseEntity<>(reservationService.updateReservation(id, reservation.map(id)), HttpStatus.OK);
    }

}
