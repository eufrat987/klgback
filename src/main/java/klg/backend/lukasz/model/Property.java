package klg.backend.lukasz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import klg.backend.lukasz.controller.view.View;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @JsonView(View.Internal.class)
    @Column(nullable = false)
    private String name;

    @NonNull
    @JsonView(View.Internal.class)
    @Column(nullable = false, name = "unit_price")
    private Double unitPrice; // todo ??

    @NonNull
    @JsonView(View.Internal.class)
    @Column(nullable = false)
    private Integer surface; // todo ??

    @NonNull
    @Lob
    @JsonView(View.Internal.class)
    @Column(nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "property")
    private List<Reservation> reservations = new ArrayList<>();

}
