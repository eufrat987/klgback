package klg.backend.lukasz.property;

import klg.backend.lukasz.property.report.Report;
import klg.backend.lukasz.property.report.ReportRequest;
import klg.backend.lukasz.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping
    ResponseEntity<List<Property>> getProperties() {
        return new ResponseEntity<>(propertyService.getProperties(), HttpStatus.OK);
    }

    @GetMapping("/{id}/reservations")
    ResponseEntity<List<Reservation>> getPropertyReservations(@PathVariable("id") long id) {
        return new ResponseEntity<>(propertyService.getPropertyReservations(id), HttpStatus.OK);

    }

    @GetMapping("/{id}/report")
    ResponseEntity<Report> getPropertyReport(@PathVariable("id") long id, @RequestBody ReportRequest reportRequest) {
        return new ResponseEntity<>(
                propertyService.getReport(reportRequest.getStart(), reportRequest.getEnd()),
                HttpStatus.OK
        );
    }

    @PostMapping
    ResponseEntity<Property> createProperty(@RequestBody Property property) {
        return new ResponseEntity<>(propertyService.createProperty(property), HttpStatus.OK);
    }

}
