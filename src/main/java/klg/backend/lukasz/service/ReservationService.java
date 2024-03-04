package klg.backend.lukasz.service;

import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.repository.queryresult.Report;
import klg.backend.lukasz.repository.queryresult.ReportTenant;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    public List<Reservation> getReservations();
    public Reservation createReservation(Reservation reservation);
    public Reservation updateReservation(long id, Reservation reservation);
    public Report getPropertyReport(LocalDate start, LocalDate end, long id);
    public List<ReportTenant> getTenantsReport(LocalDate start, LocalDate end);
}
