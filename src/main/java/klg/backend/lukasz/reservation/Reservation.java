package klg.backend.lukasz.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import klg.backend.lukasz.landlord.Landlord;
import klg.backend.lukasz.tenant.Tenant;
import klg.backend.lukasz.property.Property;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(nullable = false, name = "rent_start")
    private LocalDate rentStart;

    @NonNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(nullable = false, name = "rent_end")
    private LocalDate rentEnd;

    @NonNull
    @Column(nullable = false)
    private Double cost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "landlord_id", nullable = false)
    private Landlord landlord;

    @ManyToOne(optional = false)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tenant_id", nullable = false) //todo can be in tenant diff?
    private Tenant tenant;

}
