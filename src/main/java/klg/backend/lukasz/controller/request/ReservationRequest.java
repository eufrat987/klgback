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
    private Long landlord_id;
    @NonNull
    private Long tenant_id;
    @NonNull
    private Long property_id;

    public Reservation map(Long id) {
        var reservation = map();
        reservation.setId(id);
        return reservation;
    }
    public Reservation map() {
        Reservation reservation = new Reservation(rentStart, rentEnd, cost, guests);
        var landlord = new Landlord();
        landlord.setId(landlord_id);
        var tenant = new Tenant();
        tenant.setId(tenant_id);
        var property = new Property();
        property.setId(property_id);
        reservation.setTenant(tenant);
        reservation.setLandlord(landlord);
        reservation.setProperty(property);
        return reservation;
    }
}
