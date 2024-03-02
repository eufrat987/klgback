package klg.backend.lukasz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "landlord")
public class Landlord { //todo join with tenant?

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(nullable = false)
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "landlord")
    private Set<Reservation> reservations = new HashSet<>();

}
