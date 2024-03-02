package klg.backend.lukasz.landlord;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import klg.backend.lukasz.property.Property;
import klg.backend.lukasz.reservation.Reservation;
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
@Table(name = "landlord")
public class Landlord { //todo join with tenant? index?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "landlord")
    private List<Reservation> reservations = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "landlord")
    private List<Property> properties = new ArrayList<>();

}
