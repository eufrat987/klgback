package klg.backend.lukasz.controller.request;

import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.model.Property;
import klg.backend.lukasz.model.Reservation;
import klg.backend.lukasz.model.Tenant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    @NonNull
    private LocalDate rentStart;
    @NonNull
    private LocalDate rentEnd;
    @NonNull
    private Double cost;
    @NonNull
    private Integer guests;
    @NonNull
    private String landlord;
    @NonNull
    private String tenant;
    @NonNull
    private String property;

    public Reservation map(Long id) {
        var reservation = map();
        reservation.setId(id);
        return reservation;
    }
    public Reservation map() {
        Reservation reservation = new Reservation(rentStart, rentEnd, cost, guests);
        var landlordEntity = new Landlord();
        landlordEntity.setName(landlord);
        var tenantEntity = new Tenant();
        tenantEntity.setName(tenant);
        var propertyEntity = new Property();
        propertyEntity.setName(property);
        reservation.setTenant(tenantEntity);
        reservation.setLandlord(landlordEntity);
        reservation.setProperty(propertyEntity);
        return reservation;
    }
}
