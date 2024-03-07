package klg.backend.lukasz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(nullable = false, name = "unit_price")
    private Double unitPrice;

    @NonNull
    @Column(nullable = false)
    private Integer surface;

    @NonNull
    @Lob
    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "property")
    private List<Reservation> reservations = new ArrayList<>();

}
