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
@Table(name = "landlord", indexes = @Index(columnList = "name", unique = true))
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @JsonView(View.Internal.class)
    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "landlord")
    private List<Reservation> reservations = new ArrayList<>();

}
