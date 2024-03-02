package klg.backend.lukasz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "tenant")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "tenant")
    private Set<Reservation> reservations = new HashSet<>();

}
