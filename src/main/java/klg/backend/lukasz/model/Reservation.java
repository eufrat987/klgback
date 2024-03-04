package klg.backend.lukasz.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "reservation", indexes = {@Index(columnList = "rent_start"), @Index(columnList = "rent_end")})
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "rent_start")
    private LocalDate rentStart;

    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "rent_end")
    private LocalDate rentEnd;

    @NonNull
    @Column(nullable = false)
    private Double cost;

    @NonNull
    @Column(nullable = false)
    private Integer guests;

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
