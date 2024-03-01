package klg.backend.lukasz;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import lombok.NonNull;


@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "customers", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(nullable = false)
    private String email;

}