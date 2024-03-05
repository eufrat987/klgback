package klg.backend.lukasz.service;

import klg.backend.lukasz.controller.response.ReportResponse;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.repository.queryresult.ReportPropertyQueryResult;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    public List<Reservation> getReservations();
    public Reservation createReservation(Reservation reservation);
    public Reservation updateReservation(long id, Reservation reservation);
    public ReportPropertyQueryResult getPropertyReport(LocalDate start, LocalDate end, long id);
    public ReportResponse getTenantsReport(LocalDate start, LocalDate end);
}
