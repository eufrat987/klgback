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
@Table(name = "tenant")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tenant_id")
    private long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @OneToMany(mappedBy = "tenant")
    private Set<Reservation> reservations = new HashSet<>();

}
