package klg.backend.lukasz.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(nullable = false, name = "rental_period")
    private Integer rentalPeriod; //todo change

    @NonNull
    @Column(nullable = false)
    private Double cost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "landlord_id", nullable = false)
    private Landlord landlord;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tenant_id", nullable = false) //todo can be in tenant diff?
    private Tenant tenant;

    /*

    – With @OneToMany, we cannot limit the size of that collection, for example, in case of pagination.
    – With @ManyToOne, you can modify the Repository:
        to work with Pagination
        or to sort/order by multiple fields
     */
}
