package klg.backend.lukasz.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "landlord")
public class Landlord { //todo join with tenant?

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "landlord_id")
    private long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "landlord")
    private Set<Reservation> reservations = new HashSet<>();

}
