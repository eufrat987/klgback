package klg.backend.lukasz.controller;

import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.service.ReservationService;
import klg.backend.lukasz.repository.report.Report;
import klg.backend.lukasz.repository.report.ReportTenant;
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

    @GetMapping("/propertyReport/{id}")
    ResponseEntity<Report> getPropertyReport(@PathVariable("id") long id,
                                             @RequestParam("start")
                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                             @RequestParam("end")
                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new ResponseEntity<>(
                reservationService.getPropertyReport(startDate, endDate, id),
                HttpStatus.OK
        );
    }

    @GetMapping("/tenantsReport")
    ResponseEntity<List<ReportTenant>> getTenantsReport(@RequestParam("start")
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                  @RequestParam("end")
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new ResponseEntity<>(
                reservationService.getTenantsReport(startDate, endDate),
                HttpStatus.OK
        );
    }

    @PostMapping
    ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.createReservation(reservation), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Reservation> updateReservation(@PathVariable("id") long id, @RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.updateReservation(id, reservation), HttpStatus.OK);
    }

}
