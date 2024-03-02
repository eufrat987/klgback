package klg.backend.lukasz.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import klg.backend.lukasz.landlord.Landlord;
import klg.backend.lukasz.reservation.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false, name = "unit_price")
    private Double unitPrice;

    @NotNull
    @Column(nullable = false)
    private Integer surface;

    @NotNull
    @Lob
    @NotBlank
    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "landlord_id", nullable = false)
    private Landlord landlord;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "property")
    private List<Reservation> reservations = new ArrayList<>();


}
