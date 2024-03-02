package klg.backend.lukasz.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import klg.backend.lukasz.landlord.Landlord;
import klg.backend.lukasz.property.Property;
import klg.backend.lukasz.tenant.Tenant;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @NotNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(nullable = false, name = "rent_start")
    private LocalDate rentStart;

    @NotNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(nullable = false, name = "rent_end")
    private LocalDate rentEnd;

    @NotNull
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
